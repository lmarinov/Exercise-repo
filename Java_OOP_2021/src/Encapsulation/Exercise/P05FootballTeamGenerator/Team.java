package Encapsulation.Exercise.P05FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private static final double DEFAULT_RATING = 0.0;


    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalStateException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player playerToRemove = null;
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                playerToRemove = player;
            }
        }

        if (playerToRemove == null){
            throw new IllegalStateException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }

        this.players.remove(playerToRemove);
    }

    public double getRating() {
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(DEFAULT_RATING);
    }
}
