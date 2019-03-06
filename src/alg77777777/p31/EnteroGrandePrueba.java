package alg77777777.p31;

import java.math.BigInteger;

public class EnteroGrandePrueba {

    public static void main(String[] args) {
//        pruebaSimple();
        EnteroGrande ent1 = new EnteroGrande("0981");
        EnteroGrande ent2 = new EnteroGrande("1234");
        pruebaMultiplicacionClasica(ent1, ent2);
        pruebaMultiplicacionDV(ent1, ent2);
//        for (int i = 0; i < 1; i++) {
//            System.out.println("Prueba " + i);
//
//            int c = 512; // num cifras
//            EnteroGrande ent1 = EnteroGrande.generar(c);
//            EnteroGrande ent2 = EnteroGrande.generar(c);
//            System.out.println("Aleatorio de " + c + " cifras: \t" + ent1.mostrarVista());
//            System.out.println("Aleatorio de " + c + " cifras: \t" + ent2.mostrarVista());
//
//            pruebaMultiplicacionClasica(ent1, ent2);
//			pruebaMultiplicacionDV(ent1, ent2);
//
//
//        }
        System.out.println("Fin pruebas");

    }

    private static void pruebaSimple() {
        EnteroGrande ent1 = new EnteroGrande("0981");
        EnteroGrande ent2 = new EnteroGrande("1234");
        EnteroGrande res = ent1.multiplicarDV(ent2);
        System.out.println("Mult Entero1=" + ent1 + " * Entero2=" + ent2 + " = " + res.mostrarVista() + " ********************");
        if (res.compareTo(new EnteroGrande("1210554")) != 0)
            System.err.println("Error en la mult res= " + res.mostrarVista()
                    + " / correcto= " + new EnteroGrande("1210554").mostrarVista() + "********************");
    }

    private static void pruebaMultiplicacionClasica(EnteroGrande ent1, EnteroGrande ent2) {
        EnteroGrande res = ent1.multiplicarClasica(ent2);
        BigInteger bi1 = new BigInteger(ent1.toString());
        BigInteger bi2 = new BigInteger(ent2.toString());
        BigInteger bires = bi1.multiply(bi2);
        if (!bires.toString().equals(res.toString()))
            System.err.println("Error en la mult Entero1=" + ent1 + " * Entero2=" + ent2 + "********************");
        System.out.println("Mult Entero1 * Entero2=\t" + res);
        System.out.println("BigInteger multiply=\t" + bires.toString());
    }

    private static void pruebaMultiplicacionDV(EnteroGrande ent1, EnteroGrande ent2) {
        EnteroGrande res = ent1.multiplicarDV(ent2);
        if (res.compareTo(new EnteroGrande(Long.parseLong(ent1.toString()) * Long.parseLong(ent2.toString()))) != 0)
            System.err.println("Error en la mult Entero1=" + ent1 + " * Entero2=" + ent2 + "********************");
        System.out.println("Mult Entero1 * Entero2= \t" + res.mostrarVista());

    }
}
