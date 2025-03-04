package q2;

import java.util.*;

public class Hotel {
    Scanner scan;
    HashMap<String, Reserva> reservas;

    public Hotel(Scanner scan) {
        this.scan= scan;
        this.reservas = new HashMap<>();
    }

    public void addReserva(){
        scan.nextLine();
        System.out.println("Digite o nome hospede: ");
        String nome= scan.nextLine();
        System.out.println("Digite o quarto: ");
        int quarto= scan.nextInt();
        scan.nextLine();
        System.out.println("Digite a data da reserva: ");
        String dataIni= scan.nextLine();
        System.out.println("Digite o data final da reserva: ");
        String dataFim= scan.nextLine();

        reservas.put(nome, new Reserva(nome, quarto, dataIni, dataFim));
        System.out.println("Reserva Adicionada;");
    }

    public void removeReserva(){
        scan.nextLine();
        System.out.println("Digite o nome hospede: ");
        String nome= scan.nextLine();
        reservas.remove(nome);
        System.out.println("Reserva removida;");
    }

    public void searchReserva(){
        scan.nextLine();
        System.out.println("Digite o nome hospede: ");
        String nome= scan.nextLine();
        reservas.get(nome).exibirDetalhes();
    }

    public void listHospedes(){
        System.out.println("TODAS AS RESERVAS");
        for(Map.Entry<String, Reserva> i : reservas.entrySet()){
            System.out.println("Reserva de "+ i.getKey() +":");
            i.getValue().exibirDetalhes();
        }
    }

    public void verifyReserva(){
        scan.nextLine();
        System.out.println("Digite o nome hospede: ");
        String nome= scan.nextLine();
        if(reservas.containsKey(nome)){
            reservas.get(nome).exibirDetalhes();
        }
        System.out.println("Reserva não existe");
    }

    public void manageReservas(){
        System.out.println("Total de reservas: "+ reservas.size());
        System.out.println("Total de quartos: ");
        for(Reserva i : reservas.values()){
            System.out.println("- Quarto "+ i.quarto +", Hospede: "+ i.hospede);
        }
    }

}
