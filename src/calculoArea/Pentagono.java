package calculoArea;

public class Pentagono extends Shape {
    private double lado;

    public Pentagono(double lado) {
        this.lado = lado;
    }

    @Override
    public String getNome() {
        return "Pentágono";
    }

    @Override
    public double calcularArea() {
        double apotema = lado / (2 * Math.tan(Math.PI / 5));
        return (5 * lado * apotema) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 5 * lado;
    }
}
