package Exercicios;

public class ContaBancaria {
    private String numero;
    private String agencia;
    private String titular;
    private double saldo;
    private double limite;

    public ContaBancaria(String numero, String agencia, String titular, double saldo, double limite) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
        this.limite = limite;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void depositar(double valor){
        System.out.println("-----------------------------");
        System.out.println("  OPERAÇÃO DE DEPÓSITO");
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println("Valor do depósito: R$"+valor);
        if(valor < 0){
            System.out.println("Valor inválido para depósito.");
            return;
        }
        saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
        System.out.println("Novo Saldo: R$"+saldo);
        System.out.println("-----------------------------");
    }
    public void sacar(double valor){
        System.out.println("-----------------------------");
        System.out.println("  OPERAÇÃO DE SAQUE");
        System.out.println("-----------------------------");
        System.out.println("Saldo atual: R$"+saldo);
        System.out.println("Valor do saque: R$"+valor);
        if(valor < 0){
            System.out.println("Valor inválido para saque.");
            return;
        }
        if((saldo - valor) < limite * -1){
            System.out.println("Saldo insuficiente na conta.");
            return;
        }
        saldo -= valor;
        System.out.println("Saque realizado com sucesso.");
        System.out.println("Novo Saldo: R$"+saldo);
        System.out.println("-----------------------------");
    }

    public void imprimir(){
        System.out.println("=====================");
        System.out.println(" Conta bancária");
        System.out.println("=====================");
        System.out.println("Agência: "+numero);
        System.out.println("Número: "+agencia);
        System.out.println("Titular: "+titular);
        System.out.println("Limite: R$"+limite);
        System.out.println("Saldo: R$"+saldo);
        System.out.println("=====================");
    }
}
