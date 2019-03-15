package alg77777777.p4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Huffman {
    private final String file;
    private List<Nodo> nodos = new LinkedList<>();
    private Nodo tree;


    public Huffman(String file) {
        this.file = file;
    }

    private PriorityQueue<Nodo> readFile(String file) throws IOException {

        return Files.readAllLines(new File(file).toPath()).stream()
                .map(linea -> {
                    String[] claveValor = linea.split(" ");
                    Nodo nodo = new Nodo(Integer.valueOf(claveValor[1]), claveValor[0]);
                    nodos.add(nodo);
                    return nodo;
                })
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(Nodo::getFrecuencia))));
    }

    public void generaTree() throws IOException {
        PriorityQueue<Nodo> cola = readFile(this.file);
        while (cola.size() > 1) {
            Nodo n1 = cola.poll().setCodigo("0");
            Nodo n2 = cola.poll().setCodigo("1");
            cola.add(new Nodo(n1.getFrecuencia() + n2.getFrecuencia(), n1, n2));
        }
        this.tree = cola.poll();
    }

    private void DFS(Nodo nodo, String cod) {
        String newCode = cod + nodo.getCodigo();
        if (nodo.isHoja()) {
            nodo.setCodigo(newCode);
        } else {
            if (nodo.getLeft() != null)
                DFS(nodo.getLeft(), newCode);
            if (nodo.getRight() != null)
                DFS(nodo.getRight(), newCode);
        }
    }

    public void run() {
        try {
            generaTree();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DFS(tree, "");
        System.out.println();
    }

    public Map<String, String> getCodes() {
        return this.nodos.stream()
                .collect(Collectors.toMap(Nodo::getLetra, Nodo::getCodigo));
    }

}
