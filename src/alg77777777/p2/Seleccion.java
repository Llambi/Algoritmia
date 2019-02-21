package alg77777777.p2;

/**
 * Este programa sirve para ordenar n elementos
 * con un algoritmo de los "malos" (cuadrático)·
 * es la SELECCION
 */
public class Seleccion extends Vector {
    public Seleccion(int nElementos) {
        super(nElementos);
    }


    /**
     * Ordenación por selección
     */

    @Override
    public void ordenar() {
        int tam = elements.length;
        for (int i = 0; i < tam; i++) {
            int lower = i;
            for (int j = i; j < tam; j++) {
                if (elements[j] < elements[lower]) {
                    lower = j;
                }
            }
            permut(elements, i, lower);
        }
    }

    private void permut(int[] lista, int element, int previous) {
        int aux = lista[element];
        lista[element] = lista[previous];
        lista[previous] = aux;
    }

    @Override
    public String getNombre() {
        return "Selección";
    }
} 
