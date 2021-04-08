package ExamPreparationI.viceCity.models.neighbourhood;

import ExamPreparationI.viceCity.models.guns.Gun;
import ExamPreparationI.viceCity.models.players.Player;
import ExamPreparationI.viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        Deque<Player> players = new ArrayDeque<>(civilPlayers);
        Deque<Gun> guns = new ArrayDeque<>(gunRepository.getModels());

        Player currentPlayer = players.poll();
        Gun gun = guns.poll();

        while (currentPlayer != null && gun != null){
            while (gun.canFire() && currentPlayer.isAlive()) {
                int fire = gun.fire();
                currentPlayer.takeLifePoints(fire);
            }

            if (gun.canFire()){
                currentPlayer = players.poll();
            }else if (currentPlayer.isAlive()){
                gun = guns.poll();
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.isAlive()){
                Deque<Gun> playerGuns = new ArrayDeque<>(civilPlayer.getGunRepository().getModels());
                Gun playerGun = playerGuns.poll();

                while (playerGun != null){
                    while (playerGun.canFire()&& mainPlayer.isAlive()) {
                        int fire = playerGun.fire();
                        mainPlayer.takeLifePoints(fire);
                    }

                    if (!mainPlayer.isAlive()){
                        return;
                    }

                    playerGun = playerGuns.poll();
                }
            }
        }
    }
}
