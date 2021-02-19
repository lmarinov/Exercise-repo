package DefiningClasses.Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parent> parents;
    private List<Child> children;

    public static class Company{
        private String companyName;
        private String department;
        private double salary;

        public Company (){
            this("", "", 0.0);
        }

        public Company(String companyName) {
            this(companyName, "", 0.0);
        }

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }

        public String getCompanyName() {
            return companyName;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    public static class Pokemon{
        private String pokemonName;
        private String pokemonType;

        public Pokemon() {
            this("", "");
        }

        public Pokemon(String pokemonName) {
           this(pokemonName, "");
        }

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }

        public String getPokemonName() {
            return pokemonName;
        }

        public String getPokemonType() {
            return pokemonType;
        }

        public void setPokemonName(String pokemonName) {
            this.pokemonName = pokemonName;
        }

        public void setPokemonType(String pokemonType) {
            this.pokemonType = pokemonType;
        }
    }

    public static class Parent{
        private String parentName;
        private String parentBirthday;

        public Parent() {
            this("", "");
        }

        public Parent(String parentName) {
            this(parentName, "");
        }

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }

        public String getParentName() {
            return parentName;
        }

        public String getParentBirthday() {
            return parentBirthday;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public void setParentBirthday(String parentBirthday) {
            this.parentBirthday = parentBirthday;
        }
    }

    public static class Child{
        private String childName;
        private String childBirthday;

        public Child() {
            this("", "");
        }

        public Child(String childName) {
            this(childName, "");
        }

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }

        public String getChildName() {
            return childName;
        }

        public String getChildBirthday() {
            return childBirthday;
        }

        public void setChildName(String childName) {
            this.childName = childName;
        }

        public void setChildBirthday(String childBirthday) {
            this.childBirthday = childBirthday;
        }
    }

    public static class Car{
        private String carModel;
        private int carSpeed;

        public Car() {
            this("", 0);
        }

        public Car(String carModel) {
            this(carModel, 0);
        }

        public Car(String carModel, int carSpeed) {
            this.carModel = carModel;
            this.carSpeed = carSpeed;
        }

        public String getCarModel() {
            return carModel;
        }

        public int getCarSpeed() {
            return carSpeed;
        }

        public void setCarModel(String carModel) {
            this.carModel = carModel;
        }

        public void setCarSpeed(int carSpeed) {
            this.carSpeed = carSpeed;
        }
    }

    public Person(String name) {
        this(name, null, null);
    }

    public Person(String name, Car car, Company company) {
        this.name = name;
        this.car = car;
        this.company = company;
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
