import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (b.score != a.score) {
            return b.score - a.score; // Descending order by score
        } else {
            return a.name.compareTo(b.name); // Ascending order by name if scores are equal
        }
    }
}

public class Sol54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }
        scanner.close();
    }
}
