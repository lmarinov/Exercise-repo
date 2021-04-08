package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.Private;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Soldier;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.getSalary());
    }
}
