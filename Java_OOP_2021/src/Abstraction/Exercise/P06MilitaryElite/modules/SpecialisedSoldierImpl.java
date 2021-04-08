package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.Private;
import Abstraction.Exercise.P06MilitaryElite.interfaces.Soldier;
import Abstraction.Exercise.P06MilitaryElite.interfaces.SpecialisedSoldier;

import java.util.Arrays;
import java.util.Locale;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier{
    private enum Corps{
        AIRFORCES("Airforces"), MARINES("Marines");

        private final String corps;

        Corps(String corps){
            this.corps = corps;
        }

        public String getCorps(){
            return corps;
        }
    }
    private Corps corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    @Override
    public String getCorps() {
        return this.corp.getCorps();
    }

    public void setCorp(String corp) {
        if (Arrays.stream(Corps.values()).noneMatch(e -> e.getCorps().equals(corp))){
            throw new IllegalStateException("Invalid corps.");
        }
        this.corp = Corps.valueOf(corp.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
