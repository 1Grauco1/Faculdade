package linked_list;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserção de elementos
        System.out.println("Inserindo elementos de 0 a 9:");
        for(int i = 0; i < 10; i++) {
            list.insert(i);
        }
        list.printL();
        System.out.println("Tamanho: " + list.size() + "\n");

        // Busca de elemento
        System.out.println("Buscando elemento 5:");
        No n = list.search(5);
        if(n != null) {
            System.out.println("Elemento encontrado: " + n.getDado() + "\n");
        } else {
            System.out.println("Elemento não encontrado\n");
        }

        // Remoção de elementos específicos
        System.out.println("Removendo elementos 3 e 6:");
        list.remove(3);
        list.remove(6);
        list.printL();
        System.out.println("Tamanho: " + list.size() + "\n");

        // Remoção do início e fim
        System.out.println("Removendo início e final:");
        list.removeInicio();
        list.removeFinal();
        list.printL();
        System.out.println("Tamanho: " + list.size() + "\n");

        // Conversão para array
        System.out.println("Convertendo para array:");
        No[] array = list.toArray();
        for(No i : array) {
            System.out.print("[" + i.getDado() + "] ");
        }
        System.out.println("\n");

        // Remoção da última ocorrência
        System.out.println("Removendo última ocorrência do 4:");
        list.removeLastOccurrence(4);
        list.printL();
        System.out.println("Tamanho: " + list.size() + "\n");

        // Verificação de duplicatas
        System.out.println("Verificando duplicatas:");
        System.out.println(list.duplicatas() ? "Existem duplicatas" : "Não existem duplicatas");
        System.out.println();

        // Maior e menor elemento
        System.out.println("Maior elemento: " + list.returnMaior());
        System.out.println("Menor elemento: " + list.returnMenor());
        System.out.println();

        // Percorrer em ordem inversa
        System.out.println("Elementos em ordem inversa:");
        List<Integer> inversa = list.percorreInverso();
        System.out.print("[");
        for (int i = 0; i < inversa.size(); i++) {
            System.out.printf(inversa.get(i)+ "");
            if(i < inversa.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

    }
}