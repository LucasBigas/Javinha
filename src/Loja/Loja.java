package Loja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
    private List<Categoria> categorias;
    private List<Usuario> usuarios;

    public Loja() {
        this.categorias = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void listarCategorias() {
        System.out.println("Categorias disponíveis:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i).getNome());
        }
    }

    public void listarProdutosCategoria(int indiceCategoria) {
        if (indiceCategoria >= 0 && indiceCategoria < categorias.size()) {
            Categoria categoria = categorias.get(indiceCategoria);
            List<Produto> produtos = categoria.getProdutos();
            System.out.println("Produtos da categoria " + categoria.getNome() + ":");
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i + 1) + ". " + produto.getNome() + " - R$" + produto.getPreco());
            }
        } else {
            System.out.println("Categoria inválida.");
        }
    }

    public void adicionarProdutoAoCarrinho(int indiceUsuario, int indiceCategoria, int indiceProduto) {
        if (indiceUsuario >= 0 && indiceUsuario < usuarios.size() &&
                indiceCategoria >= 0 && indiceCategoria < categorias.size()) {
            Usuario usuario = usuarios.get(indiceUsuario);
            Categoria categoria = categorias.get(indiceCategoria);
            List<Produto> produtos = categoria.getProdutos();
            if (indiceProduto >= 0 && indiceProduto < produtos.size()) {
                Produto produto = produtos.get(indiceProduto);
                usuario.getCarrinho().adicionarProduto(produto);
                System.out.println("Produto adicionado ao carrinho.");
            } else {
                System.out.println("Produto inválido.");
            }
        } else {
            System.out.println("Usuário ou categoria inválida.");
        }
    }

    public void finalizarCompra(int indiceUsuario, String metodoPagamento) {
        if (indiceUsuario >= 0 && indiceUsuario < usuarios.size()) {
            Usuario usuario = usuarios.get(indiceUsuario);
            double totalCompra = usuario.getCarrinho().calcularTotal();
            System.out.println("Total da compra: R$" + totalCompra);

            boolean pagamentoEfetuado = false;
            switch (metodoPagamento.toLowerCase()) {
                case "boleto":
                    pagamentoEfetuado = Pagamento.pagarComBoleto(totalCompra);
                    break;
                case "pix":
                    pagamentoEfetuado = Pagamento.pagarComPIX(totalCompra);
                    break;
                case "cartao":
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Digite o número de parcelas: ");
                    int parcelas = scanner.nextInt();
                    pagamentoEfetuado = Pagamento.pagarComCartao(totalCompra, parcelas);
                    scanner.close();
                    break;
                default:
                    System.out.println("Método de pagamento inválido.");
                    break;
            }

            if (pagamentoEfetuado) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Produtos comprados:");
                for (Produto produto : usuario.getCarrinho().getProdutos()) {
                    System.out.println("- " + produto.getNome() + " - R$" + produto.getPreco());
                }
            } else {
                System.out.println("Erro ao processar pagamento. Tente novamente.");
            }
        } else {
            System.out.println("Usuário inválido.");
        }
    }

    public static void main(String[] args) {
        Loja loja = new Loja();

        Categoria camisetas = new Categoria("Camisetas");
        camisetas.adicionarProduto(new Produto("Camiseta Nike", "Camiseta esportiva", 49.90, "Camisetas"));
        camisetas.adicionarProduto(new Produto("Camiseta Adidas", "Camiseta casual", 59.90, "Camisetas"));

        Categoria calcas = new Categoria("Calças");
        calcas.adicionarProduto(new Produto("Calça Jeans", "Calça jeans azul", 89.90, "Calças"));
        calcas.adicionarProduto(new Produto("Calça Moletom", "Calça moletom cinza", 79.90, "Calças"));

        loja.adicionarCategoria(camisetas);
        loja.adicionarCategoria(calcas);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à Loja de Roupas!");

        // Simulação de interação via console
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String emailUsuario = scanner.nextLine();

        Usuario usuario = new Usuario(nomeUsuario, emailUsuario);
        loja.adicionarUsuario(usuario);

        loja.listarCategorias();

        System.out.print("Digite o número da categoria desejada: ");
        int indiceCategoria = scanner.nextInt() - 1;

        loja.listarProdutosCategoria(indiceCategoria);

        System.out.print("Digite o número do produto desejado: ");
        int indiceProduto = scanner.nextInt() - 1;

        loja.adicionarProdutoAoCarrinho(0, indiceCategoria, indiceProduto);

        System.out.print("Deseja finalizar a compra? (s/n): ");
        String resposta = scanner.next();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o método de pagamento (boleto, pix, cartao): ");
            String metodoPagamento = scanner.next();

            loja.finalizarCompra(0, metodoPagamento);
        } else {
            System.out.println("Compra cancelada.");
        }

        scanner.close();
    }
}


