package Exam20Feb2021.P03CarDealership.dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public void add(Car car){
        if (capacity > 0){
            this.getData().add(car);
            capacity--;
        }
    }

    public boolean buy(String manufacturer, String model){
        boolean result = this.getData().stream()
                .anyMatch(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));

        if (result){
            this.getData().remove(this.getData().stream()
                    .filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null));
            capacity++;
        }

        return result;
    }

    public Car getLatestCar(){
        return this.getData().stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        return this.getData().stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount(){
       return this.getData().size();
    }

    public String getStatistics(){
        return String.format("The cars are in a car dealership %s:%n%s",
                this.getName(),
                this.getData().stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator())));
    }
}
