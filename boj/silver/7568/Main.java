import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int height = Integer.parseInt(input[1]);
            arr[i][0] = weight;
            arr[i][1] = height;
        }

        for (int i=0; i<N; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            int num = 1;
            for (int j=0; j<N; j++){
                if (a < arr[j][0] && b < arr[j][1]) num++;
            }
            arr[i][2] = num;
        }

        for (int i=0; i<N; i++) {
            System.out.print(arr[i][2]);
            if (i != arr.length - 1) System.out.print(" ");
        }

        br.close();
    }
}