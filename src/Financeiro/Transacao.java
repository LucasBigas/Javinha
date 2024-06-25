package Financeiro;

import java.time.LocalDate;

public class Transacao {
    private static int contadorId = 0;
    private int id ;
    private double valor;
    private LocalDate data;
    private String descricao;
    private String categoria;
    private String tipo;

    public Transacao(double valor, LocalDate data, String descricao, String categoria, String tipo) {
        this.id = ++contadorId;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", valor=" + valor +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
