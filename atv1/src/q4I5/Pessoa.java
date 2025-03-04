package q4I5;

public abstract class Pessoa {
    String nome;
    int idade;
    String cpf;

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void dadosPessoa(){
        System.out.println("Nome: "+ nome);
        System.out.println("Idade: "+ idade);
        System.out.println("CPF: "+ cpf);
    }
}
