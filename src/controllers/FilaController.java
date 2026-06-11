package controllers;

import java.util.LinkedList;
import java.util.Queue;
import models.Senha;

public class FilaController {
    private Queue<Senha> filaEspera = new LinkedList<>();

    public void processarEntradaFila(){
        if(filaEspera == null) {
            return;
        }
    }

    public void processarChamadaSenha(){
        if(filaEspera.isEmpty()){
            return;
        }
    }

    public void validarAcesso(){
    }
}