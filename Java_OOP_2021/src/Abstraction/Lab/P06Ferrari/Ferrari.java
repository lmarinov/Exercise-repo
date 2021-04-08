package Abstraction.Lab.P06Ferrari;

public class Ferrari implements Car{
    private final String DEFAULT_CAR_MODEL = "488-Spider";
    private String driverName;
    private String model;

    public Ferrari(String driverName) {
        this.setDriverName(driverName);
        this.setModel(DEFAULT_CAR_MODEL);
    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model,
                this.brakes(),
                this.gas(),
                this.driverName);
    }
}
