import java.math.BigDecimal;

public class hi {
    public static void main(String[] args) {
        double d1 = 2.0;
        double d2 = 1.1;
        System.out.println(d1 - d2); // 0.89999999
        System.out.println(((int) (d1 * 100) - (int) (d2 * 100)) / 100.0); // 0.9

        BigDecimal b1 = new BigDecimal("2.0");
        BigDecimal b2 = new BigDecimal("1.1");
        System.out.println("BigDecimal을 이용한 빼기 : " + b1.subtract(b2)); // 0.9


    }
}
