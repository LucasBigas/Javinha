package desafio;

public class ProgressaoFibonacci extends Progressao{
    private int atual;
    private int anterior;
    private boolean primeiroTermo;

    public ProgressaoFibonacci() {
        this.reiniciar();
    }

    @Override
    public int proximo() {
        if (primeiroTermo) {
            primeiroTermo = false;
            return 0;
        } else if (anterior == 0) {
            anterior = 1;
            return 1;
        } else {
            int proximoTermo = atual + anterior;
            anterior = atual;
            atual = proximoTermo;
            return anterior;
        }
    }

    @Override
    public void reiniciar() {
        atual = 0;
        anterior = 0;
        primeiroTermo = true;
    }
}
