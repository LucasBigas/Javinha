package Financeiro;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class SistemaFinanceiro {
    private ControleFinanceiro controleFinanceiro;
    private Scanner scanner;

    public SistemaFinanceiro() {
        this.controleFinanceiro = new ControleFinanceiro();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Controle Financeiro Pessoal");
        System.out.println("1. Registrar Receita");
        System.out.println("2. Registrar Despesa");
        System.out.println("3. Visualizar Balanço Mensal");
        System.out.println("4. Listar Transações por Categoria");
        System.out.println("5. Sair");
    }

    public void lerEntradaUsuario() {
        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            processarOpcao(opcao);

            if (opcao == 5) {
                continuar = false;
            }
        }
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                registrarTransacao("RECEITA");
                break;
            case 2:
                registrarTransacao("DESPESA");
                break;
            case 3:
                visualizarBalancoMensal();
                break;
            case 4:
                listarTransacoesPorCategoria();
                break;
            case 5:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void registrarTransacao(String tipo) {
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Digite a data (dd/MM/yyyy): ");
        String dataString = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Digite a descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        Transacao transacao = new Transacao(valor, data, descricao, categoria, tipo);
        controleFinanceiro.adicionarTransacao(transacao);
        System.out.println(tipo + " registrada com sucesso.");
    }

    private void visualizarBalancoMensal() {
        System.out.print("Digite o mês (1-12): ");
        int mes = scanner.nextInt();

        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();

        double balanco = controleFinanceiro.obterBalancoMensal(mes, ano);
        System.out.println("Balanço do mês " + mes + "/" + ano + ": " + balanco);
    }

    private void listarTransacoesPorCategoria() {
        System.out.print("Digite a categoria: ");
        String categoria = scanner.nextLine();

        List<Transacao> transacoes = controleFinanceiro.listarTransacoesPorCategoria(categoria);

        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada para a categoria " + categoria);
        } else {
            System.out.println("Transações da categoria " + categoria + ":");
            for (Transacao transacao : transacoes) {
                System.out.println(transacao);
            }
        }
    }

    public static void main(String[] args) {
        SistemaFinanceiro sistemaFinanceiro = new SistemaFinanceiro();
        sistemaFinanceiro.lerEntradaUsuario();
    }
}
