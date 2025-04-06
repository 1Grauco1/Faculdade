public interface OrdenacaoIF {
        default boolean checaVetorOrdenado(Pessoa[] pessoas) {
            for (int i = 1; i < pessoas.length; i++) {
                if (pessoas[i - 1].getIdade() > pessoas[i].getIdade()) {
                    return false;
                } else if (pessoas[i - 1].getIdade() == pessoas[i].getIdade()) {
                    if (pessoas[i - 1].getNome().compareTo(pessoas[i].getNome()) > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public void bubbleSort(Pessoa[] pessoas);
        public void selectionSort(Pessoa[] pessoas);
        public void insertionSort(Pessoa[] pessoas);
        public void mergeSort(Pessoa[] pessoas);
        public void bucketSort(Pessoa[] pessoas);
}

