import java.io.*;
import java.util.*;

public class Sol32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);

        Map<Integer, BitSet> map = new HashMap<>();
        map.put(1, b1);
        map.put(2, b2);

        for (int i = 0; i < m; i++) {
            String op = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            switch (op) {
                case "AND":
                    map.get(x).and(map.get(y));
                    break;
                case "OR":
                    map.get(x).or(map.get(y));
                    break;
                case "XOR":
                    map.get(x).xor(map.get(y));
                    break;
                case "FLIP":
                    map.get(x).flip(y);
                    break;
                case "SET":
                    map.get(x).set(y);
                    break;
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}
