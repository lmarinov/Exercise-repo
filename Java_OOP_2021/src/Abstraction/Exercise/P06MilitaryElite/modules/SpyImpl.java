package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.Soldier;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy, Soldier {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s", super.toString(), this.getCodeNumber());
    }
}
