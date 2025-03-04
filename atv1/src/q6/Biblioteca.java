package q6;
import java.util.*;

public class Biblioteca {
    Scanner scan;
    ArrayList<Livro> livros = new ArrayList<>();

    public Biblioteca(Scanner scan) {
        this.scan = scan;
        livros.add(new Livro("Livro 1", "Manoel G", "1977"));
        livros.add(new Livro("Livro 2", "Leno B", "2002"));
    }

    public Livro buscarLivro() {
        System.out.println("Digite o título do livro: ");
        String tit = scan.nextLine();

        for (Livro i : livros) {
            if (i.titulo.equalsIgnoreCase(tit)) {
                return i;
            }
        }
        return null;
    }
}

