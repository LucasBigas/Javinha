package calculoArea;

public class Hexagono extends Shape {
    private double lado;

    public Hexagono(double lado) {
        this.lado = lado;
    }

    @Override
    public String getNome() {
        return "Hexágono";
    }

    @Override
    public double calcularArea() {
        return (3 * Math.sqrt(3) * lado * lado) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 6 * lado;
    }
}

