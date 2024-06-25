package Exercicios;

public class banco {
    private double saldoatual;
    private String agencia;
    private int numero;
    private String nome;
    private Double limite;
    private double saque;
    private double deposito;
    

    public double getSaque() {
        return saque;
    }


    public void setSaque(double saque) {
        this.saque = saque;
    }


    public double getDeposito() {
        return deposito;
    }


    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }


    public double consultaSaldo(){
        return saldoatual;
    }

    public double saque(){
        return saldoatual = saldoatual - saque;
    }

    public double deposito(){
        return saldoatual = saldoatual + deposito;
    }


    public double getSaldoatual() {
        return saldoatual;
    }
    public void setSaldoatual(double saldoatual) {
        this.saldoatual = saldoatual;
    }
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getLimite() {
        return limite;
    }
    public void setLimite(Double limite) {
        this.limite = limite;
    }

    
}
