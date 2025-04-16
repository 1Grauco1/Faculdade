public class Main {

    //OBS tem um NO invisivel, a lista está indo de 0 a 8;
    // mas existe um nó a mais q está "NULL";


    public static void main(String[] args) {
        LinkedList list= new LinkedList();

        for(int i= 0; i < 10; i++){
            list.insert(i+1);
        }

        No n= list.search(5);
        System.out.println(n.getDado());

        System.out.println();

        list.printL();
        int tam= list.size();
        System.out.println("\n"+ tam);

        System.out.println();

        list.remove(3);
        list.remove(6);
        list.printL();

        System.out.println();

        list.removeInicio();
        list.removeFinal();
        list.printL();

        System.out.println();

        No[] array= list.toArray();

        for(No i : array){
            System.out.print("["+ i.getDado() +"] ");
        }

        System.out.println();


    }
}