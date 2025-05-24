import java.io.*;
import java.util.*;

public class Sol53 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        while(sn.hasNextLine()){
            String str = sn.nextLine();
            boolean isBalanced = isBalanced(str);
            System.out.println(isBalanced);
        }

    }

    public static boolean isBalanced(String s){
        Stack<Character> stack  = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else if(ch==')' || ch=='}' || ch==']'){
                if(stack.isEmpty()) return false;
                char top = stack.pop();

                if( ( ch==')' && top != '(' ) || ( ch=='}' && top != '{' ) || ( ch==']' && top != '[' ) ){
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}