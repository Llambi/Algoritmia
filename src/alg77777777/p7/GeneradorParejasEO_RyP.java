package alg77777777.p7;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GeneradorParejasEO_RyP {
    private int n;

    public GeneradorParejasEO_RyP(int n) {
        this.n = n;
    }

    public String run(String root) {
        ThreadLocalRandom randomNum = ThreadLocalRandom.current();
        List<String> lines = new LinkedList<>();
        lines.add(String.valueOf(n));
        for (int i = 0; i < (n * 2) + 1; i++) {
            String line = "";
            if (i != n) {
                for (int j = 0; j < n; j++) {
                    line += randomNum.nextInt(0, 11) + "\t";
                }
            }
            lines.add(line);
        }
        Path file = Paths.get(root);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
