package DefiningClasses.Exercise.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = "";
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        while(!"Tournament".equals(line = scanner.nextLine())){
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainers.get(trainerName).getPokemons().add(pokemon);
        }

        while (!"End".equals(line = scanner.nextLine())){
            for (Trainer trainer : trainers.values()) {
                String currentLine = line;
                boolean hasPokemon = trainer.getPokemons().stream().anyMatch(e -> e.getElement().equals(currentLine));
                if (hasPokemon){
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                }else{
                    trainer.getPokemons().forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
//                    ArrayDeque<Integer> indexes = new ArrayDeque<>();
//                    trainer.getPokemons().forEach(pokemon -> {
//                        if (pokemon.getHealth() <= 0){
//                            int index = trainer.getPokemons().indexOf(pokemon);
//                            indexes.offer(index);
//                        }
//                    });
//
//                    int size = indexes.size();
//
//                    for (int i = 0; i < size; i++) {
//                        trainer.getPokemons().remove((int)indexes.poll());
//                    }

                    trainer.setPokemons(trainer.getPokemons().stream().filter(pokemon ->
                            pokemon.getHealth() > 0).collect(Collectors.toList()));
                }
            }

        }

        trainers.entrySet().stream().sorted((trainer1, trainer2) -> {
            if (trainer1.getValue().getNumberOfBadges() == trainer2.getValue().getNumberOfBadges()){
                return 0;
            }else{
                return Integer.compare(trainer2.getValue().getNumberOfBadges(), trainer1.getValue().getNumberOfBadges());
            }
        })
                .forEach(trainer -> System.out.printf("%s %d %d%n",
                        trainer.getValue().getName(),
                        trainer.getValue().getNumberOfBadges(),
                        trainer.getValue().getPokemons().size()));

    }
}
