package ExamPreparationI.viceCity.models.neighbourhood;

import ExamPreparationI.viceCity.models.players.Player;

import java.util.Collection;

public interface Neighbourhood {
    void action(Player mainPlayer, Collection<Player> civilPlayers);
}
