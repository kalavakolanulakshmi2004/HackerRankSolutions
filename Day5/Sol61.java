import java.util.*;
import java.util.function.*;

interface PerformOperation {
    boolean check(int a);
}

public class Sol61{

    public static PerformOperation isOdd() {
        return (int a) -> (a % 2 != 0);
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String s = String.valueOf(a);
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }
            return true;
        };
    }

    public static String checker(PerformOperation p, int num) {
        return p.check(num) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int op = sc.nextInt();
            int num = sc.nextInt();
            PerformOperation p;
            boolean result = false;
            switch (op) {
                case 1:
                    p = isOdd();
                    result = p.check(num);
                    System.out.println(result ? "ODD" : "EVEN");
                    break;
                case 2:
                    p = isPrime();
                    result = p.check(num);
                    System.out.println(result ? "PRIME" : "COMPOSITE");
                    break;
                case 3:
                    p = isPalindrome();
                    result = p.check(num);
                    System.out.println(result ? "PALINDROME" : "NOT PALINDROME");
                    break;
            }
        }
        sc.close();
    }
}
