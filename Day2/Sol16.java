import java.io.*;
import java.util.*;

public class Sol16 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        int j=A.length()-1;
        boolean flag=true;
        for(int i=0;i<A.length()/2;i++){
            if(A.charAt(i)!=A.charAt(j)){
                flag=false;
                break;
            }
            j--;
        }
        if(flag){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}




