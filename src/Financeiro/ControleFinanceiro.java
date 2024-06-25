package Financeiro;

import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiro {
    private List<Transacao> transacoes;

    public ControleFinanceiro() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public double obterBalancoMensal(int mes, int ano) {
        double balanco = 0;
        for (Transacao transacao : transacoes) {
            if (transacao.getData().getMonthValue() == mes && transacao.getData().getYear() == ano) {
                if (transacao.getTipo().equals("RECEITA")) {
                    balanco += transacao.getValor();
                } else {
                    balanco -= transacao.getValor();
                }
            }
        }
        return balanco;
    }

    public List<Transacao> listarTransacoesPorCategoria(String categoria) {
        List<Transacao> transacoesPorCategoria = new ArrayList<>();
        for (Transacao transacao : transacoes) {
            if (transacao.getCategoria().equalsIgnoreCase(categoria)) {
                transacoesPorCategoria.add(transacao);
            }
        }
        return transacoesPorCategoria;
    }
}
