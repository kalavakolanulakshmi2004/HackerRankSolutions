import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sol27{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int q = sc.nextInt();
        sc.nextLine(); // consume newline
        for (int i = 0; i < q; i++) {
            String query = sc.nextLine();
            if (query.equals("Insert")) {
                String[] params = sc.nextLine().split(" ");
                int x = Integer.parseInt(params[0]);
                int y = Integer.parseInt(params[1]);
                list.add(x, y);
            } else if (query.equals("Delete")) {
                int x = Integer.parseInt(sc.nextLine());
                list.remove(x);
            }
        }
        sc.close();
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}