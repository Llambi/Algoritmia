package alg77777777.p6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PruebaEmparejar {

    @Test
    public void test1() {
        Empareja e = new Empareja("resources/rechazo06.txt", 4);
        e.run();
        System.out.println(Arrays.toString(e.getMejorAsignacion()));
        System.out.println(e.getMejorPuntuacion());
    }
}
