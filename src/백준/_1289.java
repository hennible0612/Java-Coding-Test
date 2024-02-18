package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1289 {
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            char[] memory = bf.readLine().trim().toCharArray();
            char current = '0';
            int changes = 0;

            for (char bit : memory) {
                if (bit != current) {
                    changes++;
                    current = bit;
                }
            }
            sb.append("#").append(tc).append(" ").append(changes).append("\n");
        }
        System.out.println(sb);
    }
}


//static int T, count;
//static char[] input, memory;
//
//public static void main(String[] args) throws Exception {
//	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//	T = Integer.parseInt(bf.readLine());
//
//	for (int t = 1; t <= T; t++) {
//		// 테케별 풀이
//		input = bf.readLine().toCharArray();
//		int cnt = input.length;
//
//		// 메몰; '0' 초기화
//		memory = new char[cnt];
//		for(int i = 0; i < cnt; i++) {
//			memory[i] = '0';
//		}
//
//		// 풀이
//		count = 0;
//		for(int i = 0; i< cnt; i++) {
//			if(memory[i] != input[i]) {
//				for(int j = i; j < cnt; j++) {
//					memory[j] = input[i];
//				}
//				count++;
//			}
//		}
//		System.out.println("#" + t + " " + count);
//	}
//}