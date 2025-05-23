import java.io.*;
import java.util.*;
import java.util.regex.*;

class MyRegex {
    String pattern =
            "^(25[0-5]|2[0-4]\\d|1\\d{2}|0?\\d{1,2})\\." +
                    "(25[0-5]|2[0-4]\\d|1\\d{2}|0?\\d{1,2})\\." +
                    "(25[0-5]|2[0-4]\\d|1\\d{2}|0?\\d{1,2})\\." +
                    "(25[0-5]|2[0-4]\\d|1\\d{2}|0?\\d{1,2})$";
}

public class Sol48{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MyRegex myRegex = new MyRegex();
        Pattern pattern = Pattern.compile(myRegex.pattern);

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            Matcher matcher = pattern.matcher(line);
            System.out.println(matcher.matches());
        }
    }
}
