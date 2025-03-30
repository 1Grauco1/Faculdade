import java.util.*;

public class BucketSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        ArrayList<Integer>[] buckets = new ArrayList[n];

        // Inicializa os baldes
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribui os elementos nos baldes
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Ordena cada balde
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatena os baldes
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }


    public static void main(String[] args) {
        int vet[]= new int[10];

        sort(vet);
        BubleSort.printVet(vet,vet.length);
    }
}
