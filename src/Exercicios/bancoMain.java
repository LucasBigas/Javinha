package Exercicios;

public class bancoMain {
    public static void main(String[] args) {
        banco contaBancaria = new banco();
        contaBancaria.setNome("Lucas");
        contaBancaria.setAgencia("Banco Brasi");
        contaBancaria.setNumero(356876);
        contaBancaria.setLimite(100.00);
        contaBancaria.setSaldoatual(1245.00);
        contaBancaria.setSaque(300.00);
        contaBancaria.setDeposito(280.00);
        System.out.println(contaBancaria.consultaSaldo());
        System.out.println(contaBancaria.saque());
        System.out.println(contaBancaria.deposito());

    }
}
