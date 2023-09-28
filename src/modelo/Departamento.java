package modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private String nome;
    private List<Funcionario> funcionarios;
    private List<Custo> custos;

    public Departamento(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
        this.custos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Custo> getCustos() {
        return custos;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
