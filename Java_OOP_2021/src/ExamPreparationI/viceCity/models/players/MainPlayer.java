package ExamPreparationI.viceCity.models.players;

public class MainPlayer extends BasePlayer{
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";
    private static final int DEFAULT_LIFE_POINTS = 100;

    public MainPlayer() {
        super(MAIN_PLAYER_NAME, DEFAULT_LIFE_POINTS);
    }
}
