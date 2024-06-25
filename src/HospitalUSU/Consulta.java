package HospitalUSU;

public class Consulta {
    private String tipo;
    private String data;
    private String medico;
    private String resultado;
    private double valor;

    public Consulta(String tipo, String data, String medico, double valor) {
        this.tipo = tipo;
        this.data = data;
        this.medico = medico;
        this.valor = valor;
        this.resultado = "";
    }

    // Getters e setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void registrarResultado(String resultado) {
        this.resultado = resultado;
    }

    public double calcularValor(boolean temConvenio) {
        if (temConvenio) {
            return valor * 0.8; // 20% de desconto
        } else {
            return valor;
        }
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "tipo='" + tipo + '\'' +
                ", data='" + data + '\'' +
                ", medico='" + medico + '\'' +
                ", resultado='" + resultado + '\'' +
                ", valor=" + valor +
                '}';
    }
}
