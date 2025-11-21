package DiceGame;

public class ScoreBoard {

    public String getWinner(Player p1, Player p2){
        if (p1.getScore()>p2.getScore()) return p1.getName();
        if (p2.getScore()>p1.getScore()) return p2.getName();
        return "TIE";
    }
}
