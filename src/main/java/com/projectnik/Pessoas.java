package com.projectnik;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Pessoas {


    public Pessoas (){

    }

    public void criarPessoa(String nome, int idade, String ocupacao) throws SQLException {
        String sql = "INSERT INTO pessoa (nome, idade, ocupacao) VALUES (?, ?, ?)";

        try(Connection conexao = ConexaoBD.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, ocupacao);

            stmt.executeUpdate();
        }
    }

    public void listarPessoas() throws SQLException{
        String sql = "SELECT * FROM pessoa ORDER BY id";

        try(Connection conexao = ConexaoBD.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id") + "| NOME: " + rs.getString("nome"));
            }
        }

    }

    public Pessoa buscarPessoa(int id) throws SQLException, PessoaNaoEncontradaException{
        String sql = "SELECT * FROM pessoa WHERE id = ?";

        try (Connection conexao = ConexaoBD.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)){

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    return new Pessoa(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("ocupacao")
                    );
                }else {
                    throw new PessoaNaoEncontradaException("Pessoa não encontrada!");
                }
            }
        }
    }

    public void atualizarPessoa(int id, String novoNome, int novaIdade, String novaOcupacao) throws SQLException{
        String sql = "UPDATE pessoa SET nome = ?, idade  = ?, ocupacao = ? WHERE id = ?";

        try (Connection conexao = ConexaoBD.getConexao();
                PreparedStatement stmt = conexao.prepareStatement(sql)){

            stmt.setString(1, novoNome);
            stmt.setInt(2, novaIdade);
            stmt.setString(3, novaOcupacao);
            stmt.setInt(4 ,id);

            stmt.executeUpdate();
        }
    }

    public void deletarPessoa(int id) throws SQLException{
        String sql = "DELETE FROM pessoa WHERE id = ?";

        try(Connection conexao = ConexaoBD.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql)){

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }
}
