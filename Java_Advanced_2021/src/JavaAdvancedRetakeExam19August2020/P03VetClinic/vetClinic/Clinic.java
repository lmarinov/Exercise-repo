package JavaAdvancedRetakeExam19August2020.P03VetClinic.vetClinic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet){
        if (capacity > 0){
            this.getData().add(pet);
            capacity--;
        }
    }

    public boolean remove(String name){
        boolean result = this.getData().remove(this.getData().stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null));
        if (result) {
            capacity++;
        }
        return result;
    }

    public Pet getPet(String name, String owner){
        return this.getData().stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public Pet getOldestPet(){
        return this.getData().stream().min((first, second) -> Integer.compare(second.getAge(), first.getAge())).orElse(null);
        // second method: this.getData().stream().max(Comparator.comparingInt(Pet::getAge)).orElse(null);
    }

    public int getCount(){
        return this.getData().size();
    }

    public String getStatistics(){
        return String.format("The clinic has the following patients:%n%s",
                this.getData().stream()
                .map(pet -> String.format("%s %s", pet.getName(), pet.getOwner()))
                        .collect(Collectors.joining(System.lineSeparator())));
    }

}
