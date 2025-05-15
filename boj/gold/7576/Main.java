/* nextbox[]를 선언하지 않고 큐와 BFS 사용
directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}} 배열로 방향 설정
상하좌우 -1 검사 실시하지 않음 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        boolean hasUnripe = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
                if (box[i][j] == 0) hasUnripe = true;   // 하나라도 안 익어 있으면
            }
        }

        if (!hasUnripe) {
            System.out.println(0);
            return;
        }

        int days = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};   // 상, 하, 좌, 우

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});   // 새롭게 익은 토마토 위치를 enqueue
                    }
                }
            }
            days++;
        }

        if (hasUnripeTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(days - 1);
        }
    }

    static boolean hasUnripeTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return true;
            }
        }
        return false;
    }
}