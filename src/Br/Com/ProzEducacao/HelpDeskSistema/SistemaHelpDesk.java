package Br.Com.ProzEducacao.HelpDeskSistema;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class SistemaHelpDesk {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Tecnico> tecnicos = new ArrayList<>();
    private static List<Chamado> chamados = new ArrayList<>();

    public static void main(String[] args) {
        String[] opcoes = {
            "Cadastrar Funcionário", "Cadastrar Técnico", "Cadastrar Chamado",
            "Atribuir Técnico ao Chamado", "Listar Chamados", "Atualizar Status do Chamado", "Sair"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Sistema Help Desk",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcoes, opcoes[0]);

            switch (escolha) {
                case 0 : cadastrarFuncionario(); break;
                case 1 : cadastrarTecnico(); break;
                case 2 : cadastrarChamado(); break;
                case 3 : atribuirTecnico(); break;
                case 4 : listarChamados(); break;
                case 5 : atualizarStatus(); break;
            }
        } while (escolha != 6);
    }

    private static void cadastrarFuncionario() {
        String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
        String email = JOptionPane.showInputDialog("Email:");
        String setor = JOptionPane.showInputDialog("Setor:");
        funcionarios.add(new Funcionario(nome, email, setor));
    }

    private static void cadastrarTecnico() {
        String nome = JOptionPane.showInputDialog("Nome do Técnico:");
        String especialidade = JOptionPane.showInputDialog("Especialidade:");
        tecnicos.add(new Tecnico(nome, especialidade));
    }

    private static void cadastrarChamado() {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cadastre um funcionário primeiro.");
            return;
        }

        String titulo = JOptionPane.showInputDialog("Título do Chamado:");
        String descricao = JOptionPane.showInputDialog("Descrição:");
        String data = JOptionPane.showInputDialog("Data de abertura:");
        Funcionario funcionario = (Funcionario) JOptionPane.showInputDialog(null, "Escolha o funcionário:",
                "Funcionários", JOptionPane.QUESTION_MESSAGE, null, funcionarios.toArray(), funcionarios.get(0));

        chamados.add(new Chamado(titulo, descricao, funcionario, data));
    }

    private static void atribuirTecnico() {
        if (chamados.isEmpty() || tecnicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Certifique-se de que há chamados e técnicos cadastrados.");
            return;
        }

        Chamado chamado = (Chamado) JOptionPane.showInputDialog(null, "Escolha o chamado:",
                "Chamados", JOptionPane.QUESTION_MESSAGE, null, chamados.toArray(), chamados.get(0));
        Tecnico tecnico = (Tecnico) JOptionPane.showInputDialog(null, "Escolha o técnico:",
                "Técnicos", JOptionPane.QUESTION_MESSAGE, null, tecnicos.toArray(), tecnicos.get(0));

        chamado.atribuirTecnico(tecnico);
    }

    private static void listarChamados() {
        StringBuilder lista = new StringBuilder();
        for (Chamado c : chamados) {
            lista.append(c).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, lista.length() == 0 ? "Nenhum chamado." : lista.toString());
    }

    private static void atualizarStatus() {
        if (chamados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há chamados cadastrados.");
            return;
        }

        Chamado chamado = (Chamado) JOptionPane.showInputDialog(null, "Escolha o chamado:",
                "Chamados", JOptionPane.QUESTION_MESSAGE, null, chamados.toArray(), chamados.get(0));

        String[] status = {"Aberto", "Em atendimento", "Resolvido"};
        String novoStatus = (String) JOptionPane.showInputDialog(null, "Novo status:",
                "Atualizar Status", JOptionPane.QUESTION_MESSAGE, null, status, chamado.getStatus());

        chamado.atualizarStatus(novoStatus);
    }
}