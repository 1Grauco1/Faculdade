package fila_pilha;

import java.util.Iterator;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        // PILHA
        System.out.println("-:-:-:PILHA:-:-:-");
        Pilha stack= new Pilha(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Pilha stack <10>: ");
        stack.printP();

        //Pop
        System.out.println();
        System.out.println("Retornado e Removido: "+ stack.pop());
        System.out.println("Retornado e Removido: "+ stack.pop());
        System.out.println("Retornado e Removido: "+ stack.pop());
        System.out.println();
        stack.printP();
        System.out.println();

        //isFull
        System.out.println();
        System.out.print(stack.isFull()? "Está cheia" : "Não está cheia");
        System.out.println();

        //Top
        System.out.println();
        System.out.println("Topo: "+ stack.top());
        System.out.println();

        //ToArray
        Integer[] array1= stack.toArray();
        for(int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+ " ");
        }

        System.out.println();
        System.out.println();

        //FILA
        System.out.println("-:-:-:FILA:-:-:-");
        System.out.println("Fila queue <10>: ");
        Fila queue= new Fila(10);
        for(int i = 0; i < 10; i++) {
            //Enqueue
            queue.enqueue(i);
        }
        queue.printF();

        //Dequeue
        System.out.println();
        System.out.println("Retornado e Removido: "+ queue.dequeue());
        System.out.println("Retornado e Removido: "+ queue.dequeue());
        System.out.println("Retornado e Removido: "+ queue.dequeue());
        System.out.println();
        queue.printF();
        System.out.println();

        //isFull
        System.out.println();
        System.out.print(queue.isFull()? "Está cheia" : "Não está cheia");
        System.out.println();

        //Peek
        System.out.println();
        System.out.println("Frente: "+ queue.peek());
        System.out.println();

        //ToArray
        Integer[] array2= queue.toArray();
        for(int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+ " ");
        }

    }
}