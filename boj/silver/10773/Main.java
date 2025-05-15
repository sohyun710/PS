import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int sum=0;

        for(int i= 0; i<K; i++) {
            int M = Integer.parseInt(br.readLine());
            if (M == 0) sum-= stack.pop();
            else { 
                stack.push(M);
                sum+= M;}
        }
        System.out.println(sum);
    }
}