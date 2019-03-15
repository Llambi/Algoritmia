package alg77777777.p4;

public class Nodo {
    private String letra;
    private String codigo;
    private int frecuencia;
    private Nodo left;
    private Nodo right;

    public Nodo(){
        this.letra = "AUXILIAR";
        this.setCodigo("");
    }

    public Nodo(int frecuencia, Nodo left, Nodo right) {
        this();
        this.frecuencia = frecuencia;
        this.left = left;
        this.right = right;
    }

    public Nodo(int frecuencia, String letra) {
        this();
        this.frecuencia = frecuencia;
        this.letra = letra;
    }

    public String getLetra() {
        return letra;
    }

    public String getCodigo() {
        return codigo;
    }

    public Nodo setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public Nodo getLeft() {
        return left;
    }

    public Nodo getRight() {
        return right;
    }

    public boolean isHoja() {
        return this.right==null && this.left==null;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "letra='" + letra + '\'' +
                ", codigo='" + codigo + '\''+
                '}';
    }
}
