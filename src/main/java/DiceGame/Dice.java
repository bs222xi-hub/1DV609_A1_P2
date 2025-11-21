package DiceGame;

public class Dice {
    private final int sides;

    public Dice(int sides) throws IllegalArgumentException {
        if (sides < 2) {
            throw new IllegalArgumentException("Dice must have at least 2 sides");
        }
        this.sides = sides;
    }

    public int rollDice() {
        return (int) (Math.random() * sides) + 1;
    }

    public int getSides() {
        return sides;
    }

}
