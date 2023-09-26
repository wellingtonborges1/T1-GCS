package modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Funcionario> funcionarios;
    private List<Departamento> departamentos;

    public Empresa(){
        this.funcionarios = new ArrayList<>();
        this.departamentos = new ArrayList<>();
    }
}
