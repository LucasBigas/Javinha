package Hospital;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;

    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

        @Override
        public String toString() {
            String cpfFormatado = formatarCPF(cpf);
            return "Paciente{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", cpf='" + cpfFormatado + '\'' +
                    '}';
        }

        // Método auxiliar para formatar CPF
        private String formatarCPF(String cpf) {
            return cpf.substring(0, 3) + "." + cpf.substring(4, 7) + "." + cpf.substring(8, 11) + "-" + cpf.substring(12, 14);
        }
    }



