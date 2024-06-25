package HospitalUSU;

import java.util.*;

import java.util.*;

import java.util.*;

public class SistemaHospitalar {
    private List<Usuario> usuarios;
    private Scanner scanner;

    public SistemaHospitalar() {
        usuarios = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void menuPrincipal() {
        int opcao = 0;
        while (opcao != 3) {
            System.out.println("1. Login");
            System.out.println("2. Cadastrar");
            System.out.println("3. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void login() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.autenticar(email, senha)) {
                menuUsuario(usuario);
                return;
            }
        }
        System.out.println("Email ou senha incorretos.");
    }

    private void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Tem convênio? (true/false): ");
        boolean temConvenio = scanner.nextBoolean();
        scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, senha, temConvenio);
        usuarios.add(usuario);
        System.out.println("Cadastro realizado com sucesso!");
    }

    private void menuUsuario(Usuario usuario) {
        int opcao = 0;
        while (opcao != 5) {
            System.out.println("1. Marcar consulta");
            System.out.println("2. Acessar consultas");
            System.out.println("3. Pagar consulta");
            System.out.println("4. Atualizar informações");
            System.out.println("5. Logout");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    marcarConsulta(usuario);
                    break;
                case 2:
                    usuario.listarConsultas();
                    break;
                case 3:
                    pagarConsulta(usuario);
                    break;
                case 4:
                    atualizarInformacoes(usuario);
                    break;
                case 5:
                    System.out.println("Logout realizado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void marcarConsulta(Usuario usuario) {
        System.out.print("Tipo de consulta: ");
        String tipo = scanner.nextLine();
        System.out.print("Data: ");
        String data = scanner.nextLine();
        System.out.print("Médico: ");
        String medico = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Consulta consulta = new Consulta(tipo, data, medico, valor);
        usuario.adicionarConsulta(consulta);
        System.out.println("Consulta marcada com sucesso!");
    }

    private void pagarConsulta(Usuario usuario) {
        usuario.listarConsultas();
        System.out.print("Escolha o número da consulta para pagar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > usuario.getConsultas().size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Consulta consulta = usuario.getConsultas().get(indice - 1);

        double valor = consulta.calcularValor(usuario.isTemConvenio());
        System.out.println("Valor a ser pago: R$ " + valor);
        // Implementação do pagamento...
        System.out.println("Pagamento realizado com sucesso!");
    }

    private void atualizarInformacoes(Usuario usuario) {
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo email: ");
        String novoEmail = scanner.nextLine();
        System.out.print("Nova senha: ");
        String novaSenha = scanner.nextLine();
        System.out.print("Novo convênio? (true/false): ");
        boolean novoConvenio = scanner.nextBoolean();
        scanner.nextLine();

        usuario.atualizarInformacoes(novoNome, novoEmail, novaSenha, novoConvenio);
        System.out.println("Informações atualizadas com sucesso!");
    }

    public static void main(String[] args) {
        SistemaHospitalar sistema = new SistemaHospitalar();
        sistema.menuPrincipal();
    }
}

