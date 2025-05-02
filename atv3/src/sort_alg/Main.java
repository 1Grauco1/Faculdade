package sort_alg;

public class Main {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("Rafael", 19, "Verde"),
                new Pessoa("Tereza", 20, "Amarelo"),
                new Pessoa("Maira", 22, "Rosa"),
                new Pessoa("Myllena", 20, "Preto"),
                new Pessoa("Wellington", 21, "Laranja"),
                new Pessoa("Matheus", 23, "Branco"),
                new Pessoa("Agnes", 22, "Roxo"),
                new Pessoa("Beatriz", 25, "Azul"),
                new Pessoa("Andre", 20, "Vermelho"),
                new Pessoa("Nidlan", 24, "Marrom"),
                new Pessoa("Andre", 20, "Cinza")
        };

        Ordenacao ordenacao = new Ordenacao();
        //ordenacao.bubbleSort(pessoas);
        //ordenacao.selectionSort(pessoas);
        //ordenacao.insertionSort(pessoas);
        //ordenacao.mergeSort(pessoas);
        ordenacao.bucketSort(pessoas);
        ordenacao.checaVetorOrdenado(pessoas);
        for(Pessoa i : pessoas){
            System.out.println(i.toString());
        }
    }
}
