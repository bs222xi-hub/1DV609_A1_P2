package DiceGame;

import java.util.Scanner;

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

    public void Rounds() {
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

    public void playTheGame(InputProvider inputProvider) {
        int round = 1;
        while (true) {
            System.out.println("Enter P to play Q to quit!");
            String input = inputProvider.getInput();

            if (input.equalsIgnoreCase("P")) {
                System.out.println("Playing round: " + round);
                Rounds();
                System.out.println(p1.getName() + " scores:" + p1.getScore());
                System.out.println(p2.getName() + " scores:" + p2.getScore());
                round++;
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("Game Over. Winner is: " + getWinner());
                return;
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
