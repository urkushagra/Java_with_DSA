class MathUtils {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MathUtils m = new MathUtils();
        System.out.println(m.add(5, 10));
        System.out.println(m.add(5.5, 10.5));
        System.out.println(m.add(5, 10, 15));
    }
}
