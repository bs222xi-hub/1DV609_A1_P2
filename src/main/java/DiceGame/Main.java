package DiceGame;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice(6);
        Player p1 = new Player("Alen");
        Player p2 = new Player("Bogdan");
        ScoreBoard scores = new ScoreBoard();
        Game game = new Game(dice, p1, p2, scores);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the dice game! ");
        IntStream.range(1, 6)
                .forEach(round -> {
                    System.out.println("Enter P to play and Q to quit: ");
                    String input = scanner.nextLine();

                    if (input.equalsIgnoreCase("P")) {
                        System.out.println(
                                "Playing round " + round
                        );
                        game.Rounds();
                        System.out.println(p1.getName() + " scores: " + p1.getScore());
                        System.out.println(p2.getName() + " scores: " + p2.getScore());

                    } else if (input.equalsIgnoreCase("q")) {
                        System.out.println("Game over! Winner: " + game.getWinner());

                        System.exit(0);
                    } else {
                        System.out.println("Invalid input. Enter P to play Q to quit");
                    }


                });
        scanner.close();


    }


}

