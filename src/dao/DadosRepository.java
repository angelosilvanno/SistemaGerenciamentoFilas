package dao;

import java.sql.*;
import models.*;

public class DadosRepository {
    private Connection conexao;

    public void conectarBanco() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.conexao = DriverManager.getConnection("jdbc:sqlite:banco_filas.db");
            criarTabelasIniciais();
        } catch (Exception e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }

    private void criarTabelasIniciais() {
        try (Statement stmt = this.conexao.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (cpf TEXT PRIMARY KEY, nome TEXT, senha TEXT, ativo INTEGER);");
            stmt.execute("CREATE TABLE IF NOT EXISTS senhas (numero INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT, posicao INTEGER);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean verificarLogin(String cpf, String senha) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ? AND senha = ? AND ativo = 1";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public void salvarDados(Usuario u) {
        if (u == null) {
            return;
        }
    }

    public void buscarDados() {
        if (conexao == null) {
            return;
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}