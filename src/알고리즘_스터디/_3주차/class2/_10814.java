package 알고리즘_스터디._3주차.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _10814 {
    static class Human implements Comparable<Human> {
        int age;
        String name;

        Human(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Human o) {

            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<Human> humanList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            humanList.add(new Human(age, name));
        }

        Collections.sort(humanList);

        for (Human human : humanList) {

            System.out.println(human.age + " " + human.name);
        }
    }
}