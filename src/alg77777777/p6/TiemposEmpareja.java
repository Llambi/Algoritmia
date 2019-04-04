package alg77777777.p6;

public class TiemposEmpareja {
    public static void main(String[] args) {
        int nTimes = 10;
        int start = 11;

        for (int i = start; i < Integer.MAX_VALUE; i++) {
            long totalTime = 0L;
            for (int j = 0; j < nTimes; j++) {
                GeneradorParejas gp = new GeneradorParejas(i);
                Empareja e = new Empareja(gp.run("resources/rechazoGenerado.txt"), Integer.parseInt(args[0]));
                long init = System.currentTimeMillis();
                e.run();
                long end = System.currentTimeMillis();
                totalTime += (end-init);
            }

            System.out.println(i + "\t" + (totalTime/nTimes));

        }
    }
}
