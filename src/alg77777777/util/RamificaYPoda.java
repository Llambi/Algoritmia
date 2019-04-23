// ESQUEMA GENERAL RAMIFICA Y PODA

package alg77777777.util;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Clase principal gen�rica que implementa la t�cnica de Ramificaci�n y poda
 */
public class RamificaYPoda {
    public static boolean TRAZA = true;    // Activa / desactiva traza por pantalla

    protected ColaPrioridad cola;    // nodos pendientes de expandir
    protected Estado nodoRaiz;        // contiene el nodo inicial

    public static int COTAPODA;            // valor de la cota de poda

    protected Estado mejorSolucion;    // para guardar el nodo de la mejor soluci�n (aplicable a probl. optimizaci�n

    public RamificaYPoda() {
        cola = new ColaPrioridad(Comparator.comparingInt(Estado::getHeuristico));        //crea Monticulo vac�o
    }

    /**
     * M�todo principal que implementa la ejecuci�n de la t�cnica Ramifica y poda
     *
     * @param nodoRaiz Le pasamos el nodo ra�z para el problema que queremos resolver
     */
    public void ramificaYPoda(Estado nodoRaiz) {
        cola.insertar(nodoRaiz);

        COTAPODA = nodoRaiz.valorInicialPoda();        // Inicializa cota a un valor inicial, por defecto +infinito (no poda)

        // Procesamos los estados de la cola
        // mientras la cola no est� vac�a y el mejor estado no est� por enciam de la cota de poda
        while (!cola.vacia() && cola.estimacionMejor() < COTAPODA) {
            Estado actual = cola.sacarMejorNodo();        // recuperamos el estado m�s prometedor

            ArrayList<Estado> hijos = actual.expandir();    // expandimos todos los hijos v�lidos del estado acutal

            // Recorre todos los hijos creados comprobando que est�n por debajo de la cota de poda
            for (Estado estadoHijo : hijos) {
                if (estadoHijo.getHeuristico() < COTAPODA) {  // �Est� por debajo de la cota?
                    if (estadoHijo.solucion())                // �Es una soluci�n al problema?
                    {
                        // si es soluci�n y no la hemos podado, seguro que es mejor que la anterior
                        mejorSolucion = estadoHijo;
                        COTAPODA = estadoHijo.getHeuristico();    // Establecemos la cota al valor de la nueva soluci�n

                        /**/
                        if (TRAZA) {
                            System.out.println("*** Nueva soluci�n mejor");
                            System.out.println("Nueva cota de poda: " + COTAPODA);
                            System.out.println(estadoHijo + "\n");
                        }
                    } else {
                        // si no es soluci�n a la cola de prioridad, pendiente de desarrollar
                        cola.insertar(estadoHijo);
                    }
                }
            }
        } //while
    }


    public Estado getNodoRaiz() {
        return nodoRaiz;
    }


    public void mostrarTrazaSolucion() {
        System.out.println("**************************************************************");
        System.out.println("Solucion al problema");
        if (mejorSolucion == null) {
            System.out.println("NO HAY SOLUCION");
        } else {

            System.out.println("\nMejor asignacion: " + mejorSolucion);
            System.out.println("\nMejor puntuacion: " + mejorSolucion.getHeuristico());
            System.out.println("\nSoluci�n de " + mejorSolucion.getProfundidad() + " pasos\n");
        }
    }
}
