import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int cnt = 0;

        for (int i = 5; n / i > 0; i *= 5) {
            cnt += n / i;
        }
        
        System.out.println(cnt);
    }
}