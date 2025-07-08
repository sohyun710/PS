import java.io.*;
import java.util.*;

public class Bet {
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] origin = new int[N];   // 원본 배열
		int[] sorted = new int[N];   // 정렬 할 배열
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();   // rank를 매길 HashMap
 
        String[] token = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			sorted[i] = origin[i] = Integer.parseInt(token[i]);
		}
		
		Arrays.sort(sorted);
		
		// 정렬 된 배열을 순회하면서 map에 넣어준다.
		// 원소가 중복되지 않을 때만 map에 원소와 그에 대응되는 순위를 넣어준다.
		int rank = 0;
		for(int v : sorted) {			 
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;		// 다음 순위를 가리킬 수 있도록 1을 더해준다.
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			int ranking = rankingMap.get(key);   // 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	}
}