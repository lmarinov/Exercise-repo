package Encapsulation.Exercise.P05FootballTeamGenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalStateException("A name should not be empty.");
        }else{
            this.name = name;
        }
    }

    private void setEndurance(int endurance) {
        validateIntField("Endurance", endurance);
        this.endurance = endurance;

    }

    private void setSprint(int sprint) {
        validateIntField("Sprint", sprint);
        this.sprint = sprint;

    }

    private void setDribble(int dribble) {
        validateIntField("Dribble", dribble);
        this.dribble = dribble;

    }

    private void setPassing(int passing) {
        validateIntField("Passing", passing);
        this.passing = passing;

    }

    private void setShooting(int shooting) {
        validateIntField("Shooting", shooting);
        this.shooting = shooting;

    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting) / 5.0;
    }

    private void validateIntField(String statName, Integer field) {
        if (field < 0 || field > 100) {
            throw new IllegalStateException(String.format("%s should be between 0 and 100.", statName));
        }
    }
}
