package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.Engineer;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Private;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Soldier;
import Abstraction.Exercise.P06MilitaryElite.interfaces.SpecialisedSoldier;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class EngineerImpl extends  SpecialisedSoldierImpl implements Engineer, SpecialisedSoldier, Private, Soldier {
    private LinkedHashSet<Repair> repairs;
    private static final LinkedHashSet<Repair> DEFAULT_REPAIRS = new LinkedHashSet<>();

    public static class Repair{
        private String partName;
        private int hoursWorked;

        public Repair(String partName, int hoursWorked) {
            this.partName = partName;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public String toString() {
            return String.format("Part Name: %s Hours Worked: %d",
                    this.partName,
                    this.hoursWorked);
        }
    }

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.setRepairs();
    }


    @Override
    public LinkedHashSet<Repair> getRepairs() {
        return this.repairs;
    }

    private void setRepairs() {
        this.repairs = EngineerImpl.DEFAULT_REPAIRS;
    }

    @Override
    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());
        out.append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());
        for (Repair repair : this.repairs) {
            out.append("  ")
                    .append(repair.toString())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
