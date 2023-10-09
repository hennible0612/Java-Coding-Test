package 삼성SW_EXPERT_ACADEMY.D2.조교의성적매기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine().trim());
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()) - 1;

            ArrayList<Double> scoreList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                double midterm = Double.parseDouble(st.nextToken());
                double finalExam = Double.parseDouble(st.nextToken());
                double assignment = Double.parseDouble(st.nextToken());

                double total = midterm * 0.35 + finalExam * 0.45 + assignment * 0.2;
                scoreList.add(total);
            }

            double kthScore = scoreList.get(K);

            Collections.sort(scoreList, Collections.reverseOrder());

            int rank = scoreList.indexOf(kthScore);

            String grade = grades[(rank * 10) / N];

            System.out.println("#" + test_case + " " + grade);
        }
    }
}


