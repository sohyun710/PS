import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);  
        int M = Integer.parseInt(firstLine[1]);

        Map<String, String> map = new HashMap<>(N); 

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            map.put(line[0], line[1]);
        }

        for (int i = 0; i < M; i++) {
            String password = br.readLine();
            System.out.println(map.get(password)); 
        }
        
        br.close();
    }
}