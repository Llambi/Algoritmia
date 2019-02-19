package alg77777777.p2;

public class Burbuja extends Vector {
    public Burbuja(int nElementos) {
        super(nElementos);
    }

    /**
     * Ordenación por el método de Burbuja
     */

    @Override
    public void ordenar() {
        int n = elements.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (elements[j - 1] > elements[j]) {
                    //swap elements
                    temp = elements[j - 1];
                    elements[j - 1] = elements[j];
                    elements[j] = temp;
                }

            }
        }
    }

    @Override
    public String getNombre() {
        return "Burbuja";
    }
} 