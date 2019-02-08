package alg77777777.p1;

public class Vector4 {
	public static void main(String[] args) {
		int nTimes = Integer.parseInt(args[0]);
		long tSuma = 0, tMaximo = 0L;
		for (int tam = 1; tam < 1000000000; tam *= 3) {
			int[] v = new int[tam];
			Vector1.rellena(v);
			for (int start = 0; start <= nTimes; start++) {
				long t0 = System.currentTimeMillis();
				Vector1.suma(v);
				long tf = System.currentTimeMillis();
				tSuma += tf - t0;
				t0 = System.currentTimeMillis();
				Vector1.maximo(v, new int[2]);
				tf = System.currentTimeMillis();
				tMaximo += tf - t0;
			}
			System.out.println(tam + "\t" + tSuma  + "\t" + tMaximo );
		}
		
	}
}
