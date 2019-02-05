package alg77777777.p1;

public class MatrizOperacionesTiempos {
    public static void main(String[] args) {
        for (int start = 0; start <= Integer.parseInt(args[0]); start++) {
            long t0 = System.currentTimeMillis();
            new MatrizOperaciones(start).sumarDiagonal1();
            long tf = System.currentTimeMillis();
            long time1 = tf - t0;
            t0 = System.currentTimeMillis();
            new MatrizOperaciones(start).sumarDiagonal2();
            tf = System.currentTimeMillis();
            long time2 = tf - t0;
            System.out.println(start + "\t" + time1 + "\t" + time2);
        }
    }
}
