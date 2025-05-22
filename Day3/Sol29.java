import java.io.*;
import java.util.*;

public class Sol29 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Set<String> set = new HashSet<>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for(int i=0; i<n; i++){
            String in = input.nextLine();
            String[] parts = in.split(" ");
            String a = parts[0];
            String b = parts[1];
            String key = a.compareTo(b)<0 ? a+" "+b : b+" "+a;
            set.add(key);
            System.out.println(set.size());
        }
    }
}