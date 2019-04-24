package alg77777777.p6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Empareja {

    private int umbral;

    private int[][] matrizHombres;
    private int[][] matrizMujeres;
    private int tam;
    private boolean[] emparejada;   // La posicion se refiere a la mujer.

    private int[] asignacion;   //la posicion sera el hombre el valor sera la mujer.
    private int puntuacion;

    private int[] mejorAsignacion;
    private int mejorPuntuacion;

    public Empareja(String nomFich, int umbral) {
        this.umbral = umbral;
        Object[] obj = initMatrix(nomFich); //inicializa tam tambien.
        this.matrizHombres = (int[][]) obj[0];
        this.matrizMujeres = (int[][]) obj[1];
        this.asignacion = new int[this.tam];
        this.mejorAsignacion = new int[this.tam];
        this.emparejada = new boolean[this.tam];
        this.puntuacion = 0;
        this.mejorPuntuacion = Integer.MAX_VALUE;


    }

    public void run() {
        backtracking(0);
    }

    /**
     * El nivel es es el hombre e i la mujer
     *
     * @param nivel
     */
    private void backtracking(int nivel) {
        if (nivel == this.tam)  //hay ya una asignación completa
        {
            if (this.puntuacion < this.mejorPuntuacion) {
                System.arraycopy(this.asignacion, 0, this.mejorAsignacion, 0, this.tam);
                this.mejorPuntuacion = this.puntuacion;
            }
        } else {
            for (int i = 0; i < this.tam; i++)
                if (!this.emparejada[i] && seSoportan(nivel, i))    // && this.puntuacion<this.mejorPuntuacion
                {
                    this.asignacion[nivel] = i;

                    this.puntuacion = this.puntuacion + (this.matrizHombres[nivel][i] + this.matrizMujeres[nivel][i]);
                    this.emparejada[i] = true;

                    backtracking(nivel + 1);

                    this.puntuacion = this.puntuacion - (this.matrizHombres[nivel][i] + this.matrizMujeres[nivel][i]);
                    this.emparejada[i] = false;
                }
            this.puntuacion = 0;
        }

    }

    private boolean seSoportan(int nivel, int i) {
        return this.matrizHombres[nivel][i] <= this.umbral && this.matrizMujeres[i][nivel] <= this.umbral;
    }

    public int[] getMejorAsignacion() {
        return mejorAsignacion;
    }

    public int getMejorPuntuacion() {
        return mejorPuntuacion;
    }

    private Object[] initMatrix(String nomFich) {
        List<String> lines = null;

        try {
            lines = Files.readAllLines(new File(nomFich).toPath());
        } catch (IOException e) {
            System.err.println("El archivo, o la ruta dada no existe: " + nomFich);
        }

        this.tam = Integer.valueOf(lines.get(0));
        int[][] matriz0 = new int[this.tam][this.tam];
        int[][] matriz1 = new int[this.tam][this.tam];

        for (int i = 1; i <= this.tam; i++) {
            int[] numbers = Arrays.stream(lines.get(i).split("\t")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(numbers, 0, matriz0[i - 1], 0, this.tam);
            numbers = Arrays.stream(lines.get(i + this.tam + 1).split("\t")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(numbers, 0, matriz1[i - 1], 0, this.tam);
        }
        return new Object[]{matriz0, matriz1};
    }
}
