package models;

public class Cidadao extends Usuario {
    private String telefone;

    public void entrarNaFila(){
        if(telefone == null){
            return;
        }
    }

    public void visualizarHistorico(){
        if(telefone != null){
            
        }
    }
}
