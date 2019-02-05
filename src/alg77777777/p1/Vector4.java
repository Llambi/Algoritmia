package alg77777777.p1;

public class Vector4 {
    public static void main(String[] args) {
        int nTimes = Integer.parseInt(args[0]);
        long time = 0L;
        for (int start = 0; start <= nTimes; start++) {
            long t0 = System.currentTimeMillis();
            Vector1.main(new String[]{String.valueOf(100)});
            long tf = System.currentTimeMillis();
            time += tf - t0;
        }
        System.out.println(nTimes + "\t" + time / nTimes);
    }
}
