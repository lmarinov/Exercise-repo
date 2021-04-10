package aquarium.core;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium = null;
        switch (aquariumType){
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration = null;
        switch (type){
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }
        this.decorationRepository.add(decoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium targetAquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        Decoration targetDecoration = this.decorationRepository.findByType(decorationType);

        if (targetDecoration == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_DECORATION_FOUND, decorationType));
        }

        assert targetAquarium != null;
        targetAquarium.addDecoration(targetDecoration);
        this.decorationRepository.remove(targetDecoration);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish currentFish = null;
        Aquarium targetAquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        switch (fishType){
            case "FreshwaterFish":
                currentFish = new FreshwaterFish(fishName, fishType, price);
                break;
            case "SaltwaterFish":
                currentFish = new SaltwaterFish(fishName, fishType, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }

        if (!(currentFish.getSpecies().equals("FreshwaterFish")
                && targetAquarium.getClass().getSimpleName().equals("FreshwaterAquarium"))
                && !(currentFish.getSpecies().equals("SaltwaterFish")
                && targetAquarium.getClass().getSimpleName().equals("SaltwaterAquarium"))){
            return ConstantMessages.WATER_NOT_SUITABLE;
        }

        targetAquarium.addFish(currentFish);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium targetAquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        assert targetAquarium != null;
        int fishFed = targetAquarium.getFish().size();
        targetAquarium.getFish().forEach(Fish::eat);

        return String.format(ConstantMessages.FISH_FED, fishFed);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium targetAquarium = this.aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
        assert targetAquarium != null;
        double fishValue = targetAquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationValue = targetAquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();

        return String.format(ConstantMessages.VALUE_AQUARIUM, aquariumName, fishValue + decorationValue);
    }

    @Override
    public String report() {
        return this.aquariums.stream().map(Aquarium::getInfo).collect(Collectors.joining(System.lineSeparator()));
    }
}
