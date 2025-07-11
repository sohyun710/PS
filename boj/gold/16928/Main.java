import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> teleport = new HashMap<>();
    static boolean[] visited = new boolean[101];
    

    public static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        
        int[] startState = {start, 0};   // {현재위치, 이동횟수}
        queue.offer(startState);
        
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int moves = current[1];
            
            if (pos == end) {   // 종료조건
                return moves;
            }
            
            for (int dice = 1; dice <= 6; dice++) {
                int nextPos = pos + dice;
                
                if (nextPos > 100) continue;
                
                if (teleport.containsKey(nextPos)) {   // 사다리
                    nextPos = teleport.get(nextPos);
                }
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    int[] nextState = {nextPos, moves + 1};
                    queue.offer(nextState);
                }
            }
        }
        return -1;   // 컴파일에러 방지 - 문제는 성공하는 입력만 제시
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        
        int N = Integer.parseInt(token[0]); 
        int M = Integer.parseInt(token[1]); 
        
        for (int i = 0; i < N; i++) {
            token = br.readLine().split(" ");
            int from = Integer.parseInt(token[0]);
            int to = Integer.parseInt(token[1]);
            teleport.put(from, to);
        }
        
        for (int i = 0; i < M; i++) {
            token = br.readLine().split(" ");
            int from = Integer.parseInt(token[0]);
            int to = Integer.parseInt(token[1]);
            teleport.put(from, to);
        }
        
        int min = bfs(1, 100);
        System.out.println(min);
        
        br.close();
    }
}