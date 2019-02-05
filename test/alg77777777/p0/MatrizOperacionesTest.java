package alg77777777.p0;

import alg77777777.p1.MatrizOperaciones;
import junit.framework.TestCase;

public class MatrizOperacionesTest extends TestCase {

    public void testMatrizOperaciones() {
        MatrizOperaciones m = new MatrizOperaciones(4);
        m.escribir();
        m = new MatrizOperaciones(5, 3, 10);
        m.escribir();
    }

    public void testMatrizOperacionesNomFich() {
        MatrizOperaciones m = new MatrizOperaciones("resources/matriz01.txt");
        m.escribir();
        m = new MatrizOperaciones("resources/matriz02.txt");
        m.escribir();
    }

    public void testGetTam() {
        MatrizOperaciones m = new MatrizOperaciones(4);
        assertEquals(4, m.getTam());
        m = new MatrizOperaciones(5, 3, 10);
        assertEquals(5, m.getTam());
    }

    public void testSumarDiagonal() {
        MatrizOperaciones m = new MatrizOperaciones("resources/matriz02.txt");
        assertEquals(25, m.sumarDiagonal1());
        assertEquals(25, m.sumarDiagonal2());
        assertEquals(m.sumarDiagonal1(), m.sumarDiagonal2());
    }

    public void testRecorrerCamino() {
        MatrizOperaciones m = new MatrizOperaciones("resources/matriz02.txt");
        m.recorrerCamino(1,2);
        m = new MatrizOperaciones("resources/matriz02.txt");
        m.recorrerCamino(0,4);
    }
}