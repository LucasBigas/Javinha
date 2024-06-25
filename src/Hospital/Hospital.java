package Hospital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Hospital() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void marcarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.getMedico().adicionarConsulta(consulta);
    }

    public void listarPacientes() {
        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    public void listarMedicos() {
        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }

    public void listarConsultas() {
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }

    public void listarAgendaMedico(String crm) {
        Medico medico = null;
        for (Medico m : medicos) {
            if (m.getCrm().equals(crm)) {
                medico = m;
                break;
            }
        }
        if (medico != null) {
            medico.listarAgenda();
        } else {
            System.out.println("Medico não encontrado!");
        }
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Sistema de Gestão Hospitalar");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Adicionar Medico");
            System.out.println("3. Marcar Consulta");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Listar Medicos");
            System.out.println("6. Listar Consultas");
            System.out.println("7. Listar Agenda do Medico");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Paciente: ");
                    String nomePaciente = scanner.nextLine();
                    System.out.print("Idade do Paciente: ");
                    int idadePaciente = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("CPF do Paciente(xxx.xxx.xxx-xx): ");
                    String cpfPaciente = scanner.nextLine();
                    Paciente paciente = new Paciente(nomePaciente, idadePaciente, cpfPaciente);
                    hospital.adicionarPaciente(paciente);
                    break;
                case 2:
                    System.out.print("Nome do Medico: ");
                    String nomeMedico = scanner.nextLine();
                    System.out.print("Especialidade do Medico: ");
                    String especialidadeMedico = scanner.nextLine();
                    System.out.print("CRM do Medico: ");
                    String crmMedico = scanner.nextLine();
                    Medico medico = new Medico(nomeMedico, especialidadeMedico, crmMedico);
                    hospital.adicionarMedico(medico);
                    break;
                case 3:
                    System.out.print("CPF do Paciente(xxx.xxx.xxx-xx): ");
                    String cpf = scanner.nextLine();
                    Paciente pacienteConsulta = null;
                    for (Paciente p : hospital.pacientes) {
                        if (p.getCpf().equals(cpf)) {
                            pacienteConsulta = p;
                            break;
                        }
                    }
                    if (pacienteConsulta == null) {
                        System.out.println("Paciente não encontrado! Cadastre o paciente.");
                        System.out.print("Nome do Paciente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade do Paciente: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        pacienteConsulta = new Paciente(nome, idade, cpf);
                        hospital.adicionarPaciente(pacienteConsulta);
                    }

                    System.out.print("CRM do Medico: ");
                    String crm = scanner.nextLine();
                    Medico medicoConsulta = null;
                    for (Medico m : hospital.medicos) {
                        if (m.getCrm().equals(crm)) {
                            medicoConsulta = m;
                            break;
                        }
                    }
                    if (medicoConsulta == null) {
                        System.out.println("Medico não encontrado!");
                        break;
                    }

                    System.out.print("Data e Hora da Consulta (yyyy-MM-dd HH:mm): ");
                    String dataHora = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    try {
                        LocalDateTime dataHoraConsulta = LocalDateTime.parse(dataHora, formatter);
                        Consulta consulta = new Consulta(pacienteConsulta, medicoConsulta, dataHoraConsulta);
                        hospital.marcarConsulta(consulta);
                    } catch (Exception e) {
                        System.out.println("Formato de data e hora inválido! Tente novamente.");
                    }
                    break;
                case 4:
                    hospital.listarPacientes();
                    break;
                case 5:
                    hospital.listarMedicos();
                    break;
                case 6:
                    hospital.listarConsultas();
                    break;
                case 7:
                    System.out.print("CRM do Medico: ");
                    String crmAgenda = scanner.nextLine();
                    hospital.listarAgendaMedico(crmAgenda);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}



