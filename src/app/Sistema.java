package app;

import java.util.Date;

import javax.xml.crypto.Data;

import modelo.Custo;
import modelo.Departamento;
import modelo.Empresa;
import modelo.Funcionario;

public class Sistema {
    Empresa empresa;

    public Sistema() {
        this.empresa = new Empresa();
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("compras");
        Departamento vendas = new Departamento("vendas");
        Departamento ti = new Departamento("TI");
        Departamento engenharia = new Departamento("engenharia");
    }

    //MANIPULACAO DOS FUNCIONARIOS

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
        if(funcionario.getLog())
            funcionario.getDepartamento().getCustos().add(custo);
        else
            System.out.println("Funcionário não está logado");
    }
    
    public void removerCusto(Departamento d) {
        Custo x = new Custo(0, null, new Date("01/01/50000"), null, d);
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
}
