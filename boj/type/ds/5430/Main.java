import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] elements = arr.substring(1, arr.length() - 1).split(",");
                for (String element : elements) {
                    deque.add(Integer.parseInt(element));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);
                if (command == 'R') {
                    reverse = !reverse;
                } 
                else {   // D
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        error = true;
                        break;
                    }
                    if (reverse) deque.removeLast(); 
                    else deque.removeFirst();
                }
            }

            if (!error) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    if (reverse) {
                        sb.append(deque.removeLast());
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}