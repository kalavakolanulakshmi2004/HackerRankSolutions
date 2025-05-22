import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sol21 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        bufferedReader.close();
        BigInteger bigInt = new BigInteger(n);
        if (bigInt.isProbablePrime(10)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
