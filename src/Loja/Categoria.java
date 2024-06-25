package Loja;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private List<Produto> produtos;

    public Categoria(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public String toString() {
        return "Categoria [nome=" + nome + ", produtos=" + produtos + "]";
    }
}
