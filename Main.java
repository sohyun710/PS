import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        
        for (int i = 0; i < N; i++) {
            arr[i+1] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(arr);
        
        int rid = Math.round(N * 0.15f);
        int sum = 0;

        for (int i = rid+1; i < N-rid+1; i++) {
            sum += arr[i];
        }
        
        System.out.println(Math.round((float)sum/(N-rid*2)));
        br.close();
    }
}