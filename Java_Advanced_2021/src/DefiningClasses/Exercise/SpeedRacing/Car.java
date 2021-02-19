package DefiningClasses.Exercise.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private String model;
    private Map<String, CarInfo> cars = new LinkedHashMap<>();

    public static class CarInfo {
        private double fuelAmount;
        private double fuelCost;
        private int distanceTraveled = 0;

        public CarInfo(double fuelAmount, double fuelCost) {
            this.fuelAmount = fuelAmount;
            this.fuelCost = fuelCost;
        }

        public int getDistanceTraveled(){
            return distanceTraveled;
        }

        public double getFuelAmount() {
            return fuelAmount;
        }

        public double getFuelCost() {
            return fuelCost;
        }

        public void setFuelAmount(double fuelAmount) {
            this.fuelAmount = fuelAmount;
        }

        public void setFuelCost(double fuelCost) {
            this.fuelCost = fuelCost;
        }

        public void drive(int distanceToTravel){
            if (this.getFuelAmount() >= distanceToTravel * this.getFuelCost()){
                this.fuelAmount -= distanceToTravel * this.getFuelCost();
                this.distanceTraveled += distanceToTravel;
            }else{
                System.out.println("Insufficient fuel for the drive");
            }
        }
    }

    public Car(String model, CarInfo carInfo) {
        this.model = model;
    }

    public Car(){

    }

    public String getModel() {
        return model;
    }

    public Map<String, CarInfo> getCars() {
        return cars;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCars(Map<String, CarInfo> cars) {
        this.cars = cars;
    }

    public void add(String model, CarInfo carInfo){
        this.cars.putIfAbsent(model, null);
        this.cars.put(model, carInfo);
    }

    public void clear(){
        this.cars.clear();
    }
}
