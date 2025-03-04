package q6;
import java.util.*;

public class Usuario {
    String nome;
    int id;
    ArrayList<Livro> alugados = new ArrayList<>();

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public boolean alugar(Livro livro) {
        if (livro.disponivel) {
            alugados.add(livro);
            livro.disponivel = false;
            return true;
        }
        return false;
    }

    public void devolver(Livro livro) {
        if (alugados.remove(livro)) {
            livro.disponivel = true;
        }
    }
}

