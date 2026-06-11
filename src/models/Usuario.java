package models;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private boolean ativo;

    public boolean realizarLogin(){
        if(ativo == false){ 
            return false;
        }
        if(cpf == null) {
            return false;
        }
        if(senha == null) {
            return false;
        }
        return true;
    }

    public void recuperarSenha(){
        if(cpf == null) {
            return;
        }
        if(ativo == false) {
            return;
        }
    }

    public void desativarConta(){
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Usuario: " + nome;
    }
}