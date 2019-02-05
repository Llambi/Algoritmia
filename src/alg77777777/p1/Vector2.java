package alg77777777.p1;

public class Vector2 {
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        Vector1.main(args);
        long tf = System.currentTimeMillis();
        System.out.println(args[0] + "\t" + (tf - t0));
    }
}
