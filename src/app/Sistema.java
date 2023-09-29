package app;

import modelo.Custo;
import modelo.Departamento;
import modelo.Empresa;
import modelo.Funcionario;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
                    System.out.println("insira o ");
                    adicionarCusto(null, null);
                    break;
                case 4:
                    //pesquisar custo
                        System.out.println("""
                                -----------------
                                menu:
                                
                                1- pesquisa data
                                2- pesquisa descricao
                                3- pesquisa departamento
                                4- pesquisa categoria
                                5- fechar menu 
                                -----------------
                                """);
                        int op = sc.nextInt();

                        switch(op){

                            case 1:
                            int pesqData = pesquisaCustoData();
                            break;

                            case 2:
                                String pesqDesc = pesquisaCustoDescricao();
                                break;

                            case 3:
                                String pesqDepart = pesquisaCustoDepartamento();
                                break;

                            case 4:
                                String pesqCateg = pesquisaCustoCategoria();
                                break;


                            case 5:
                                System.out.println("menu fechado");
                                break;
                        }



                    break;
                case 5:
                    //excluir custo
                    System.out.println("--------------------------------------------");
                    System.out.println("Digite de qual departamento deseja excluir o custo:");
                    System.out.println("1 - RH \n2 - Compras \n3 - Vendas \n4 - TI \n5 - Engenharia");
                    System.out.println("--------------------------------------------");
                    int opcao5= sc.nextInt();
                    removerCusto(empresa.getDepartamentos().get(opcao5-1));
                    todosCustos(empresa.getDepartamentos().get(opcao5-1));
                    break;
                case 6:
                     //consultar painel
                    System.out.println("--------------------------------------------");
                    System.out.println("O que deseja consultar?");
                    System.out.println("1 - Custos \n2 - Funcionários");
                    System.out.println("--------------------------------------------");
                    int consultas= sc.nextInt();
                    switch(consultas){
                        case 1:
                        System.out.println("--------------------------------------------");
                        System.out.println("Digite qual departamento deseja consultar:");
                        System.out.println("1 - RH \n2 - Compras \n3 - Vendas \n4 - TI \n5 - Engenharia");
                        System.out.println("--------------------------------------------");
                        int opcao6= sc.nextInt();
                        todosCustos(empresa.getDepartamentos().get(opcao6-1));
                        break;
                        case 2:
                        todosFuncionarios();
                        break;
                    }
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
            if(f.getMatricula() == funcionario.getMatricula())
                System.out.println("Funcionário já existe na empresa");
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

    //MANIPULACAO DOS CUSTOS

    public void adicionarCusto(Funcionario funcionario, Custo custo) {
        if(funcionario.getLog()) {
            funcionario.getDepartamento().getCustos().add(custo);
            empresa.getCustosTotais().add(custo);
        }
        else
            System.out.println("Funcionário não está logado");
    }

    public void removerCusto(Departamento d) {
        Custo x = new Custo(0, null, new Date(50000, 01, 1), null, d);
        for (Custo custo : d.getCustos()) {
            if(custo.getData().compareTo(x.getData()) <0) {
                x=custo;
            }
        }
        d.getCustos().remove(x);
    }

    public void todosCustos(Departamento d) {
        for (Custo custo : d.getCustos()) {
            System.out.println(custo.toString());
        }
    }
    public <T> ArrayList<Custo> pesquisaCusto(T elemento) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getDescricao().equals(descricao) )
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    public ArrayList<Custo> pesquisaCustoCategoria(String categoria) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getCategoria().equals(categoria))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    public ArrayList<Custo> pesquisaCustoData(Date data) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getData().equals(data))
                custos.add(custo);
        }
        custos.sort(Comparator.comparing(Custo::getData));
        return custos;
    }

    public ArrayList<Custo> pesquisaCustoDepartamento(Departamento departamento) {
        ArrayList<Custo> custos = new ArrayList<>();
        for(Custo custo : empresa.getCustosTotais()){
            if(custo.getDepartamento().equals(departamento))
                custos.add(custo);
        }
        return custos;
    }

    public <T> ArrayList<Custo> pesquisaCusto(T elemento) {
        ArrayList<Custo> listas = new ArrayList();
        if(elemento instanceof String) {
            for (Custo custo : empresa.getCustosTotais()) {
                if(custo.getCategoria().equals(elemento) || custo.getDescricao().equals(elemento)) {
                    listas.add(custo);
                }
            }
        } else if (elemento instanceof Date) {

        } else if(elemento instanceof Departamento) {

        }
        return null;
    }
}

