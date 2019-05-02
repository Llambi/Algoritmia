package alg77777777.pFinal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class EmparejamientoEO {

    private int umbral;
    private int costeBuscado;
    private int[][] matrizHombres;
    private int[][] matrizMujeres;
    private int tam;
    private boolean[] emparejada;   // La posicion se refiere a la mujer.
    private int[] asignacion;   //la posicion sera el hombre el valor sera la mujer.
    private int puntuacion;
    private int[] mejorAsignacion;
    private int mejorPuntuacion;
    private boolean flag;

    public EmparejamientoEO(String nomFich, int umbral, int costeBuscado) {
        this.umbral = umbral;
        this.costeBuscado = costeBuscado;
        Object[] obj = initMatrix(nomFich); //inicializa tam tambien.
        this.matrizHombres = (int[][]) obj[0];
        this.matrizMujeres = (int[][]) obj[1];
        this.asignacion = new int[this.tam];
        this.mejorAsignacion = new int[this.tam];
        this.emparejada = new boolean[this.tam];
        this.puntuacion = 0;
        this.mejorPuntuacion = Integer.MAX_VALUE;
        this.flag = false;

    }

    public static void main(String[] args) {
        String nomFich = args[0];
        int umbral = Integer.parseInt(args[1]);
        int costeBuscado = Integer.parseInt(args[2]);

        EmparejamientoEO e = new EmparejamientoEO(nomFich, umbral, costeBuscado);
        e.run();
        if(!e.flag) System.out.println(Arrays.toString(e.getMejorAsignacion()) + "\n" + e.getMejorPuntuacion() + "\n");

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
            if (this.puntuacion == this.costeBuscado) {
                this.flag = true;
                System.arraycopy(this.asignacion, 0, this.mejorAsignacion, 0, this.tam);
                this.mejorPuntuacion = this.puntuacion;
                System.out.println(Arrays.toString(getMejorAsignacion()) + "\n" + this.getMejorPuntuacion() + "\n");
            }
            else if (!flag && compruebaCosteBuscado(this.puntuacion) < compruebaCosteBuscado(this.mejorPuntuacion)) {
                System.arraycopy(this.asignacion, 0, this.mejorAsignacion, 0, this.tam);
                this.mejorPuntuacion = this.puntuacion;
//                System.out.println(Arrays.toString(getMejorAsignacion()) + "\n" + this.getMejorPuntuacion() + "\n");
            }
        } else {
            for (int i = 0; i < this.tam; i++)
                if (!this.emparejada[i] && seSoportan(nivel, i))    // && this.puntuacion<this.mejorPuntuacion
                {
                    this.asignacion[nivel] = i;

                    this.puntuacion += this.matrizHombres[nivel][i] + this.matrizMujeres[i][nivel];
                    this.emparejada[i] = true;

                    backtracking(nivel + 1);

                    this.puntuacion -= this.matrizHombres[nivel][i] + this.matrizMujeres[i][nivel];
                    this.emparejada[i] = false;
                }
        }
    }


    private int compruebaCosteBuscado(int puntuacion) {
        return Math.abs(this.costeBuscado - puntuacion);
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
