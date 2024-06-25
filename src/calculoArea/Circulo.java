package calculoArea;

public class Circulo extends Shape {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public String getNome() {
        return "Círculo";
    }

    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
