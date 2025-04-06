import java.util.*;
public class Ordenacao implements OrdenacaoIF {
    @Override
    public void bubbleSort(Pessoa[] pessoas) {
        for (int i = 0; i < pessoas.length; i++) {
            for (int j = i + 1; j < pessoas.length; j++) {
                if (pessoas[j].getIdade() < pessoas[i].getIdade()) {
                    Pessoa aux = pessoas[i];
                    pessoas[i] = pessoas[j];
                    pessoas[j] = aux;
                }
            }
        }
    }

    @Override
    public void selectionSort(Pessoa[] pessoas) {
        for (int i = 0; i < pessoas.length; i++) {
            int menor = i;
            for (int j = i + 1; j < pessoas.length; j++) {
                if (pessoas[j].getIdade() < pessoas[i].getIdade()) {
                    menor = j;
                }
            }
            Pessoa aux = pessoas[i];
            pessoas[i] = pessoas[menor];
            pessoas[menor] = aux;
        }
    }

    @Override
    public void insertionSort(Pessoa[] pessoas) {
        for (int i = 0; i < pessoas.length; i++) {
            Pessoa chave = pessoas[i];
            int j = i - 1;
            while (j > 0 && pessoas[j].getIdade() > chave.getIdade()) {
                pessoas[j + 1] = pessoas[j];
                j--;
            }
            pessoas[j + 1] = chave;
        }
    }

    @Override
    public void mergeSort(Pessoa[] pessoas) {
        if (pessoas.length == 1) return;
        int meio = pessoas.length / 2;

        Pessoa[] esq = new Pessoa[meio];
        Pessoa[] dir = new Pessoa[pessoas.length - meio];

        System.arraycopy(pessoas, 0, esq, 0, meio);
        System.arraycopy(pessoas, meio, dir, 0, pessoas.length - meio);

        mergeSort(esq);
        mergeSort(dir);

        int i = 0, j = 0, k = 0;
        while (i < esq.length && j < dir.length) {
            if (esq[i].getIdade() < dir[j].getIdade()) {
                pessoas[k++] = esq[i++];
            } else {
                pessoas[k++] = dir[j++];
            }
        }
        while (i < esq.length) {
            pessoas[k++] = esq[i++];
        }
        while (j < dir.length) {
            pessoas[k++] = dir[j++];
        }

    }

    @Override
    public void bucketSort(Pessoa[] pessoas) {
        double min = pessoas[0].getIdade(), max = pessoas[0].getIdade();
        for (Pessoa i : pessoas) {
            if (i.getIdade() < min) min = i.getIdade();
            if (i.getIdade() > max) max = i.getIdade();
        }
        int n = pessoas.length;

        List[] baldes = new List[n];
        for (int i = 0; i < n; i++) {
            baldes[i] = new ArrayList();
        }

        for (Pessoa i : pessoas) {
            int index = (int) ((i.getIdade() - min) / (max - min + 1) * (n - 1));
            baldes[index].add(i);
        }

        int k = 0;
        for (List<Pessoa> balde : baldes) {
            for (Pessoa i : balde) {
                pessoas[k++] = i;
            }
        }
    }
}



