package DiceGame;

public class Game {

    private final Dice dice;
    private final Player p1;
    private final Player p2;
    private final ScoreBoard scoreBoard;
    private final WinSorting leaderBoard;

    public Game(Dice dice, Player p1, Player p2, ScoreBoard scoreBoard, WinSorting leaderBoard) {
        this.dice = dice;
        this.p1 = p1;
        this.p2 = p2;
        this.scoreBoard = scoreBoard;
        this.leaderBoard = leaderBoard;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public void Rounds(OutputProvider output) {
        int r1 = dice.rollDice();
        int r2 = dice.rollDice();
        p1.playerScores(r1);
        p2.playerScores(r2);

        leaderBoard.addPlayers(p1);
        leaderBoard.addPlayers(p2);
        leaderBoard.printLeader();

    }

    public String getWinner() {
        return scoreBoard.getWinner(p1, p2);
    }

    public void playTheGame(InputProvider inputProvider, OutputProvider output) {
        int round = 1;
        boolean running = true;
        while (running) {
            output.print("Enter P to play Q to quit");
            String input = inputProvider.getInput();

            if (input.equalsIgnoreCase("P")) {
                output.print("Playing round: " + round);
                Rounds(output);
                output.print(p1.getName() + " scores:" + p1.getScore());
                output.print(p2.getName() + " scores:" + p2.getScore());
                round++;
            } else if (input.equalsIgnoreCase("Q")) {
                output.print("Game Over. Winner is: " + getWinner());
                running = false;
            } else {
                output.print("Invalid input!");
            }
        }
    }
}
