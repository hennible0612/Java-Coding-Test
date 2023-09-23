class MyMath2 {
    long a, b;

    // 인스턴스변수 a, b만을 이용해서 작업하므로 매개변수가 필요없다.
    long add() {
        return a + b;
    }  // a, b는 인스턴스변수

    long subtract() {
        return a - b;
    }

    long multiply() {
        return a * b;
    }

    double divide() {
        return a / b;
    }

    // 인스턴스변수와 관계없이 매개변수만으로 작업이 가능하다.
    static long add(long a, long b) {
        return a + b;
    } // a, b는 지역변수

    static long subtract(long a, long b) {
        return a - b;
    }

    static long multiply(long a, long b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }
}

class TestClass2 {
    void instanceMethod() {
    } // 인스턴스메서드

    static void staticMethod() {
    } //static 메서드

    void instanceMethod2() { // 인스턴스메서드
        instanceMethod(); // 다른 인스턴스메서드를 호출한다.
        staticMethod(); // static 메서드를 호출한다.
    }

    static void staticMethod2() { //static 메서드
//        instanceMethod(); //에러!!! 인스턴스메서드를 호출할수 없다.
        staticMethod(); // static 메서드는 호출 할 수 있다.
    }
}
