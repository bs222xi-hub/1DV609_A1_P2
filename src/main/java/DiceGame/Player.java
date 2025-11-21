package DiceGame;

public class Player {
    private final String name;
    private int  score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void playerScores(int value) {
        this.score += value;
    }


}
