package fila_pilha;

public class NoFila {
    NoFila proxNo;
    private Integer dado;

    public NoFila(Integer dado) {
        proxNo = null;
        this.dado = dado;

    }

    public Integer getDado() {
        return dado;
    }
}
