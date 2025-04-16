public class No {
    private Integer dado;
    public No antNo;
    public No proxNo;

    public No() {
        this.dado = null;
        this.antNo = null;
        this.proxNo = null;
    }

    public No(Integer dado) {
        this.dado = dado;
        this.antNo = null;
        this.proxNo = null;
    }

    public Integer getDado() {
        return dado;
    }
}