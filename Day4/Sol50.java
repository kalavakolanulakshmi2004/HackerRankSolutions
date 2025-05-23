import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Sol50{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        String regex = "<([^<>]+)>([^<>]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Matcher matcher = pattern.matcher(line);

            boolean found = false;
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                found = true;
            }

            if (!found) {
                System.out.println("None");
            }
        }
    }
}
