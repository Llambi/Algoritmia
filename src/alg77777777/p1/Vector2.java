package alg77777777.p1;

public class Vector2 {
	public static void main(String[] args) {
		int tam = Integer.valueOf(args[0]);
		int[] v = new int[tam];
		Vector1.rellena(v);
		long t0 = System.currentTimeMillis();
		Vector1.suma(v);
		long tf = System.currentTimeMillis();
		long tSuma = tf-t0;
        t0 = System.currentTimeMillis();
        Vector1.maximo(v, new int[2]);
        tf = System.currentTimeMillis();
        long tMaximo = tf-t0;
        System.out.println(tam + "\t" + tSuma + "\t" + tMaximo);
	}
}
