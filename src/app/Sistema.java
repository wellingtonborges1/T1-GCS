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
        empresa.getDepartamentos().add(new Departamento("RH"));
        empresa.getDepartamentos().add(new Departamento("compras"));
        empresa.getDepartamentos().add(new Departamento("vendas"));
        empresa.getDepartamentos().add(new Departamento("TI"));
        empresa.getDepartamentos().add(new Departamento("engenharia"));
    }

    public void executa() {
        int opcao;
        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    metodo1();
                    break;
                case 2:
                    metodo2();
                    break;
                case 3:
                    metodo3();
                    break;
                case 4:
                    metodo4();
                    break;
                case 5:
                    metodo5();
                    break;
                case 6:
                    metodo6();
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

    private void metodo1(){
        System.out.println("Informe a matrícula do funcionário para logar");
        int matricula = sc.nextInt();
        sc.nextLine();
        logar(matricula);
    }

    private void metodo2(){
        System.out.println("Informe a matrícula do funcionário");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o nome do funcionário");
        String nome = sc.nextLine();

        Departamento d;
        //repete se o departamento passado nao existir
        do {
            System.out.println("Informe o nome do departamento do funcionário");
            String nomeDepartamento = sc.nextLine();
            d = pesquisarDepartamento(nomeDepartamento);
        } while(d == null);

        adicionarFuncionario(new Funcionario(matricula, nome, d));
    }

    private void metodo3() {
        System.out.println("insira o ");
        adicionarCusto(null, null);
    }

    private void metodo4() {
        boolean valido;
        do {
            valido = true;
            System.out.println("--------------------------------------------");
            System.out.println("0- Voltar");
            System.out.println("1- Pesquisar custo por categoria");
            System.out.println("2- Pesquisar custo por descrição");
            System.out.println("3- Pesquisar custo por departamento ");
            System.out.println("4- Pesquisar custo por data");
            System.out.println("--------------------------------------------");
            ArrayList<Custo> custos;
            switch (sc.nextInt()) {
                case 0:
                    break;

                case 1:
                    System.out.println("Digite a categoria que deseja buscar: ");
                    custos = pesquisaCustoCategoria(sc.nextLine());
                    System.out.println(custos);
                    break;

                case 2:
                    System.out.println("Digite a descrição que deseja buscar: ");
                    custos = pesquisaCustoCategoria(sc.nextLine());
                    System.out.println(custos);
                    break;

                case 3:
                    System.out.println("Digite o nome do departamento que deseja buscar: ");
                    custos = pesquisaCustoCategoria(sc.nextLine());
                    System.out.println(custos);
                    break;

                case 4:
                    boolean valido2;
                    do{
                        valido2 = true;
                        System.out.println("0- Voltar");
                        System.out.println("1- Pesquisar por dia");
                        System.out.println("2- Pesquisar por mês");
                        System.out.println("3- Pesquisar por ano");
                        switch (sc.nextInt()) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("Digite o dia em dois digitos");
                                int dia = sc.nextInt();
                                System.out.println("Digite o mês dois digitos");
                                int mes = sc.nextInt();
                                System.out.println("Digite o ano em quatro digitos");
                                int ano = sc.nextInt();
                                Date data = new Date(dia, mes, ano);

                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opção inválida. Digite novamente.");
                                valido2 = false;
                        }
                    }while (!valido2);
                    break;

                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    valido = false;
                    break;
            }
        }while (!valido);
    }

    private void metodo5() {
        System.out.println("--------------------------------------------");
        System.out.println("Digite de qual departamento deseja excluir o custo:");
        System.out.println("1 - RH \n2 - Compras \n3 - Vendas \n4 - TI \n5 - Engenharia");
        System.out.println("--------------------------------------------");
        int opcao5= sc.nextInt();
        removerCusto(empresa.getDepartamentos().get(opcao5-1));
        todosCustos(empresa.getDepartamentos().get(opcao5-1));
    }

    private void metodo6() {
        //consultar painel
        System.out.println("--------------------------------------------");
        System.out.println("O que deseja consultar?");
        System.out.println("1 - Custos \n2 - Funcionários");
        System.out.println("--------------------------------------------");
        int consultas= sc.nextInt();
        switch(consultas) {
            case 1:
                System.out.println("--------------------------------------------");
                System.out.println("Digite qual departamento deseja consultar:");
                System.out.println("1 - RH \n2 - Compras \n3 - Vendas \n4 - TI \n5 - Engenharia");
                System.out.println("--------------------------------------------");
                int opcao6 = sc.nextInt();
                todosCustos(empresa.getDepartamentos().get(opcao6 - 1));
                break;
            case 2:
                todosFuncionarios();
                break;
        }
    }

    private void menu() {
        System.out.println("--------------------------------------------");
        System.out.println("1 - Escolher funcionário logado");
        System.out.println("2 - Adicionar funcionário");
        System.out.println("3 - Adicionar registro de custo");
        System.out.println("4 - Pesquisar registro de custos");
        System.out.println("5 - Excluir registro de custo mais recente");
        System.out.println("6 - Consultar painel de dados");
        System.out.println("0 - Sair");
        System.out.println("--------------------------------------------");
    }

    private void adicionarFuncionario(Funcionario funcionario){
        boolean funcExistente = false;

        for(Funcionario f : empresa.getFuncionarios()){
            if(f.getMatricula() == funcionario.getMatricula())
                System.out.println("Funcionário já existe na empresa");
                funcExistente = true;
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
        //verifica se a lista esta vazia
        if(empresa.getFuncionarios().isEmpty()) {
            System.out.println("Não existe nenhum funcionário na empresa.");
            return false;
        }
        if(f.getLog()) {
           System.out.println("Este Funcionario ja esta logado!");
           return true;
        } else {
            for (Funcionario funcionario : empresa.getFuncionarios()) {
                if(isLogged(funcionario))
                    funcionario.setLog(false);
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

    //MANIPULACAO DE DEPARTAMENTOS

    private Departamento pesquisarDepartamento(String nome) {
        for(Departamento d : empresa.getDepartamentos()) {
            if(d.getNome().equals(nome))
                return d;
        }
        System.out.println("Departamento inexistente. Tente novamente");
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
        Custo x = new Custo(0, null, new Date(50000, 01, 1), null, d);
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
            if(custo.getCategoria().equals(descricao))
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

    private ArrayList<Custo> pesquisaCustoDepartamento(String nome) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getDepartamento().getNome().equals(nome))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }
}
