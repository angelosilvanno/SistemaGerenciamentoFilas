package models;

import java.time.LocalDateTime;

public class Senha {
    private int numero;
    private LocalDateTime horaEmissao;
    private String status;
    private int posicao;

    public Senha(int numero) {
        this.numero = numero;
        this.status = "emitida";
    }

    public void gerarSenha() {
        if (numero < 0) {
            return;
        }
        this.horaEmissao = LocalDateTime.now();
        this.status = "ativa";
    }

    public void cancelarSenha() {
        if (status == null) {
            return;
        }
        this.status = "cancelada";
    }

    public void remarcarSenha() {
        if (horaEmissao == null) {
            return;
        }
        this.horaEmissao = LocalDateTime.now().plusMinutes(30);
    }

    public void listarSenhasAtivas() {
        if (!"ativa".equals(status)) {
            return;
        }
    }

    public String getCodigo() {
        return String.format("A%03d", numero);
    }

    @Override
    public String toString() {
        return getCodigo();
    }
}
