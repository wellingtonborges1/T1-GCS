package app;

import modelo.Custo;
import modelo.Departamento;
import modelo.Empresa;
import modelo.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Sistema {
    Empresa empresa;
    Scanner sc;

    public Sistema() {
        this.empresa = new Empresa();
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

            int matricula;
            switch (opcao) {
                case 1:
                    System.out.println("Informe a matrícula do funcionário para logar");
                    matricula = sc.nextInt();
                    sc.nextLine();
                    logar(matricula);
                    break;
                case 2:
                    System.out.println("Informe a matrícula do funcionário");
                    matricula = sc.nextInt();
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
                    //lucas blaco
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

    private void adicionarFuncionario(Funcionario funcionario){
        boolean funcExistente = false;

        for(Funcionario f : empresa.getFuncionarios()){
            if(f.getMatricula() == funcionario.getMatricula()){
                System.out.println("Funcionário já existe na empresa");
                funcExistente = true;
            }
        }
        if(!funcExistente){
            empresa.getFuncionarios().add(funcionario);
            funcionario.getDepartamento().getFuncionarios().add(funcionario);
            System.out.println("Funcionário adicionado com sucesso");
        }
    }

    private void todosFuncionarios() {
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            System.out.println(funcionario.toString());
        }
    }

    private boolean isLogged(Funcionario f) {
        if(f.getLog()) {
            return true;
        } else {
            return false;
        }
    }

    private Funcionario funcionarioLogado() {
        Funcionario f = null;
        for (Funcionario funcionario : empresa.getFuncionarios()) {
            if(funcionario.getLog()) {
                f = funcionario;
            }
        }
        return f;
    }

    private boolean logar(int matricula) {
        Funcionario f = pesquisarFuncionario(matricula);

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

    private Funcionario pesquisarFuncionario(int matricula) {
        for(Funcionario f : empresa.getFuncionarios()) {
            if(f.getMatricula() == matricula)
                return f;
        }
        return null;
    }

    //MANIPULACAO DOS CUSTOS

    private void adicionarCusto(Funcionario funcionario, Custo custo) {
        if(funcionario.getLog()) {
            funcionario.getDepartamento().getCustos().add(custo);
            empresa.getCustosTotais().add(custo);
        }
        else
            System.out.println("Funcionário não está logado");
    }

    private void removerCusto(Departamento d) {
        Custo x = new Custo(0, null, new Date("01/01/50000"), null, d);
        for (Custo custo : d.getCustos()) {
            if(custo.getData().compareTo(x.getData()) <0) {
                x=custo;
            }
        }
        d.getCustos().remove(x);
    }

    private void todosCustos(Departamento d) {
        for (Custo custo : d.getCustos()) {
            System.out.println(custo.toString());
        }
    }
    private ArrayList<Custo> pesquisaCustoDescricao(String descricao) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getDescricao().equals(descricao) )
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    private ArrayList<Custo> pesquisaCustoCategoria(String categoria) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getCategoria().equals(categoria))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    private ArrayList<Custo> pesquisaCustoData(Date data) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getData().equals(data))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    private ArrayList<Custo> pesquisaCustoDepartamento(Departamento departamento) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getDepartamento().equals(departamento))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }
}

