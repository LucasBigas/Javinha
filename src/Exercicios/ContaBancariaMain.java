package Exercicios;

public class ContaBancariaMain {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria("10001-6","0001","John Wick",100,100);
        contaBancaria.imprimir();   
        contaBancaria.sacar(100);
        contaBancaria.sacar(100);
        contaBancaria.sacar(10);
        contaBancaria.depositar(1000);
        contaBancaria.sacar(-99);
        contaBancaria.depositar(-10);
    }
}
