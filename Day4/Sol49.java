import java.io.*;
import java.util.*;

public class Sol49 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());

        while (t-- > 0) {
            String input = br.readLine();
            if (input == null) break;
            StringBuilder output = new StringBuilder();
            Set<String> seen = new HashSet<>();

            String[] words = input.trim().split("\\s+");
            for (String word : words) {
                String lower = word.toLowerCase();
                if (!seen.contains(lower)) {
                    seen.add(lower);
                    if (output.length() > 0) output.append(" ");
                    output.append(word);
                }
            }
            System.out.println(output);
        }
    }
}
