package q2;

public class Reserva {
    String hospede;
    int quarto;
    String dataIni, dataFim;

    public Reserva(String hospede, int quarto, String dataIni, String dataFim) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
    }

    public void exibirDetalhes() {
        System.out.println("Hóspede: " + hospede);
        System.out.println("Quarto: " + quarto);
        System.out.println("Data de Início: " + dataIni);
        System.out.println("Data de Fim: " + dataFim);
        System.out.println("----------------------");
    }
}
