package 해쉬._5K번째_큰수;

import com.sun.source.util.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bf.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        String[] array = bf.readLine().split(" ");
        int[] iarray = new int[array.length];
        for (int i = 0; i < iarray.length; i++) {
            iarray[i] = Integer.parseInt(array[i]);
        }

//        TreeSet<Integer> Tset = new TreeSet<>(); // 일반 정렬
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); // 일반 정렬

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int l=j+1; l<n; l++){
                    Tset.add(iarray[i]+iarray[j]+iarray[l]);
                }
            }
        }
        int cnt=0;


        for(int x : Tset){
            cnt++; // k 번째 값
            if (cnt == k) {
                System.out.println(x);

            }
        }


    }
}
