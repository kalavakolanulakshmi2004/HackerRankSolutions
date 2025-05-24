import java.util.*;
public class Sol57{

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Inner i = new Inner();
        Inner.Private ip = i.new Private();
        String assume = ip.powerof2(num) ? "is" : "is not a";

        System.out.printf("%d %s power of 2\n", num, assume);
        System.out.println("An instance of class: Solution.Inner.Private has been created");
    }
}

class Inner{
    class Private{
        boolean powerof2(int num){

            while(num > 1){
                if(num % 2 != 0) return false; //n = 2k+1
                num /= 2;
            }
            return true;
        }
    }
}