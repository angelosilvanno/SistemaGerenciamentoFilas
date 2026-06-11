package controllers;

import java.util.LinkedList;
import java.util.Queue;
import models.Senha;

public class FilaController {
    private Queue<Senha> filaEspera = new LinkedList<>();
    private int contadorSenhas = 0;

    public void processarEntradaFila() {
        if (filaEspera == null) {
            return;
        }
        contadorSenhas++;
        Senha senha = new Senha(contadorSenhas);
        senha.gerarSenha();
        filaEspera.add(senha);
        System.out.println("Senha " + senha + " gerada e adicionada à fila.");
    }

    public void processarChamadaSenha() {
        if (filaEspera.isEmpty()) {
            System.out.println("Nao ha senhas na fila.");
            return;
        }
        Senha proximaSenha = filaEspera.poll();
        System.out.println("Chamando " + proximaSenha + " para atendimento.");
    }

    public void validarAcesso() {
    }
}