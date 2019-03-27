package alg77777777.p5;

public class PruebaNecklace {
    public static void main(String[] args) {
        int n = 5;
        Necklace necklace = new Necklace("RDDRR");
        necklace.setDiccionario(NecklaceFactory.getSimpleValuesTable());
        System.out.println(necklace.getNecklace());
        System.out.println(necklace.getCharms());
        System.out.println(necklace.run());
        System.out.println(necklace.getCharmSolution());
    }
}
