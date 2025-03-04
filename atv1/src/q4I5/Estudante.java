package q4I5;

public class Estudante extends Pessoa{
    String matricula;
    String curso;

    public Estudante(String nome, int idade, String cpf, String matricula, String curso) {
        super(nome, idade, cpf);
        this.matricula= matricula;
        this.curso= curso;
    }

    @Override
    public void dadosPessoa() {
        super.dadosPessoa();
        System.out.println("Matricula: "+ matricula +"\nCurso: "+ curso);
    }
}
