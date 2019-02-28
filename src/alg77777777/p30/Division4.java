package alg77777777.p30;

public class Division4 {
    static long cont;

    public static boolean rec4(int n)
    {
        if (n<=0)
            cont++;
        else
        {
            int aux = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    aux++;
                }
            }
            cont++ ; // O(1)
            rec4(n/2);
            rec4(n/2);
            rec4(n/2);
            rec4(n/2);
        }
        return true;
    }

    public static void main (String arg [])
    {
        long t1,t2,cont;
        int nVeces= Integer.parseInt (arg [0]);
        boolean b=true;

        for (int n=1;n<=10000000;n*=2)
        {
            t1 = System.currentTimeMillis ();

            for (int repeticiones=1; repeticiones<=nVeces;repeticiones++)
            {
                cont=0;
                b= rec4(n);
            }

            t2 = System.currentTimeMillis ();

            System.out.println (b+" n="+n+ "**TIEMPO="+(t2-t1)+"**nVeces="+nVeces);

        }  // for

    } // main
}