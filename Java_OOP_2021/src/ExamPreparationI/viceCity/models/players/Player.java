package ExamPreparationI.viceCity.models.players;

import ExamPreparationI.viceCity.models.guns.Gun;
import ExamPreparationI.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
