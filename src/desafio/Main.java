package desafio;

public class Main {
    public static void main(String[] args) {
        Progressao pa = new ProgressaoAritmetica(1, 2);
        System.out.println("Progressão Aritmética:");
        for (int i = 0; i < 5; i++) {
            System.out.println(pa.proximo());
        }
        pa.reiniciar();
        
        Progressao pg = new ProgressaoAritmetica(2, 3);
        System.out.println("Progressão Geométrica:");
        for (int i = 0; i < 5; i++) {
            System.out.println(pg.proximo());
        }
        pg.reiniciar();
        
        Progressao fib = new ProgressaoFibonacci();
        System.out.println("Progressão de Fibonacci:");
        for (int i = 0; i < 10; i++) {
            System.out.println(fib.proximo());
        }
        fib.reiniciar();
    }
}
