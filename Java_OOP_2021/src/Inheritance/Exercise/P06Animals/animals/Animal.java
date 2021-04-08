package Inheritance.Exercise.P06Animals.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equals("")){
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(String.format("%s %d %s",
                        this.getName(),
                        this.getAge(),
                        this.getGender()))
        .append(System.lineSeparator())
        .append(produceSound())
        .append(System.lineSeparator());
        return sb.toString().trim();
    }

    public String produceSound(){
        return "";
    }
}