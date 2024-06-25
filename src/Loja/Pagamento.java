package Loja;

public class Pagamento {
    public static boolean pagarComBoleto(double valor) {
        // Implementação simulada de pagamento com boleto
        System.out.println("Pagamento de R$" + valor + " realizado com boleto.");
        return true; // Sucesso
    }

    public static boolean pagarComPIX(double valor) {
        // Implementação simulada de pagamento com PIX
        System.out.println("Pagamento de R$" + valor + " realizado com PIX.");
        return true; // Sucesso
    }

    public static boolean pagarComCartao(double valor, int parcelas) {
        // Implementação simulada de pagamento com cartão
        System.out.println("Pagamento de R$" + valor + " realizado com cartão em " + parcelas + " parcelas.");
        return true; // Sucesso
    }
}
