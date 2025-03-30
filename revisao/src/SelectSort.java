
public class SelectSort {
    public static void selectsort(int vet[],int tam){
        for(int i= 0; i < tam; i++){
            int menorValor= i;
            for(int j= i+1; j < tam; j++){
                if(vet[menorValor] > vet[j]){
                    menorValor= j;
                }
            }
            int aux= vet[menorValor];
            vet[menorValor]= vet[i];
            vet[i]= aux;
        }
    }
    public static void main(String[] args) {
        int vet[] = new int[]{1, 3, 6, 8, 7, 9, 5, 4, 10, 2};
        selectsort(vet,vet.length);
        BubleSort.printVet(vet,vet.length);
    }

}
