package q6;

public class Livro {
    String titulo;
    String autor;
    String anoPublicado;
    boolean disponivel;

    public Livro(String titulo, String autor, String anoPublicado) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicado = anoPublicado;
        this.disponivel= true;
    }
}
