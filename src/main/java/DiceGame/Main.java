package DiceGame;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        Player p1 = new Player("Alen");
        Player p2 = new Player("Bogdan");
        WinSorting leaderBoard = new WinSorting();
        leaderBoard.loadFromFile("scores.json");
        ScoreBoard scores = new ScoreBoard();
        Game game = new Game(dice, p1, p2, scores, leaderBoard);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dice game! ");
        game.playTheGame(scanner::nextLine, System.out::println);

        scanner.close();

        leaderBoard.saveScoreToJson("scores.json");
        System.out.println("Final leaderBoard:");
        leaderBoard.printLeader();
    }


}

