import java.io.*;
import java.util.*;

public class Timeout {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        for (int i = 0; i< N; i++) {
            int cnt = 0;
            for (int num : sorted) {
                if (arr[i] > num) cnt++;
                else break;
            }
            System.out.print(cnt + " ");
        }
    
        br.close();
    }
}