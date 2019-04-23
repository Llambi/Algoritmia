package alg77777777.p7;


public class TiemposEmparejamientoEO_RyP {
    public static void main(String[] args) {
        int nTimes = 10;
        int start = 20;
        int umbral = Integer.parseInt(args[0]);
        String root = "resources/rechazoGenerado.txt";

        for (int i = start; i < Integer.MAX_VALUE; i ++) {
            long totalTime = 0L;
            GeneradorParejasEO_RyP gp = new GeneradorParejasEO_RyP(i);
            for (int j = 0; j < nTimes; j++) {
                EmparejamientoEO_RyP e = new EmparejamientoEO_RyP(gp.run(root), umbral, false);
                long init = System.currentTimeMillis();
                e.ramificaYPoda(e.getNodoRaiz());
                long end = System.currentTimeMillis();
                totalTime += (end - init);
            }

            System.out.println(i + "\t" + (totalTime / nTimes));

        }
    }
}
