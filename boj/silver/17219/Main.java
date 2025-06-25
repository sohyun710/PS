import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        // 입력 99개 받을 때까지 반복
        while (scanner.hasNextInt() && numbers.size() < 100) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> sorted = new ArrayList<>(numbers);
        sorted.sort(Collections.reverseOrder());

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sorted.size(); i++) {
            int num = sorted.get(i);
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
            }
            rank++;
        }

        for (int num : numbers) {
            System.out.println(rankMap.get(num) + ": " + num);
        }

        scanner.close();
    }
}
