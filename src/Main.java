import dao.DadosRepository;
import views.SistemaView;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        DadosRepository repositorio = new DadosRepository();
        repositorio.conectarBanco();

        try {
            Statement stmt = repositorio.getConexao().createStatement();
            
            stmt.execute("INSERT OR IGNORE INTO usuarios (cpf, nome, senha, tipo, ativo) " +
            "VALUES ('11111111111', 'Ana Gestora', 'admin123', 'Administrador', 1);");

            stmt.execute("INSERT OR IGNORE INTO usuarios (cpf, nome, senha, tipo, ativo) " +
            "VALUES ('22222222222', 'Dr. Henrique', 'atend123', 'Atendente', 1);");

            stmt.execute("INSERT OR IGNORE INTO usuarios (cpf, nome, senha, tipo, ativo) " +
            "VALUES ('33333333333', 'Ângelo Silvano', 'cidadao123', 'Cidadao', 1);");

        } catch (Exception e) {
    
        }

        SistemaView tela = new SistemaView();
        tela.exibirMenuPrincipal();
    }
}