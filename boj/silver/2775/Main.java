import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // DP 배열 초기화 - dp[층][호수] = 거주민 수
        // 최대 14층, 14호까지 가능하므로 15x15 배열 생성
        int[][] dp = new int[15][15];
        
        // 0층 초기화: 0층의 i호에는 i명이 산다
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }
        
        // 1층부터 14층까지 각 호수의 거주민 수 계산
        for (int floor = 1; floor <= 14; floor++) {
            for (int room = 1; room <= 14; room++) {
                // 현재 층의 현재 호수 = 아래층 1호부터 현재 호수까지의 합
                dp[floor][room] = 0;
                for (int j = 1; j <= room; j++) {
                    dp[floor][room] += dp[floor - 1][j];
                }
            }
        }
        
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호수
            
            // 결과 출력
            System.out.println(dp[k][n]);
        }
        
        br.close();
    }
}