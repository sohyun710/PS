/* nextbox[]를 선언하지 않고 큐와 BFS 사용
box[i-1][j], box[i][j-1], box[i+1][j], box[i][j+1]로 방향 설정
상하좌우 -1 검사 실시하지 않음 */
/* 시간초과 발생 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int M, N;
    static int[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N + 2][M + 2]; // 패딩을 포함한 배열

        // 외곽을 -1로 초기화
        for (int i = 0; i < N + 2; i++) {
            Arrays.fill(box[i], -1);
        }

        // 입력받기
        boolean hasUnripe = false;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) hasUnripe = true; // 익지 않은 토마토가 있는지 확인
            }
        }

        if (!hasUnripe) { // 모든 토마토가 이미 익어 있으면
            System.out.println(0);
            return;
        }

        int days = 0;

        // 반복하면서 모든 익은 토마토를 확장
        while (true) {
            boolean changed = false;
            int[][] newBox = new int[N + 2][M + 2]; // 새로운 박스 배열을 만들어서 반영

            // 기존 상태를 newBox에 복사
            for (int i = 0; i < N + 2; i++) {
                System.arraycopy(box[i], 0, newBox[i], 0, M + 2);
            }

            // 배열을 돌며 익은 토마토(1)가 있으면 퍼뜨리기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (box[i][j] == 1) {
                        // 상하좌우 방향으로 확인하고 익히기
                        if (box[i - 1][j] == 0) { // 위
                            newBox[i - 1][j] = 1; // 익게 함
                            changed = true;
                        }
                        if (box[i + 1][j] == 0) { // 아래
                            newBox[i + 1][j] = 1; // 익게 함
                            changed = true;
                        }
                        if (box[i][j - 1] == 0) { // 왼쪽
                            newBox[i][j - 1] = 1; // 익게 함
                            changed = true;
                        }
                        if (box[i][j + 1] == 0) { // 오른쪽
                            newBox[i][j + 1] = 1; // 익게 함
                            changed = true;
                        }
                    }
                }
            }

            // 새로운 박스로 갱신
            box = newBox;

            // 변화가 없으면 종료
            if (!changed) break;

            days++; // 상태가 변했을 때만 날짜를 증가
        }

        // 익지 않은 토마토가 남아 있는지 확인
        if (hasUnripeTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }

    static boolean hasUnripeTomato() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (box[i][j] == 0) return true;
            }
        }
        return false;
    }
}
