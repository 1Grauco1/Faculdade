package sort_alg;

public class Pessoa implements Comparable<Pessoa> {
    private int idade;
    private String nome;
    private String corFav;

    public Pessoa(String nome, int idade, String corFav) {
        this.idade = idade;
        this.nome = nome;
        this.corFav = corFav;
    }

    @Override
    public String toString() {
        return "sort_alg.Pessoa{" +
                "idade=" + idade +
                ", nome='" + nome + '\'' +
                ", corFav='" + corFav + '\'' +
                '}';
    }

    @Override
    public int compareTo(Pessoa outra) {
        if (this.getIdade() != outra.getIdade()) {
            return Integer.compare(this.getIdade(), outra.getIdade());
        }
        return this.nome.compareTo(outra.getNome());
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorFav() {
        return corFav;
    }
    public void setCorFav(String corFav) {
        this.corFav = corFav;
    }
}
