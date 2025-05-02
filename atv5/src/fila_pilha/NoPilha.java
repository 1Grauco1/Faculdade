package fila_pilha;

public class NoPilha {
	NoPilha proxNo;
    private Integer dado;

    public NoPilha() {
        this.proxNo = null;
        dado = null;
    }

    public NoPilha(Integer elemento) {
        this.proxNo= null;
        this.dado = elemento;
    }

    public Integer getDado() {
        return dado;
    }

}
