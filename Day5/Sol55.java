import java.io.*;
import java.util.*;

public class Sol55{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int maxUnique = 0;
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (i >= k) {
                int leftElem = arr[i - k];
                freq.put(leftElem, freq.get(leftElem) - 1);
                if (freq.get(leftElem) == 0) freq.remove(leftElem);
            }
            if (i >= k - 1) maxUnique = Math.max(maxUnique, freq.size());
        }
        System.out.println(maxUnique);
        sc.close();
    }
}
