import java.io.*;
import java.util.*;

public class AdjMatrix {

    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int N = Integer.parseInt(st.nextToken());   // 노드
        int V = Integer.parseInt(st.nextToken());   // 간선

        map = new int[N+1][N+1];    // 인접행렬
        visited = new boolean[N+1];

        for(int i=0; i<V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }
        
        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            int K = queue.poll();
            for(int i=1; i<map.length; i++) {
                if (map[K][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}