import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    int start(int[][] box, int M, int N) {
        for(int i = 1; i < N-1; i++) {
            for(int j = 1; j < M-1; j++) {
                if(box[i-1][j] < 0 && box[i][j-1] < 0 && box[i+1][j] < 0 && box[i][j+1] < 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        M = M + 1;
        N = N + 1;

        int count = 0;
        int[][] box = new int[M][N];

        for(int i = 0; i <= M; i++) {
            for(int j = 0; j <= N; j++) {
                box[i][j] = -1;
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int state = start(box, M, N);

        while(state == 0) {
            for(int col = 1; col < N; col++) {
                for(int row = 1; row < M; row++) {
                    if(box[row][col] == 1) {
                        box[row-1][col] = 1;
                        box[row][col-1] = 1;
                        box[row+1][col] = 1;
                        box[row][col+1] = 1;
                    }
                }
            }
            count++;

            while(state != 1) {
                for (int col = 1; col < M; col++) {
                    for (int row = 1; row < N; row++) {
                        if (box[row][col] != 1) break;
                    }
                }
                state = 1;
            }
        }
        System.out.println(state);
        System.out.println(count);
    }
}