package alg77777777.p1;

public class Vector3 {
    public static void main(String[] args) {
        for (int start = 0; start <= Integer.parseInt(args[0]); start++) {
            long t0 = System.currentTimeMillis();
            Vector1.main(new String[]{String.valueOf(start)});
            long tf = System.currentTimeMillis();
            System.out.println(start + "\t" + (tf - t0));
        }
    }
}
