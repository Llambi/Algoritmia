package alg77777777.p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaNecklace {

    @Test
    public void test1(){
        Necklace necklace = new Necklace("RDDRR");
        necklace.setDiccionario(NecklaceFactory.getSimpleValuesTable());
        System.out.println(necklace.getNecklace());
        System.out.println(necklace.getCharms());
        int sol = necklace.run();
        assertEquals(sol,16);
        System.out.println(sol);
        String solList = necklace.getCharmSolution().toString();
        assertEquals("[R, DDR, R]", solList);
        System.out.println(solList);
    }

    @Test
    public void test2(){
        Necklace necklace = new Necklace("RDDRRRRDRDD");
        necklace.setDiccionario(NecklaceFactory.getSimpleValuesTable());
        System.out.println(necklace.getNecklace());
        System.out.println(necklace.getCharms());
        int sol = necklace.run();
        assertEquals(sol,30);
        System.out.println(sol);
        String solList = necklace.getCharmSolution().toString();
        assertEquals("[R, DDR, RRR, D, R, DD]", solList);
        System.out.println(solList);
    }
}
