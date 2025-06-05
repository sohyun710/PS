import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] elements = array.substring(1, array.length() - 1).split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean reverse = false;
            boolean error = false;

            // 함수열 처리
            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    reverse = !reverse;
                } 
                else { // 'D'
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    if (reverse) deque.removeLast();   // reverse면 뒤에서 제거
                    else deque.removeFirst();
                }
            }

            if (!error) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.removeLast() : deque.removeFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
