package Loja;

public class Usuario {
    private String nome;
    private String email;
    private Carrinho carrinho;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.carrinho = new Carrinho();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + ", carrinho=" + carrinho + "]";
    }
}
