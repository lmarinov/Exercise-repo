package ExamPreparationI.viceCity.core;

import ExamPreparationI.viceCity.models.guns.Gun;
import ExamPreparationI.viceCity.models.guns.Pistol;
import ExamPreparationI.viceCity.models.guns.Rifle;
import ExamPreparationI.viceCity.models.neighbourhood.GangNeighbourhood;
import ExamPreparationI.viceCity.models.neighbourhood.Neighbourhood;
import ExamPreparationI.viceCity.models.players.CivilPlayer;
import ExamPreparationI.viceCity.models.players.Player;
import ExamPreparationI.viceCity.core.interfaces.Controller;
import ExamPreparationI.viceCity.models.players.MainPlayer;

import java.util.*;
import java.util.stream.Collectors;

import static ExamPreparationI.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private Map<String, Player> players;
    private Deque<Gun> guns;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new LinkedHashMap<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        players.put(name, new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;

        switch (type){
            case "Rifle":
                gun = new Rifle(name);
                break;
            case "Pistol":
                gun = new Pistol(name);
                break;
            default:
                return GUN_TYPE_INVALID;
        }

        guns.offer(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.peek();

        if (gun == null){
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")){
            mainPlayer.getGunRepository().add(gun);
            guns.poll();
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player player = players.get(name);

        if (player == null){
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }

        player.getGunRepository().add(gun);
        guns.poll();

        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, players.values());

        if (mainPlayer.getLifePoints() == 100 && players
                .values()
                .stream()
                .allMatch(p -> p.getLifePoints() == 50)){
            return FIGHT_HOT_HAPPENED;
        }

        List<Player> deadPlayers = players.values()
                .stream()
                .filter(p -> !p.isAlive())
                .collect(Collectors.toList());

        StringBuilder out = new StringBuilder(FIGHT_HAPPENED);

        out.append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size()))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, players.size() - deadPlayers.size()));


        for (Player deadPlayer : deadPlayers) {
            players.remove(deadPlayer.getName());
        }

        return out.toString().trim();
    }
}
