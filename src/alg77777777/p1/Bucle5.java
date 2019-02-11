package alg77777777.p1;

public class Bucle5 {

    public static long bucle5(int n) {
        long cont = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                for (int k = 1; k <= n; k++)
                    for (int l = 1; l <= n; l *= 2)
                        cont++;
        return cont;

    }

    public static void main(String arg[]) {
        long c = 0;
        long t1, t2;
        int nVeces = Integer.parseInt(arg[0]);
        System.out.println("n\ttiempo\tcontador");
        for (int n = 8; n <= 100000; n *= 2) {
            t1 = System.currentTimeMillis();

            for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
                c += bucle5(n);
            }

            t2 = System.currentTimeMillis();

            System.out.println(n + "\t" + (t2 - t1));

        } // for

    } // main
}
