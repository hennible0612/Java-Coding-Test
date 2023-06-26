package Class1;

import java.io.IOException;
import java.util.Scanner;



public class _2920 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        for(int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        String result = "";
        for(int i = 0; i < 7; i++) {
            if(arr[i] == arr[i+1]-1) {
                result = "ascending";
            }
            else if(arr[i] == arr[i+1]+1) {
                result = "descending";
            }
            else {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    }
}
