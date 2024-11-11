/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lully
 */
public class ConexaoBanco { 
    // Método para obter a conexão com o banco de dados
    public static Connection getConexao() {
        Connection conn = null;

        try {
            // Configurações da conexão (substitua com os detalhes do seu banco de dados)
            String url = "jdbc:postgresql://localhost:5432/impressoras"; // URL do banco
            String usuario = "postgres"; // Nome de usuário do banco de dados
            String senha = "boot"; // Senha do banco de dados
            
            // Conectando ao banco de dados
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace();
            
    }
          return conn;
    }
 
public static void main(String[] args) {
        // Teste a conexão chamando o método getConexao()
        Connection conn = ConexaoBanco.getConexao();
        if (conn != null) {
            System.out.println("Conexão de teste bem-sucedida.");
        } else {
            System.out.println("Falha na conexão de teste.");
        }
    }
}
 
