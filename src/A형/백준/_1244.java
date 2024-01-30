package A형.백준;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1244 {

    static int[] switchStatusArray;
    static int numberOfSwitches;
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numberOfSwitches = Integer.parseInt(bf.readLine());

        switchStatusArray = new int[numberOfSwitches + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= numberOfSwitches; i++) {
            switchStatusArray[i] = Integer.parseInt(st.nextToken());
        }

        int numberOfStudent = Integer.parseInt(bf.readLine());

        for(int i =0; i < numberOfStudent; i++) {
            st = new StringTokenizer(bf.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            if(gender == 1) {
                boySwitch(index);
            }else {
                girlSwitch(index);
            }
        }
        for (int i = 1; i <= numberOfSwitches; i++) {
            System.out.print(switchStatusArray[i] + " ");
            if (i % 20 == 0){
                System.out.println();
            }

        }
    }
    static void boySwitch(int index) {
        if(index == 0) {
            changeLight(index);
        }else {
            for(int i = index; i <= numberOfSwitches; i += index) {
                changeLight(i);
            }
        }

    }

    static void girlSwitch(int index) {
        int left = index - 1;
        int right = index + 1;

        changeLight(index);

        while(left > 0 && right <= numberOfSwitches && switchStatusArray[left] == switchStatusArray[right]) {
            changeLight(left);
            changeLight(right);

            left--;
            right++;
        }
    }

    static void changeLight(int index) {
        if(switchStatusArray[index] == 1) {
            switchStatusArray[index] = 0;
        }else {
            switchStatusArray[index] = 1;
        }
    }
}
