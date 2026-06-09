import dao.DadosRepository;
import views.SistemaView;

public class Main {
    public static void main(String[] args){
        DadosRepository repositorio = new DadosRepository();
        repositorio.conectarBanco();

        SistemaView tela = new SistemaView();
        tela.exibirMenuPrincipal();
    }
}
