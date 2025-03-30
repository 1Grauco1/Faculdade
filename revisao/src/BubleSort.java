public class BubleSort {

    public static void bublesort(int[] vet){
        for(int i= 0; i < vet.length; i++){
            for(int j= i+1; j < vet.length; j++){
                if(vet[i] > vet[j]){
                    int aux= vet[i];
                    vet[i]= vet[j];


                }
            }
        }
    }

    public static void printVet(int vet[],int tam){
        for (int i=0;i<tam;i++){
            System.out.println(vet[i]);
        }
    }

    public static void main(String[] args) {
        int[] vet= new int[10];
        bublesort(vet);
        printVet(vet,vet.length);
    }
}
