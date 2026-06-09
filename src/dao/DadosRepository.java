package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DadosRepository {
    private Connection conexao;

    public void conectarBanco(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:banco_filas.db";
            this.conexao = DriverManager.getConnection(url);
            criarTabelasIniciais();
        } catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getMessage());
        }
    }

    private void criarTabelasIniciais(){
        try (Statement stmt = this.conexao.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (cpf TEXT PRIMARY KEY, nome TEXT, senha TEXT, tipo TEXT, telefone TEXT, ativo INTEGER);");
            stmt.execute("CREATE TABLE IF NOT EXISTS unidades (nome TEXT PRIMARY KEY, endereco TEXT, horario TEXT);");
            stmt.execute("CREATE TABLE IF NOT EXISTS tipos_atendimento (descricao TEXT PRIMARY KEY);");
            stmt.execute("CREATE TABLE IF NOT EXISTS senhas (numero INTEGER PRIMARY KEY AUTOINCREMENT, hora_emissao TEXT, status TEXT, posicao INTEGER, cpf_cidadao TEXT, nome_unidade TEXT);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
