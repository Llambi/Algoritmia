package alg77777777.p1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Clase que simula una matriz de numeros.
 */
public class Matrix {

    private int[][] matrix;
    private int min;
    private int max;

    /**
     * Contructor de la clase para crear una matriz de tamaño n y con los valores de esta entre 0 y 4.
     *
     * @param tam Tamaño de la matriz.
     */
    public Matrix(int tam) {
        this.min = 0;
        this.max = 4;
        this.matrix = matrizOperaciones(tam);
    }

    /**
     * Constructor de la clase para crear una matriz de tamaño n y con los valores de esta entre un minimo y maximo dados.
     *
     * @param tam Tamaño de la matriz.
     * @param min minimo de los valores de la matriz.
     * @param max Maximo de los valores de la matriz.
     */
    public Matrix(int tam, int min, int max) {
        this.min = min;
        this.max = max;
        this.matrix = matrizOperaciones(tam);
    }

    /**
     * Constructor de la clase para crear una una matriz a partir de un fichero dado.
     *
     * @param nomFich Ruta al fichero que se quiere usar para crear la matriz.
     */
    public Matrix(String nomFich) {
        this.matrix = matrizOperaciones(nomFich);
    }

    /**
     * Crea una matriz de tamaño nxn y la rellena con valores aleatorios, estos valores aleatorios deben de ser
     * parametrizables entre un máximo y un mínimo.
     *
     * @param n Tamaño de la matriz.
     * @return Matriz ya formada.
     */
    public int[][] matrizOperaciones(int n) {
        int[][] matriz = new int[n][n];
        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rng.nextInt(this.max + 1) + this.min;
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
    public int[][] matrizOperaciones(String nomFich) {
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
     * @return Tamño de la matriz (Debe ser cuadrada).
     */
    public int getTam() {
        return this.matrix[0].length;
    }

    /**
     * Muestra el contenido de la matriz por pantalla.
     */
    public void escribir() {
        int tam = getTam();
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print(this.matrix[i][j]+ " " + (j == tam - 1 ? "\n\n" : ""));
            }
        }
    }

    /**
     * Calcula de forma iterativa la suma de la diagonal. Forma 1: recorrer toda la matriz, pero sólo sumando los
     * elementos de la diagonal.
     *
     * @return Suma acumulada de la diagonal de la matriz dada.
     */
    public int sumarDiagonal1() {
        int tam = getTam();
        int acum = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (i == j)
                    acum += this.matrix[i][j];
            }
        }
        return acum;
    }

    /**
     * Calcula de forma iterativa la suma de la diagonal. Forma 2: recorrer los elementos de la diagonal sumándolos
     *
     * @return Suma acumulada de la diagonal de la matriz dada.
     */
    public int sumarDiagonal2() {
        int tam = getTam();
        int sum = 0;
        for (int i = 0; i < tam; i++) {
            sum += this.matrix[i][i];
        }
        return sum;
    }

    /**
     * En una matriz cuyos valores varían entre 1 y 4 vamos a trazar un “camino” partienendo de la posición (i,j) que
     * pasamos como parámetro y utilizando los valores de la matriz como códigos de dirección: 1 - arriba, 2 -
     * derecha, 3 - abajo, 4 – izquierda. Vamos a utilizar para marcar el camino el código -1. El proceso finalizará
     * cuando el camino salga de los límites de la matriz o bien alcance una casilla ya recorrida.
     *
     * @param i Coordenada en el eje y desde donde se quiere comenzar.
     * @param j Coordenada en el eje x desde donde se quiere comenzar.
     */
    public void recorrerCamino(int i, int j) {
        int tam = getTam();
        do {
            int value = this.matrix[i][j];
            this.matrix[i][j] = -1;
            if (value % 2 != 0) {
                i += (value - 2);
            } else {
                j += (3 - value);
            }
        } while (i >= 0 && j >= 0 && i < tam && j < tam && this.matrix[i][j] != -1);

        escribir();
    }
}
