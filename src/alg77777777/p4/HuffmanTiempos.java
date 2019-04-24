package alg77777777.p4;

public class HuffmanTiempos {

    public static void main(String[] args) {
        Generator generator = new Generator();
        String fileName = "resources/caseTime.txt";
        int nTimes = 100;
        int start = 1000;

        for (int i = start; i < Integer.MAX_VALUE; i*=2) {

            generator.run(fileName, i, 10, 1, 1000, 1);

            long init = System.currentTimeMillis();
            Huffman huffman = new Huffman(fileName);

            for (int j = 0; j < nTimes; j++) {
                huffman.run();
            }

            long end = System.currentTimeMillis();

            System.out.println(i + "\t" + (end - init));

        }


    }
}
