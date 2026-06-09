package models;
import java.time.LocalDateTime;

public class Senha {
    private int numero;
    private LocalDateTime horaEmissao;
    private String status;
    private int posicao;

    public void gerarSenha(){
        if(numero < 0) 
        return;    
    }

    public void cancelarSenha(){
       if(status == null)
       return;
    }

    public void remarcarSenha(){
       if(horaEmissao == null)
       return; 
    }

    public void listarSenhasAtivas(){
       if(posicao < 0)
       return; 
    }

    @Override
    public String toString(){
        return "Senha:" + numero;
    }
}
