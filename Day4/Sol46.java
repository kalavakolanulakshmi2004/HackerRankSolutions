import java.io.*;
import java.util.*;

class Singleton {
    public String str;

    private static Singleton single_instance = null;

    private Singleton() {}

    public static Singleton getSingleInstance() {
        if (single_instance == null) {
            single_instance = new Singleton();
        }
        return single_instance;
    }
}

public class Sol46 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();

        Singleton singleton = Singleton.getSingleInstance();
        singleton.str = inputLine;

        System.out.println("Hello I am a singleton! Let me say " + singleton.str + " to you");
    }
}
