package calculoArea;


public class Losango extends Shape {
    private double diagonalMaior;
    private double diagonalMenor;
    private double lado;

    public Losango(double diagonalMaior, double diagonalMenor, double lado) {
        this.diagonalMaior = diagonalMaior;
        this.diagonalMenor = diagonalMenor;
        this.lado = lado;
    }

    @Override
    public String getNome() {
        return "Losango";
    }

    @Override
    public double calcularArea() {
        return (diagonalMaior * diagonalMenor) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}
