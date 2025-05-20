import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++) {
            Map<String, Integer> map = new HashMap<>();
            
            int res = 1;
            int n = Integer.parseInt(br.readLine());

            for (int j=0; j<n; j++) {
                String[] input = br.readLine().split(" ");
                String clothType = input[1];
                map.put(clothType, map.getOrDefault(clothType, 0) + 1);
            }

            for (int cnt : map.values()) {
                res *= (cnt + 1);
            }

            System.out.println(res - 1);
        }
    }
}
