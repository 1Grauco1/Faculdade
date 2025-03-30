public class InserSort {
    public static void insertsort(int vet[],int tam){
        for(int i= 1; i < vet.length; i++){
            int chave= vet[i];
            int j= i-1;
            while(j >= 0 && vet[j] > chave){
                vet[j+1]= vet[j];
                j--;
            }
            vet[j+1]= chave;
        }
    }
    public static void main(String[] args) {
        int vet[] = new int[]{1, 3, 6, 8, 7, 9, 5, 4, 10, 2};
        insertsort(vet,vet.length);
        BubleSort.printVet(vet,vet.length);
    }
}
