package Br.Com.ProzEducacao.HelpDeskSistema;

public class Chamado {
    private String titulo;
    private String descricao;
    private Funcionario solicitante;
    private String dataAbertura;
    private String status;
    private Tecnico tecnico;

    public Chamado(String titulo, String descricao, Funcionario solicitante, String dataAbertura) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.solicitante = solicitante;
        this.dataAbertura = dataAbertura;
        this.status = "Aberto";
    }

    public void atribuirTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public String getStatus() {
        return status;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    @Override
    public String toString() {
        return "Chamado: " + titulo +
               "\nDescrição: " + descricao +
               "\nSolicitante: " + solicitante +
               "\nData: " + dataAbertura +
               "\nStatus: " + status +
               (tecnico != null ? "\nTécnico: " + tecnico : "");
    }
}