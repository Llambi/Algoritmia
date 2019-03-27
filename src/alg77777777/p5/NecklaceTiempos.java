package alg77777777.p5;

import java.util.Map;

public class NecklaceTiempos {

    public static void main(String[] args) {

        int nTimes = 100;
        int start = 1000;
        Map<String, Integer> dicc = NecklaceFactory.getSimpleValuesTable();

        for (int i = start; i < Integer.MAX_VALUE; i *= 2) {
            int sol = -1;
            Necklace n = NecklaceFactory.createTwoPiecesNecklace(i);
            n.setDiccionario(dicc);

            long init = System.currentTimeMillis();

            for (int j = 0; j < nTimes; j++) {
                sol = n.run();
            }

            long end = System.currentTimeMillis();

            System.out.println(i + "\t" + (end - init));

        }


    }
}
