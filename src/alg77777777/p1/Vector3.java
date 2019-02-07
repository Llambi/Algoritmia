package alg77777777.p1;

public class Vector3 {
    public static void main(String[] args) {
        for (int start = 107495424; start <= Integer.parseInt(args[0]); start*=1.1) {
        	int[] v = new int[start];
    		Vector1.rellena(v);
            long t0 = System.currentTimeMillis();
            Vector1.suma(v);
            long tf = System.currentTimeMillis();
            long tSuma = tf-t0;
            t0 = System.currentTimeMillis();
            Vector1.maximo(v, new int[2]);
            tf = System.currentTimeMillis();
            long tMaximo = tf-t0;
            System.out.println(start + "\t" + tSuma + "\t" + tMaximo);
        }
    }
}
