package Encapsulation.Exercise.P05FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        List<Team> teams = new ArrayList<>();


        while (!"END".equals(line = bufferedReader.readLine())) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            try {
                switch (command) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.add(team);
                        break;
                    case "Add":
                        String addedPlayerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);

                        Team matchingTeamForAddition = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElseThrow(nonExistentTeam(teamName));
                        Player playerToAdd = new Player(addedPlayerName, endurance, sprint, dribble, passing, shooting);
                        matchingTeamForAddition.addPlayer(playerToAdd);
                        break;
                    case "Remove":
                        String removedPlayerName = tokens[2];

                        Team matchingTeamForRemoval = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElseThrow(nonExistentTeam(teamName));
                        matchingTeamForRemoval.removePlayer(removedPlayerName);
                        break;
                    case "Rating":
                        Team matchingTeamToExtractRating = teams.stream().filter(t -> t.getName().equals(teamName)).findFirst().orElseThrow(nonExistentTeam(teamName));
                        System.out.printf("%s - %.0f%n", teamName, matchingTeamToExtractRating.getRating());
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Supplier<IllegalStateException> nonExistentTeam(String teamName) {
        return () -> new IllegalStateException(String.format("Team %s does not exist.", teamName));
    }
}
