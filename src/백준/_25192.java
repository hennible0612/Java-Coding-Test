package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String command = bf.readLine();

            if (command.equals("ENTER")) {
                answer += hashSet.size();
                hashSet.clear();
            } else {
                hashSet.add(command);
            }
        }
        answer += hashSet.size();
        System.out.println(answer);
    }
}