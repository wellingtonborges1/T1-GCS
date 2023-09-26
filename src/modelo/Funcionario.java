package modelo;

public class Funcionario {

    private int matricula;
    private String nome;
    private Departamento departamento;

    public Funcionario(Integer matricula, String nome, Departamento departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
