import java.math.BigDecimal;
import java.util.Arrays;

public class hi {
    public static void main(String[] args) {
//        double d1 = 2.0;
//        double d2 = 1.1;
//        System.out.println(d1 - d2); // 0.89999999
//        System.out.println(((int) (d1 * 100) - (int) (d2 * 100)) / 100.0); // 0.9
//
//        BigDecimal b1 = new BigDecimal("2.0");
//        BigDecimal b2 = new BigDecimal("1.1");
//        System.out.println("BigDecimal을 이용한 빼기 : " + b1.subtract(b2)); // 0.9
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9}; //길이 9
        int index = Arrays.binarySearch(array, 56);
        int index1 = Arrays.binarySearch(array, 4);
        int index2 = Arrays.binarySearch(array, -3);

        System.out.println(index);// -10 (10의 위치에 들어갈수 있음)
        System.out.println(index1);// 3
        System.out.println(index2);// 실제 위치 반환 1

        int index4 = Arrays.binarySearch(array, 0, 4, 2);
        System.out.println(index4);// 범위를 지정했음


    }
}
