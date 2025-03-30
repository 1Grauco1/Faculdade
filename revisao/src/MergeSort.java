public class MergeSort {

    public static void sort(int[] vet) {
        if(vet.length <= 1) return;
        int mid= vet.length/ 2;

        int[] left= new int[mid];
        int[] right= new int[vet.length - mid];

        System.arraycopy(vet, 0, left, 0, mid);
        System.arraycopy(vet, mid, right, 0, vet.length - mid);

        sort(left);
        sort(right);

        merge(vet, left, right);
    }


    private static void merge(int[] result, int[] left, int[] right) {
        int i= 0, j= 0, k= 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                result[k++]= left[i++];
            }
            else{
                result[k++]= right[j++];
            }
        }

        while(i < left.length){
            result[k++]= left[i++];
        }
        while(j < right.length){
            result[k++]= right[j++];
        }
    }

    public static void main(String[] args) {
        int[] vet=new int[]{1, 3, 6, 8, 7, 9, 5, 4, 10, 2};
        sort(vet);
        BubleSort.printVet(vet,vet.length);
    }
}
