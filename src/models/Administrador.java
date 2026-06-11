package models;

public class Administrador extends Usuario {

    public void cadastrarUnidade() {
        System.out.println("Unidade cadastrada!");
    }

    public void gerenciarTiposAtendimento() {
        System.out.println("Alterando tipos de atendimento...");
    }

    public void gerarRelatorioMensal() {
        System.out.println("Relatorio gerado com sucesso.");
    }
}