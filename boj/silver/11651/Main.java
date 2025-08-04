import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, (e1, e2) -> {   // 람다식 - 두 배열을 비교하는 Comparator 함수
             if(e1[1] == e2[1]) {   // y값이 같으면
                return e1[0] - e2[0];   // x값 기준으로 오름차순 정렬 (음수면 e1을 앞으로)
            } else {
                return e1[1] - e2[1];   // y값 기준으로 오름차순 정렬
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }
        System.out.println(sb);
        
        br.close();
    }
}