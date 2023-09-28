package modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    
    private List<Funcionario> funcionarios;
    private List<Departamento> departamentos;
    private List<Custo> custosTotais;

    public Empresa(){
        this.funcionarios = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.custosTotais = new ArrayList<>();
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public List<Custo> getListaCustos() {
        return custosTotais;
    }
}
