import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        // BuffeeceredReader로 한 줄 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 결과 계산해서 출력
        System.out.println(getZ(N, r, c));
    }

    // Z 모양 순서 계산
    public static int getZ(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        int area = half * half;

        if (r < half && c < half) {
            return getZ(n - 1, r, c);               // 1사분면
        } else if (r < half && c >= half) {
            return area + getZ(n - 1, r, c - half); // 2사분면
        } else if (r >= half && c < half) {
            return 2 * area + getZ(n - 1, r - half, c); // 3사분면
        } else {
            return 3 * area + getZ(n - 1, r - half, c - half); // 4사분면
        }
    }
}