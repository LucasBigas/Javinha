package calculoArea;

public class MainArea {
    public static void main(String[] args) {
        Shape[] figuras = new Shape[] {
            new Retangulo(4, 5),
            new Circulo(3),
            new Losango(6, 4, 5),
            new Hexagono(3),
            new Pentagono(4)
        };

        for (Shape figura : figuras) {
            System.out.println("Figura: " + figura.getNome());
            System.out.println("Área: " + figura.calcularArea());
            System.out.println("Perímetro: " + figura.calcularPerimetro());
            System.out.println();
        }
    
    }
}
