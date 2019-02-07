package alg77777777.p1;

public class MatrizOperacionesTiempos {
	public static void main(String[] args) {
		int nTimes = Integer.parseInt(args[0]);
		long tD1 = 0, tD2 = 0L;
		for (int tam = 1; tam < 1000000000; tam *= 2) {
			MatrizOperaciones m = new MatrizOperaciones(tam);
			for (int start = 0; start <= nTimes; start++) {
				long t0 = System.currentTimeMillis();
				m.sumarDiagonal1();
				long tf = System.currentTimeMillis();
				tD1 += tf - t0;
				t0 = System.currentTimeMillis();
				m.sumarDiagonal2();
				tf = System.currentTimeMillis();
				tD2 += tf - t0;
			}
			System.out.println(tam + "\t" + tD1 + "\t" + tD2);
		}

	}
}
