package q2;

import java.util.Scanner;

public class Menu {
    Scanner scan;
    Hotel h;

    public Menu(){
        scan= new Scanner(System.in);
        h= new Hotel(scan);
    }

    int menu(){
        System.out.println("\n===== MENU =====");
        System.out.println("1. Adicionar reserva");
        System.out.println("2. Remover reserva");
        System.out.println("3. Buscar reserva por hóspede");
        System.out.println("4. Listar todas as reservas");
        System.out.println("5. Verificar se uma reserva existe");
        System.out.println("6. Exibir relatório de reservas");
        System.out.println("0. Sair");
        return scan.nextInt();
    }

    public void iniciar(){
        int op;
        do{
            op= menu();
            switch (op) {
                case 1 -> h.addReserva();
                case 2 -> h.removeReserva();
                case 3 -> h.searchReserva();
                case 4 -> h.listHospedes();
                case 5 -> h.verifyReserva();
                case 6 -> h.manageReservas();
                case 0 -> System.out.println("Saindo");
                default -> System.out.println("Opção inválida!");
            }
        }while(op != 0);
    }
}

