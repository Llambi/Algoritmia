package alg77777777.p5;

import java.util.Comparator;
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

    public List<String> getCharms() {
        return charms;
    }

    public String getNecklace() {
        return necklace;
    }

    public void setNecklace(String necklace) {
        this.necklace = necklace;
        this.necklaceSize = this.necklace.length();
    }

    public List<String> getCharmSolution() {
        return charmSolution;
    }

    public void setDiccionario(Map<String, Integer> diccionario) {
        this.diccionario = diccionario;
        this.charmsSize = this.diccionario.size()-1;
        this.charms = new LinkedList<>(this.diccionario.keySet());
        this.charms.sort(Comparator.comparingInt(String::length));
    }

    private void initCache() {
        this.cache = new int[this.charmsSize+1][this.necklaceSize+1];
        for (int i = 0; i < this.charmsSize; i++) {
            this.cache[i][0] = 0;
        }
    }

    public int run() {
        if (this.cache == null) initCache();

        for (int col = 1; col <= this.necklaceSize; col++) {
            String solCharm = null;
            for (int row = 0; row <= this.charmsSize; row++) {
                String evaluateCharm = this.necklace.substring(col - 1, col);
                String rowCharm = this.charms.get(row);

                int upValue = row > 0 ? this.cache[row - 1][col] : this.cache[this.charmsSize][col - 1];

                int perviousRowCharmPos = col - rowCharm.length();
                int previousValue = perviousRowCharmPos >= 0 ? this.cache[this.charmsSize][perviousRowCharmPos] : Integer.MIN_VALUE;

                int thisValue = perviousRowCharmPos >= 0 ?
                        this.necklace.substring(perviousRowCharmPos , col).equals(rowCharm) ?
                            this.diccionario.get(rowCharm) :
                            Integer.MIN_VALUE :
                        Integer.MIN_VALUE;

                if (upValue == Math.max(upValue, thisValue + previousValue)) {
                    this.cache[row][col] = upValue;
                } else {
                    this.cache[row][col] = thisValue + previousValue;
                    solCharm = rowCharm;
                }
            }
            if (solCharm != null)
                if(!this.charmSolution.isEmpty() && solCharm.contains(this.charmSolution.get(this.charmSolution.size()-1))) {
                    this.charmSolution.remove(this.charmSolution.size()-1);
                }
                this.charmSolution.add(solCharm);
        }
        return this.cache[this.charmsSize][this.necklaceSize];
    }
}
