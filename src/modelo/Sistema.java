package modelo;

import java.util.Objects;

public class Sistema {
    Empresa empresa;

    public Sistema(Empresa empresa) {
        this.empresa = empresa;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        for(Funcionario f : empresa.getFuncionarios()){
            if(Objects.equals(f.getMatricula(), funcionario.getMatricula()))
                throw new IllegalArgumentException("Funcionário já existe na empresa");
        }
        empresa.getFuncionarios().add(funcionario);
        funcionario.getDepartamento().getFuncionarios().add(funcionario);
    }
}
