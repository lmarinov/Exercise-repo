package Encapsulation.Lab.SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        if (this.getAge() < 30){
            this.salary = this.getSalary() + this.getSalary() / 2 * (percentage / 100);
        }else{
            this.salary = this.getSalary() * (1 + percentage / 100);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
