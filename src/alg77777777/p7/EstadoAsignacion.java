package alg77777777.p7;

import alg77777777.util.Estado;

import java.util.ArrayList;
import java.util.Arrays;

import static alg77777777.p7.EmparejamientoEO_RyP.*;

public class EstadoAsignacion extends Estado {

    private boolean[] emparejada;   // La posicion se refiere a la mujer.
    private int[] asignacion;   //la posicion sera el hombre el valor sera la mujer.

    public EstadoAsignacion() {
        super();
        this.emparejada = new boolean[TAM];
        this.asignacion = new int[TAM];
        Arrays.fill(this.asignacion, -1);
    }

    public EstadoAsignacion(EstadoAsignacion padre, int j) {
        super();

        //asignacion del padre
        this.emparejada = Arrays.copyOf(padre.emparejada, TAM);
        this.asignacion = Arrays.copyOf(padre.asignacion, TAM);
        this.profundidad = padre.profundidad;
        this.id = padre.id;

        //Añadido del mismo
        this.asignacion[profundidad] = j;
        this.emparejada[j] = true;
        profundidad++;
        calcularValorHeuristico();


        //Unificacion de los dos ultimos pasos.
        if (profundidad == TAM - 1) {
            int mujerPorAasignar = -1;

            for (int i = 0; i < TAM; i++) {
                if (!this.emparejada[i] && seSoportan(this.profundidad, i)) {
                    mujerPorAasignar = i;
                }
            }
            if (mujerPorAasignar != -1) {
                this.asignacion[this.profundidad] = mujerPorAasignar;
                this.emparejada[mujerPorAasignar] = true;
                profundidad++;
                calcularValorHeuristico();
            }
        }
    }

    @Override
    public void calcularValorHeuristico() {
        int valorHeuristico = 0;

        for (int i = 0; i < this.profundidad; i++) {
            valorHeuristico += getTolerancia(i, this.asignacion[i]);
        }

        for (int i = 0; i < TAM; i++) {
            if (!this.emparejada[i] && seSoportan(this.profundidad, i)) {
                valorHeuristico += minimoColumna(this.profundidad, i);
            }
        }
        this.valorHeuristico = valorHeuristico;
    }

    private int getTolerancia(int i, int j) {
        return MATRIZHOMBRES[i][j] + MATRIZMUJERES[j][i];
    }

    private int minimoColumna(int profundidad, int j) {
        int minValorCol = Integer.MAX_VALUE;
        for (int i = profundidad; i < TAM; i++) {
            int tolerancia = getTolerancia(i, j);
            if (tolerancia < minValorCol) {
                minValorCol = tolerancia;
            }
        }
        return minValorCol;
    }

    @Override
    public ArrayList<Estado> expandir() {
        ArrayList<Estado> listaHijos = new ArrayList<>();
        int cotaHijos = COTAPODA;
        for (int i = 0; i < TAM; i++) {
            if (!this.emparejada[i] && seSoportan(profundidad, i) && getHeuristico() + getTolerancia(profundidad, i) <= cotaHijos) {
                cotaHijos = getHeuristico() + getTolerancia(profundidad, i);
                Estado hijo = new EstadoAsignacion(this, i);
                listaHijos.add(hijo);
            }
        }
        return listaHijos;
    }

    @Override
    public boolean solucion() {
        return this.profundidad == TAM;
    }

    @Override
    public int valorInicialPoda() {
        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < TAM; i++) {
            diagonal1 += getTolerancia(i, i);
            diagonal2 += getTolerancia(i, TAM - i - 1);
        }
        return diagonal1 < diagonal2 ? diagonal1 : diagonal2;
    }

    private boolean seSoportan(int nivel, int i) {
        return MATRIZHOMBRES[nivel][i] <= UMBRAL && MATRIZMUJERES[i][nivel] <= UMBRAL;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.asignacion);
    }
}
