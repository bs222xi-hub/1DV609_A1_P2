package DiceGame;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        Player p1 = new Player("Alen");
        Player p2 = new Player("Bogdan");
        WinSorting leaderBoard = new WinSorting();

        ScoreBoard scores = new ScoreBoard();
        Game game = new Game(dice, p1, p2, scores, leaderBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dice game! ");
        game.playTheGame(scanner::nextLine);
        scanner.close();

    }


}

