package q6;
import java.util.*;

public class Menu {
    Scanner scan;
    Biblioteca b;
    Usuario u;

    public Menu() {
        this.scan = new Scanner(System.in);
        this.b = new Biblioteca(scan);
        this.u = new Usuario("Carlos", 1);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\nMenu: \n1 - Alugar\n2 - Devolver\n3 - Sair");
            int op = scan.nextInt();
            scan.nextLine();

            switch (op) {
                case 1:
                    Livro livro = b.buscarLivro();
                    if (u.alugar(livro)) {
                        System.out.println("Livro alugado!");
                    } else {
                        System.out.println("Livro indisponível.");
                    }
                    break;

                case 2:
                    if (u.alugados.isEmpty()) {
                        System.out.println("Você não tem livros para devolver.");
                        break;
                    }
                    Livro livroA = b.buscarLivro();
                    u.devolver(livroA);
                    System.out.println("Livro Devolvido.");

                    break;

                case 3:
                    System.out.println("Saindo");
                    scan.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
