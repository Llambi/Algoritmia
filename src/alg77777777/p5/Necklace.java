package alg77777777.p5;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Necklace {
    private String necklace;
    private Map<String, Integer> diccionario;
    private int[][] cache;
    private int necklaceSize;
    private int charmsSize;
    private List<String> charmSolution = new LinkedList<>();
    private List<String> charms;

    public Necklace(String necklace) {

        setNecklace(necklace);
        this.diccionario = null;
    }

    public Necklace(String necklace, Map<String, Integer> diccionario) {
        this(necklace);
        setDiccionario(diccionario);
        initCache();
    }

    public void setNecklace(String necklace) {
        this.necklace = necklace;
        this.necklaceSize = this.necklace.length();
    }

    public void setDiccionario(Map<String, Integer> diccionario) {
        this.diccionario = diccionario;
        this.charmsSize = this.diccionario.size();
        this.charms = new LinkedList<>(this.diccionario.keySet());
    }

    private void initCache() {
        this.cache = new int[this.charmsSize][this.necklaceSize + 1];
        for (int i = 0; i < this.charmsSize; i++) {
            this.cache[i][0] = 0;
        }
    }

    private void run() {
        if (this.cache == null) initCache();

        for (int row = 0; row < this.charmsSize; row++) {
            for (int col = 1; col < this.necklaceSize; col++) {
                String thisCharm = this.charms.get(row);
                String previousCharm =

                int previousValue = charmPos >= 0 ? this.cache[this.charmsSize][charmPos] : Integer.MIN_VALUE;
                int upValue = row > 0 ? this.cache[row - 1][col] : this.cache[this.charmsSize][col - 1];

                if ()

            }
        }
    }


    // Si j=0 -> 0
    // si J!=0 -> la de arriba mas esta si procede

}
