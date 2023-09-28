package modelo;

public class Funcionario {

    private int matricula;
    private String nome;
    private Departamento departamento;
    private boolean estaLogado;

    public Funcionario(Integer matricula, String nome, Departamento departamento) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        estaLogado = false;
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

    public boolean getLog() {
        return estaLogado;
    }

    public boolean setLog(boolean valor) { 
        return this.estaLogado = valor;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", departamento=" + departamento.getNome() +
                '}';
    }
}
