package HospitalUSU;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private boolean temConvenio;
    private List<Consulta> consultas;

    public Usuario(String nome, String email, String senha, boolean temConvenio) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.temConvenio = temConvenio;
        this.consultas = new ArrayList<>();
    }

    // Getters e setters

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isTemConvenio() {
        return temConvenio;
    }

    public void setTemConvenio(boolean temConvenio) {
        this.temConvenio = temConvenio;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void atualizarInformacoes(String novoNome, String novoEmail, String novaSenha, boolean novoConvenio) {
        this.nome = novoNome;
        this.email = novoEmail;
        this.senha = novaSenha;
        this.temConvenio = novoConvenio;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void listarConsultas() {
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println((i + 1) + ". " + consultas.get(i));
        }
    }

    public boolean autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }
}
