package models;

public class Atendente extends Usuario {

    public void chamarProximo() {
        System.out.println("Chamando proximo da fila...");
    }

    public void registrarInicioAtendimento() {
        System.out.println("Atendimento iniciado.");
    }

    public void registrarFimAtendimento() {
        System.out.println("Atendimento encerrado.");
    }
}