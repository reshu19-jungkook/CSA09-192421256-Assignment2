
import java.util.*;

class Player {
    String name;
    int score;
    int age;

    Player(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String toString() {
        return name + " - Score: " + score + ", Age: " + age;
    }
}

public class Leaderboard {

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();

        players.add(new Player("Arun", 90, 20));
        players.add(new Player("Bala", 85, 21));
        players.add(new Player("Charan", 90, 19));
        players.add(new Player("Divya", 75, 20));
        players.add(new Player("Esha", 85, 18));

        // Sort by score (highest first)
        players.sort(
            Comparator.comparingInt((Player p) -> p.score)
                      .reversed()
                      .thenComparing(p -> p.name)
        );

        System.out.println("PLAYER LEADERBOARD");
        for (Player p : players) {
            System.out.println(p);
        }

        // Sort by age (youngest first)
        players.sort(Comparator.comparingInt(p -> p.age));

        System.out.println("\nSORTED BY AGE");
        for (Player p : players) {
            System.out.println(p);
        }
    }
}
