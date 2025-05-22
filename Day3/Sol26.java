import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sol26{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }
            lines.add(line);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > 0 && x <= lines.size() && y > 0 && y <= lines.get(x - 1).size()) {
                System.out.println(lines.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}