package alg77777777.p2;

/**
 * Este programa sirve para ordenar n elementos
 * con un algoritmo de los "malos" (cuadrático)·
 * Es la INSERCIÓN DIRECTA
 */
public class Insercion extends Vector {

    public Insercion(int nElementos) {
        super(nElementos);
    }

    /**
     * Ordenación por inserción directa
     */

    @Override
    public void ordenar() {
        int tam = elements.length;
        int pos = 1;

        while (pos < tam) {
            if (elements[pos] < elements[pos - 1]) {
                int element = pos;
                int previous = pos - 1;
                do {
                    permut(elements, element, previous);
                    element--;
                    previous--;
                } while (previous >= 0 && elements[element] < elements[previous]);
            }
            pos++;
        }
    }

    private void permut(int[] lista, int element, int previous) {
        int aux = lista[element];
        lista[element] = lista[previous];
        lista[previous] = aux;
    }

    @Override
    public String getNombre() {
        return "Inserción directa";
    }
}