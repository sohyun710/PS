import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        // 5의 배수들이 0을 만드는 주요 요인
        // 5, 10, 15, 20, 25, 30, ... 에서 5의 개수를 세어야 함
        // 25 = 5^2 이므로 5가 2개, 125 = 5^3 이므로 5가 3개 들어있음
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        
        System.out.println(count);
    }
}