package alg77777777.p7;

import alg77777777.util.RamificaYPoda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class EmparejamientoEO_RyP extends RamificaYPoda {

    protected static  int UMBRAL;
    protected static int[][] MATRIZHOMBRES;
    protected static int[][] MATRIZMUJERES;
    protected static int TAM;

    public EmparejamientoEO_RyP(String nomFich, int umbral, boolean traza) {
        EmparejamientoEO_RyP.UMBRAL = umbral;
        Object[] obj = initMatrix(nomFich); //inicializa TAM tambien.
        MATRIZHOMBRES = (int[][]) obj[0];
        MATRIZMUJERES = (int[][]) obj[1];
        TRAZA = traza;
        this.nodoRaiz = new EstadoAsignacion();
    }

    public static void main(String[] args) {
        EmparejamientoEO_RyP empareja = new EmparejamientoEO_RyP("resources/rechazo06.txt", 4, true);

        empareja.ramificaYPoda(empareja.nodoRaiz);

        empareja.mostrarTrazaSolucion();

        empareja = new EmparejamientoEO_RyP("resources/rechazo06.txt", 2, true);

        empareja.ramificaYPoda(empareja.nodoRaiz);

        empareja.mostrarTrazaSolucion();
    }

    private Object[] initMatrix(String nomFich) {
        List<String> lines = null;

        try {
            lines = Files.readAllLines(new File(nomFich).toPath());
        } catch (IOException e) {
            System.err.println("El archivo, o la ruta dada no existe: " + nomFich);
        }

        this.TAM = Integer.valueOf(lines.get(0));
        int[][] matriz0 = new int[TAM][TAM];
        int[][] matriz1 = new int[TAM][TAM];

        for (int i = 1; i <= TAM; i++) {
            int[] numbers = Arrays.stream(lines.get(i).split("\t")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(numbers, 0, matriz0[i - 1], 0, TAM);
            numbers = Arrays.stream(lines.get(i + TAM + 1).split("\t")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(numbers, 0, matriz1[i - 1], 0, TAM);
        }
        return new Object[]{matriz0, matriz1};
    }
}
