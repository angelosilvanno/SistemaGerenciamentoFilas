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
            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (cpf TEXT PRIMARY KEY, nome TEXT, senha TEXT, tipo TEXT, ativo INTEGER);");
            stmt.execute("CREATE TABLE IF NOT EXISTS unidades (nome TEXT PRIMARY KEY, endereco TEXT, horario TEXT);");
            stmt.execute("CREATE TABLE IF NOT EXISTS tipos_atendimento (descricao TEXT PRIMARY KEY);");
            stmt.execute("CREATE TABLE IF NOT EXISTS senhas (numero INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT, posicao INTEGER, cpf_usuario TEXT);");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public String verificarLoginETipo(String cpf, String senha) {
        String sql = "SELECT tipo FROM usuarios WHERE cpf = ? AND senha = ? AND ativo = 1";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo");
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    public void salvarUnidade(String nome, String endereco) {
        String sql = "INSERT INTO unidades (nome, endereco) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, endereco);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar unidade.");
        }
    }

    public void salvarSenha(Senha s) {
        if (s == null) {
            return;
        }
        String sql = "INSERT INTO senhas (status, posicao) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, "Ativa");
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao salvar senha.");
        }
    }

    public String buscarSenhaPorCpf(String cpf) {
        String sql = "SELECT senha FROM usuarios WHERE cpf = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("senha");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar senha.");
        }
        return null;
    }

    public void buscarDados() {
        String sql = "SELECT * FROM senhas";
        try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Senha: " + rs.getInt("numero") + " | Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar dados.");
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}