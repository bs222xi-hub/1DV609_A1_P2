package DiceGame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WinSorting {

    private final List<Player> players;


    public WinSorting() {
        this.players = new ArrayList<>();
    }

    public void addPlayers(Player player){
        int index = binarySearch(player.getName());

        if (index>=0){
            Player existing = players.get(index);
            existing.playerScores(player.getScore());
        }else {
            players.add(player);
        }
    }
    //sorting players by name
    private int binarySearch(String name){
        players.sort(Comparator.comparing(Player::getName));
        int low = 0;
        int high  = players.size()-1;

        while (low <= high){
            int mid = (low + high)/2;
            Player midPlay = players.get(mid);
            int cmp = midPlay.getName().compareTo(name);
            if (cmp==0)return mid;
            if(cmp<0) low = mid +1;
            else high=mid-1;
        }
        return -1;
    }

    public List<Player> getPlayersByScore(){
        List<Player> sorted = new ArrayList<>(players);
        sorted.sort((p1, p2)-> Integer.compare(p2.getScore(), p1.getScore()));
        return sorted;
    }

    public void printLeader() {
        System.out.println("\n===== Leaderboard =====");
        System.out.printf("%-10s | %s%n", "Player", "Score");
        System.out.println("-----------------------");
        for (Player p : getPlayersByScore()) {
            System.out.printf("%-10s | %d%n", p.getName(), p.getScore());
        }
        System.out.println("=======================\n");
    }

}
