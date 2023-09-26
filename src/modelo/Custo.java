package modelo;

import java.util.Date;

public class Custo {

    private double valor;
    private String descricao;
    private Date data;
    private String categoria;
    private Departamento departamento;

    public Custo(double valor, String descricao, Date data, String categoria, Departamento departamento) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.departamento = departamento;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Custo{" +
                "valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", categoria='" + categoria + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
