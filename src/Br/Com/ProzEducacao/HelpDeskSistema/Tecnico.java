package Br.Com.ProzEducacao.HelpDeskSistema;

public class Tecnico {
    private String nome;
    private String especialidade;

    public Tecnico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome + " - " + especialidade;
    }
}