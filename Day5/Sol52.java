import java.io.*;
import java.util.*;

public class Sol52 {

    static boolean canWin(int leap, int[] game) {
        return canWinFrom(0, leap, game, new boolean[game.length]);
    }

    static boolean canWinFrom(int i, int leap, int[] game, boolean[] visited) {
        if (i < 0 || game[i] == 1 || visited[i]) return false;
        if (i >= game.length - 1 || i + leap >= game.length) return true;

        visited[i] = true;

        if (canWinFrom(i + 1, leap, game, visited)) return true;
        if (canWinFrom(i + leap, leap, game, visited)) return true;
        if (canWinFrom(i - 1, leap, game, visited)) return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q-- > 0) {
            int n = scanner.nextInt();
            int leap = scanner.nextInt();
            int[] game = new int[n];

            for (int i = 0; i < n; i++) {
                game[i] = scanner.nextInt();
            }

            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }

        scanner.close();
    }
}
