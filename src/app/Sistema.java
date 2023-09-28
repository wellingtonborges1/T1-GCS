package app;

import modelo.Departamento;
import modelo.Empresa;
import modelo.Funcionario;

import java.util.Objects;
import java.util.Scanner;

public class Sistema {
    Empresa empresa;
    Scanner sc;

    public Sistema(Empresa empresa) {
        this.empresa = empresa;
        sc = new Scanner(System.in);
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("compras");
        Departamento vendas = new Departamento("vendas");
        Departamento ti = new Departamento("TI");
        Departamento engenharia = new Departamento("engenharia");
    }

    public void executa() {
        int opcao;

        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    funcionarioLogado();
                    break;
                case 2:
                    System.out.println("Informe a matrícula do funcionário");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe o nome do funcionário");
                    String nome = sc.nextLine();
                    System.out.println("Informe o departamento do funcionário");
                    //pesquisar departamento
                    //adicionar funcionário
                    break;
                case 3:
                    //adicionar custo
                    break;
                case 4:
                    //pesquisar custo
                    break;
                case 5:
                    //excluir custo
                    break;
                case 6:
                    //consultar painel
                    break;
                case 0:
                    //encerrando
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while(opcao != 0);
    }

    private void menu() {
        System.out.println("--------------------------------------------");
        System.out.println("1 - Escolher funcionário logado");
        System.out.println("2 - Adicionar funcionário");
        System.out.println("3 - Adicionar registro de custo");
        System.out.println("4 - Pesquisar registro de custo");
        System.out.println("5 - Excluir registro de custo mais recente");
        System.out.println("6 - Consultar painel de dados");
        System.out.println("0 - Sair");
        System.out.println("--------------------------------------------");
    }

    public void adicionarFuncionario(Funcionario funcionario){
        for(Funcionario f : empresa.getFuncionarios()){
            if(Objects.equals(f.getMatricula(), funcionario.getMatricula()))
                throw new IllegalArgumentException("Funcionário já existe na empresa");
        }
        empresa.getFuncionarios().add(funcionario);
        funcionario.getDepartamento().getFuncionarios().add(funcionario);
    }

    public void todosFuncionarios() {
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            System.out.println(funcionario.toString());
        }
    }

    public boolean isLogged(Funcionario f) {
        if(f.getLog()) {
            return true;
        } else {
            return false;
        }
    }    

    public Funcionario funcionarioLogado() {
        Funcionario f = null;
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            if(funcionario.getLog()) {
                f = funcionario;
            }
        }
        return f;
    }
    
    public boolean logar(Funcionario f) {
        if(f.getLog()) {
           System.out.println("Este Funcionario ja esta logado!");
           return true;
        } else {
            for (Funcionario funcionario : empresa.getFuncionarios()) {
                if(isLogged(funcionario)) {
                    funcionario.setLog(false);
                }
            }
        }
        System.out.println("Funcionario logado com sucesso!");
        f.setLog(true);
        return true;
        }
    
}
