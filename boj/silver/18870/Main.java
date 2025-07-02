import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] token = br.readLine().split(" ");
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token[i]);
        }

        Set<Integer> set = new HashSet<>();     // 중복제거
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> sorted = new ArrayList<>(set);    // 리스트로 변환하여 정렬
        Collections.sort(sorted);

        Map<Integer, Integer> compressed = new HashMap<>();
        int cnt = 0;
        for (int num : sorted) {
            compressed.put(num, cnt++);
        }

        StringBuilder sb = new StringBuilder();
        for (int num: arr) {
            sb.append(compressed.get(num)).append(" ");
        }
        System.out.println(sb.toString());
    
        br.close();
    }
} 