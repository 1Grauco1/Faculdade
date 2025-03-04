package q1;

import java.util.*;

public class Empresa {
    Scanner scan;
    TreeSet<Funcionario> funcionarios;

    public Empresa(Scanner scan) {
        this.scan = scan;
        this.funcionarios= new TreeSet<>(Comparator.comparingDouble(Funcionario::getSalario));
    }

    public void addFuncionario() {
        scan.nextLine();
        System.out.println("Digite o nome do funcionario: ");
        String nome = scan.nextLine();
        System.out.println("Digite o cargo: ");
        String cargo = scan.nextLine();
        System.out.println("Digite o Salario: ");
        double salario = scan.nextDouble();

        funcionarios.add(new Funcionario(nome, cargo, salario));
    }

    public void removeFuncionario() {
        for(Funcionario i : funcionarios){
            System.out.print(i.nome+ ", ");
        }
        scan.nextLine();
        System.out.println("Digite o nome do funcionario que deseja remover: ");
        String nome = scan.nextLine();
        funcionarios.removeIf(i -> i.nome.equalsIgnoreCase(nome));
    }

    public Funcionario findFuncionario() {
        scan.nextLine();
        System.out.println("Digite o nome do funcionario que deseja buscar: ");
        String nome = scan.nextLine();
        for (Funcionario i : funcionarios) {
            if (i.nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return null;
    }

    public void printInfo(){
        Funcionario f= findFuncionario();
        if (f != null) {
            System.out.println("Nome: " + f.nome +
                    "\nCargo: " + f.cargo +
                    "\nSalario: " + f.getSalario());
        } else {
            System.out.println("Funcionario não encontrado.");
        }
    }

    public void ordenarFuncionario() {
        for (Funcionario i : funcionarios) {
            System.out.println("Nome: "+ i.nome +" Cargo: "+ i.cargo +" Salario: "+ i.getSalario());
        }
    }

    public void aumentoSalario(){
        scan.nextLine();
        Funcionario f= findFuncionario();
        System.out.println("Digite o valor do aumento: ");
        double aumento= scan.nextDouble();
        if(f != null) {
            f.setSalario(f.getSalario() + aumento);
        }
    }

    public void folhaSalarial(){
        double folha= 0;
        for(Funcionario i : funcionarios){
            folha += i.getSalario();
        }
        System.out.print("Folha Salarial da Empresa: "+ folha);
    }
}