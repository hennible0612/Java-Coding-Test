package 알고리즘_스터디._11주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _16061 {

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Employee> employees = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(bf.readLine());
            employees.offer(new Employee(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        int counter = 0;

        while (!employees.isEmpty() && counter < k ) {
            if (sum > d) {
                break;
            }
            Employee employee = employees.poll();
            sum += employee.salary;
            counter++;
            sb.append(employee.name).append(", YOU ARE FIRED!").append("\n");

        }

        if (sum >= d) {
            System.out.println(counter);
            System.out.println(sb);
        } else {
            System.out.println("impossible");
        }

    }

    static class Employee implements Comparable<Employee> {
        String name;
        int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee obj) {
            return obj.salary - this.salary;
        }
    }
}
