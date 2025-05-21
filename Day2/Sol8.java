import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sol8 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List<String> a = new ArrayList<>();
        int cnt = 1;
        while(sc.hasNext()){
            a.add(cnt++ + " " + sc.nextLine());
        }
        for(String s: a){
            System.out.println(s);
        }
    }
}