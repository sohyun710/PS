// 2805

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1]; // 1-based index
        st = new StringTokenizer(br.readLine());

        int min = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) min = arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int sum = 0;
        while (true) {
            for (int i = 1; i <= N; i++) {
                if (arr[i] > min) {
                    sum += arr[i] - min;
                }
            }

            if (sum != 0) {
                if (sum <= M) break;
                sum = 0;
                min ++; 
            } else {
                min = 0;
            }
        }
        
        if (sum == M) System.out.print(min);
        else if (sum != M) System.out.print(min-1);
    }
}