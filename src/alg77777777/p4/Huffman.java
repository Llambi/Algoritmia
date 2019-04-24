package alg77777777.p4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Huffman {

    private Map<String, String> codes = new HashMap<>();
    private PriorityQueue<Nodo> cola;
    private Nodo root;


    public Huffman(String file) {
        try {
            this.cola = readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            if (this.root == null)
                generaTree();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DFS(this.root, "");
    }

    public void generaTree() throws IOException {   // O(n)
        while (this.cola.size() > 1) {
            Nodo n1 = this.cola.poll().setCodigo("0");
            Nodo n2 = this.cola.poll().setCodigo("1");
            this.cola.add(new Nodo(n1.getFrecuencia() + n2.getFrecuencia(), n1, n2));
        }
        this.root = cola.poll();
    }

    private PriorityQueue<Nodo> readFile(String file) throws IOException {
        return Files.readAllLines(new File(file).toPath()).stream()
                .map(linea -> {
                    String[] claveValor = linea.split(" ");
                    Nodo nodo = new Nodo(Integer.valueOf(claveValor[1]), claveValor[0]);
                    return nodo;
                })
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Comparator.comparingInt(Nodo::getFrecuencia))));
    }

    private void DFS(Nodo nodo, String cod) {
        String newCode = cod + nodo.getCodigo();
        if (nodo.isHoja()) {
            codes.put(nodo.getLetra(), newCode);
            nodo.setCodigo(newCode);
        } else {
            if (nodo.getLeft() != null)
                DFS(nodo.getLeft(), newCode);
            if (nodo.getRight() != null)
                DFS(nodo.getRight(), newCode);
        }
    }

    public Map<String, String> getCodes() {
        if (this.codes.isEmpty())
            run();
        return this.codes;
    }

}
