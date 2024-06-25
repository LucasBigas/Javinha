package desafio;

public class ProgressaoAritmetica extends Progressao{
    private int atual;
    private int passo;
    private int inicio;

    public ProgressaoAritmetica ( int inicio, int passso){
        this.inicio = inicio;
        this.passo = passso;
        this.atual = inicio;
    }

    @Override
    public int proximo(){
        int valorAtual = atual;
        atual += passo;
        return valorAtual;
    }

    @Override
    public void reiniciar() {
        atual = inicio;
    }

    
}
