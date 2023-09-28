package controle;

import modelo.Departamento;
import modelo.Empresa;
import modelo.Funcionario;

import java.util.Objects;

public class Sistema {
    Empresa empresa;

    public Sistema(Empresa empresa) {
        this.empresa = empresa;
        Departamento rh = new Departamento("RH");
        Departamento compras = new Departamento("compras");
        Departamento vendas = new Departamento("vendas");
        Departamento ti = new Departamento("TI");
        Departamento engenharia = new Departamento("engenharia");
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
}
