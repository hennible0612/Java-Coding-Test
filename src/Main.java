import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.next());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(scanner.next())) {
                count++;
            }
        }

        System.out.println(count);
    }
}