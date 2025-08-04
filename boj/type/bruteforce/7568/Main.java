import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        for (int i=0; i<N; i++) {
            int rank = 1;
            for (int j=0; j<N; j++){
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) rank++;
            }
            arr[i][2] = rank;
        }

        for (int i=0; i<N; i++) {
            System.out.print(arr[i][2]);
            if (i != arr.length - 1) System.out.print(" ");
        }

        br.close();
    }
}