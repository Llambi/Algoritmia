package alg77777777.p1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;

public class Matrix {

    /**
     * Crea una matriz de tamaño nxn y la rellena con valores aleatorios, estos valores aleatorios deben de ser
     * parametrizables entre un máximo y un mínimo.
     *
     * @param n   Tamaño de la matriz.
     * @param min Minimo valor de los randoms que rellenaran la matriz.
     * @param max Maximo valor de los randoms que rellenaran la matriz.
     * @return Matriz ya formada.
     */
    public static int[][] MatrizOperaciones(int n, int min, int max) {
        int[][] matriz = new int[n][n];
        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rng.nextInt(max + 1) + min;
            }
        }
        return matriz;
    }

    /**
     * Crea una matriz a partir de los datos del fichero. El formato del fichero será: Primera línea, un entero con
     * tamaño de la matriz (n), resto de las líneas, la fila correspondiente en la que cada valor estará separado por
     * un tabulador del siguiente.
     *
     * @param nomFich Ruta al fichero que se quiere usar.
     * @return Matriz ya formada.
     */
    public static int[][] MatrizOperaciones(String nomFich) {
        int[][] matriz;
        List<String> lines = null;

        try {
            lines = Files.readAllLines(new File(nomFich).toPath());
        } catch (IOException e) {
            System.err.println("El archivo, o la ruta dada no existe: " + nomFich);
        }

        int tam = Integer.valueOf(lines.get(0));
        matriz = new int[tam][tam];

        for (int i = 1; i < tam; i++) {
            int[] numbers = Arrays.stream(lines.get(1).split("\t")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(numbers, 0, matriz[i], 0, tam);
        }
        return matriz;
    }

    /**
     * Devuelve el tamaño de la matriz.
     *
     * @param matriz Matriz de la que se quiere calcular el tamaño.
     * @return Tamño de la matriz (Debe ser cuadrada).
     */
    public static int getTam(int[][] matriz) {
        return matriz[0].length;
    }

    /**
     * Muestra el contenido de la matriz por pantalla.
     *
     * @param matriz Matriz que se quiere imprimir.
     */
    public static void escribir(int[][] matriz) {
        int tam = getTam(matriz);
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(matriz[i][j] + j == tam - 1 ? "\n" : "");
            }
        }
    }

    /**
     * Calcula de forma iterativa la suma de la diagonal. Forma 1: recorrer toda la matriz, pero sólo sumando los
     * elementos de la diagonal.
     *
     * @param matriz Matriz de la que se desea conocer la suma de su diagonal.
     * @return Suma acumulada de la diagonal de la matriz dada.
     */
    public static int sumarDiagonal1(int[][] matriz) {
        int tam = getTam(matriz);
        int acum = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (i == j)
                    acum += matriz[i][j];
            }
        }
        return acum;
    }

    /**
     * Calcula de forma iterativa la suma de la diagonal. Forma 2: recorrer los elementos de la diagonal sumándolos
     *
     * @param matriz atriz de la que se desea conocer la suma de su diagonal.
     * @return Suma acumulada de la diagonal de la matriz dada.
     */
    public static int sumarDiagonal2(int[][] matriz) {
        int tam = getTam(matriz);
        int sum = 0;
        for (int i = 0; i < tam; i++) {
            sum += matriz[i][i];
        }
        return sum;
    }

    /**
     * En una matriz cuyos valores varían entre 1 y 4 vamos a trazar un “camino” partienendo de la posición (i,j) que
     * pasamos como parámetro y utilizando los valores de la matriz como códigos de dirección: 1 - arriba, 2 -
     * derecha, 3 - abajo, 4 – izquierda. Vamos a utilizar para marcar el camino el código -1. El proceso finalizará
     * cuando el camino salga de los límites de la matriz o bien alcance una casilla ya recorrida.
     *
     * @param matriz Matriz de la que se quiere calcular el camino
     * @param i      Coordenada en el eje y desde donde se quiere comenzar.
     * @param j      Coordenada en el eje x desde donde se quiere comenzar.
     */
    public static void recorrerCamino(int[][] matriz, int i, int j) {
        int tam = getTam(matriz);
        do {
            int value = matriz[i][j];
            matriz[i][j] = -1;
            if (value % 2 != 0) {
                i += (value - 2);
            } else {
                j += (3 - value);
            }
        } while (i >= 0 && j >= 0 && i < tam && j < tam && matriz[i][j] != -1);

        escribir(matriz);
    }
}
