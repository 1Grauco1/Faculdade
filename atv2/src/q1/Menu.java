package q1;
import java.util.*;

public class Menu{
    Empresa e;
    Scanner scan;
    Menu(){
        scan= new Scanner(System.in);
        e= new Empresa(scan);
    }

    public int menu(){
        System.out.println("Menu: ");
        System.out.println("1- Adicionar funcionario");
        System.out.println("2- Remover Funcionario");
        System.out.println("3- Encontrar Funcionario");
        System.out.println("4- Listar Funcionarios");
        System.out.println("5- Aumentar Salario");
        System.out.println("6- Folha Salarial");
        System.out.println("0- Sair");
        return scan.nextInt();
    }

    public void iniciar() {

        int op;
        do {
            op = menu();
            switch (op) {
                case 1 -> e.addFuncionario();
                case 2 -> e.removeFuncionario();
                case 3 -> e.printInfo();
                case 4 -> e.ordenarFuncionario();
                case 5 -> e.aumentoSalario();
                case 6 -> e.folhaSalarial();
                case 0 -> System.out.println("Saindo");
                default -> System.out.println("Opção inválida!");
            }
        } while (op != 0);

    }
}
