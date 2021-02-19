package JavaAdvancedExam22Feb2020.P3Guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void addPlayer(Player player){
        if (capacity > 0){
            this.roster.add(player);
            this.capacity--;
        }
    }

    public boolean removePlayer(String name){
        int index = -1;
        for (Player player : roster) {
            if (player.getName().equals(name)){
                index = roster.indexOf(player);
            }
        }
        if (index >= 0){
            roster.remove(index);
            return true;
        }else{
            return false;
        }
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                if(player.getRank().equals("Trial")){
                    player.setRank("Member");
                }else{
                    return;
                }
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                if(player.getRank().equals("Member")){
                    player.setRank("Trial");
                }else{
                    return;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        List<Player> playersKicked = new ArrayList<>();

        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                playersKicked.add(player);
            }
        }

        for (Player player : playersKicked) {
            removePlayer(player.getName());
        }

        return playersKicked.toArray(Player[]::new);
    }

    public int count(){
       return this.getRoster().size();
    }

    public String report(){
        return String.format("Players in the guild: %s:%n%s",
                this.getName(),
                this.getRoster().stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}
