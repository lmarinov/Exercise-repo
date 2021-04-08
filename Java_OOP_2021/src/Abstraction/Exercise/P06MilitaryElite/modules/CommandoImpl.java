package Abstraction.Exercise.P06MilitaryElite.modules;

import Abstraction.Exercise.P06MilitaryElite.interfaces.Commando;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private LinkedHashSet<Mission> missions;

    private enum States {
        INPROGRES("inProgress"),
        FINISHED("Finished");

        private String state;

        States(String state) {
            this.state = state;
        }

        public String getState() {
            return this.state;
        }
    }

    private static final LinkedHashSet<Mission> DEFAULT_MISSIONS = new LinkedHashSet<>();

    public static class Mission {
        private String codeName;
        private States state;

        public Mission(String codeName, String state) {
            this.setCodeName(codeName);
            this.setState(state);
        }

        public String getCodeName() {
            return this.codeName;
        }

        public States getState() {
            return this.state;
        }

        public void setCodeName(String codeName) {
            this.codeName = codeName;
        }

        private void setState(String state) {
            if (state.equals(States.FINISHED.getState())) {
                completeMission();
            } else if (state.equals(States.INPROGRES.getState())) {
                this.state = States.INPROGRES;
            } else {
                throw new IllegalStateException("Invalid operation state.");
            }
        }

        public void completeMission() {
            this.state = States.FINISHED;
        }

        @Override
        public String toString() {
            return String.format("Code Name: %s State: %s",
                    this.getCodeName(),
                    this.getState().state);
        }
    }

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.setMissions(DEFAULT_MISSIONS);
    }

    @Override
    public LinkedHashSet<Mission> getMissions() {
        return this.missions;
    }

    public void setMissions(LinkedHashSet<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());
        out.append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());

        for (Mission mission : missions) {
            out.append("  ")
                    .append(mission.toString())
                    .append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
