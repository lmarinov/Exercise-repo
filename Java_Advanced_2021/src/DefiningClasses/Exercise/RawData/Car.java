package DefiningClasses.Exercise.RawData;

public class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre[] tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyre[] tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyre[] getTyres() {
        return tyres;
    }

    public boolean hasTyreWithLessPressureThanOne(){
        for (Tyre tyre : tyres) {
            if (tyre.getPressure() < 1){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return this.model;
    }
}
