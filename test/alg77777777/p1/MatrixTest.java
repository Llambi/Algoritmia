package alg77777777.p1;

import junit.framework.TestCase;

public class MatrixTest extends TestCase {

    public void testMatrizOperaciones() {
        Matrix m = new Matrix(4);
        m.escribir();
        m = new Matrix(5, 3, 10);
        m.escribir();
    }

    public void testMatrizOperacionesNomFich() {
        Matrix m = new Matrix("resources/matriz01.txt");
        m.escribir();
        m = new Matrix("resources/matriz02.txt");
        m.escribir();
    }

    public void testGetTam() {
        Matrix m = new Matrix(4);
        assertEquals(4, m.getTam());
        m = new Matrix(5, 3, 10);
        assertEquals(5, m.getTam());
    }

    public void testSumarDiagonal() {
        Matrix m = new Matrix("resources/matriz02.txt");
        assertEquals(25, m.sumarDiagonal1());
        assertEquals(25, m.sumarDiagonal2());
        assertEquals(m.sumarDiagonal1(), m.sumarDiagonal2());
    }

    public void testRecorrerCamino() {
        Matrix m = new Matrix("resources/matriz02.txt");
        m.recorrerCamino(1,2);
        m = new Matrix("resources/matriz02.txt");
        m.recorrerCamino(0,4);
    }
}