import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Sol51 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // List to hold the input strings along with their BigDecimal value
        List<Pair> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            numbers.add(new Pair(s, new BigDecimal(s)));
        }

        // Sort descending by numeric value, stable sort to maintain original order if values equal
        numbers.sort((a, b) -> b.value.compareTo(a.value));

        // Print the original strings in sorted order
        for (Pair p : numbers) {
            System.out.println(p.original);
        }
    }

    // Helper class to hold original string and its BigDecimal value
    static class Pair {
        String original;
        BigDecimal value;

        Pair(String original, BigDecimal value) {
            this.original = original;
            this.value = value;
        }
    }
}
