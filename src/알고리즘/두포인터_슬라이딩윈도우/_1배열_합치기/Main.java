package 알고리즘.두포인터_슬라이딩윈도우._1배열_합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n_counter = 0;
        int m_counter = 0;


        for (int i = 0; i < n+m; i++) {
            if( n_counter < a.length && a[n_counter] <= b[m_counter]) {
                answer.add(a[n_counter]);
                n_counter++;
            } else if(m_counter < b.length){
                answer.add(b[m_counter]);
                m_counter++;
            }
        }


        for (int x : answer) {
            System.out.println(x);

        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] n_array = new int[n];
        String[] temp_array = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            n_array[i] = Integer.parseInt(temp_array[i]);
        }

        int m = Integer.parseInt(bf.readLine());
        int[] m_array = new int[m];
        String[] temp_array2 = bf.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            m_array[i] = Integer.parseInt(temp_array2[i]);
        }

        solution(n, m, n_array, m_array);
    }

}
