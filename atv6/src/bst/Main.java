package bst;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BSTImpl arvore = new BSTImpl();

        System.out.println("----- Inserção -----");
        int[] valores = {30, 20, 40, 10, 25, 35, 50, 5, 15, 45, 60};

        for (int v : valores) {
            System.out.println("Inserindo: " + v);
            arvore.insert(v);
        }

        System.out.println("\nÁrvore em BFS (nível): " + arvore.bfs());
        System.out.println("Árvore em pré-ordem:   " + Arrays.toString(arvore.preOrder()));
        System.out.println("Árvore em ordem:       " + Arrays.toString(arvore.order()));
        System.out.println("Árvore em pós-ordem:   " + Arrays.toString(arvore.postOrder()));
        System.out.println("Altura da árvore: " + arvore.height());
        System.out.println("Tamanho da árvore: " + arvore.size());

        System.out.println("\n----- Busca -----");
        int busca = 25;
        Node encontrado = arvore.search(busca);
        System.out.println("Busca por " + busca + ": " + (encontrado != null ? "Encontrado" : "Não encontrado"));

        System.out.println("\n----- Sucessor e Predecessor -----");
        Node no = arvore.search(30);
        Node pred = arvore.predecessor(no);
        Node succ = arvore.sucessor(no);
        System.out.println("Predecessor de 30: " + (pred != null ? pred.getValue() : "null"));
        System.out.println("Sucessor de 30: " + (succ != null ? succ.getValue() : "null"));

        System.out.println("\n----- Remoção -----");
        int[] removidos = {40, 20, 30};
        for (int v : removidos) {
            System.out.println("Removendo: " + v);
            arvore.remove(v);
            System.out.println("BFS após remover " + v + ": " + arvore.bfs());
        }

        System.out.println("\nFinal: pré-ordem: " + Arrays.toString(arvore.preOrder()));
    }
}


