import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;  // 찾은 종말의 수의 개수
        int num = 666;  // 666부터 시작
        
        while (true) {
            // 종말의 수인지 확인
            String str = String.valueOf(num);
            boolean isApocalypse = false;
            
            // 연속된 6이 3개 이상 있는지 확인
            for (int i = 0; i <= str.length() - 3; i++) {
                if (str.charAt(i) == '6' && str.charAt(i + 1) == '6' && str.charAt(i + 2) == '6') {
                    isApocalypse = true;
                    break;
                }
            }
            
            if (isApocalypse) {
                count++;
                if (count == n) {
                    System.out.println(num);
                    break;
                }
            }
            num++;
        }
    }
}