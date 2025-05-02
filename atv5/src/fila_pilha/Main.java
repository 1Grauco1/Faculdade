package fila_pilha;

import java.util.Iterator;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        // PILHA

        Pilha stack= new Pilha(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Pilha stack <10>: ");
        stack.printP();

        System.out.println();

        //Pop
        int pop= stack.pop();
        System.out.println("Retornado e Removido: "+ pop);
        pop= stack.pop();
        System.out.println("Retornado e Removido: "+ pop);
        pop= stack.pop();
        System.out.println("Retornado e Removido: "+ pop);
        stack.printP();

        //isFull
        System.out.println();
        System.out.print(stack.isFull()? "Está cheia" : "Não está cheia");
        System.out.println();

        //Top
        System.out.println("Topo: "+ stack.top());
        System.out.println();

        //ToArray
        Integer[] array= stack.toArray();
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }
}