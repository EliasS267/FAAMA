/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author lully
 */
public class TabelaPreenchimento {
    
    private ConexaoBanco conexaoBanco;
    
    public TabelaPreenchimento() {
        this.conexaoBanco = new ConexaoBanco(); // Conecta ao banco usando sua classe de conexão
    }
    
    public void preencherTabela(JTable tabela) {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0); // Limpa a tabela antes de preenchê-la
        
        try {
            Connection conn = conexaoBanco.getConexao(); // Obtenha a conexão do banco
            String query = "SELECT * FROM impressoras"; // Substitua 'NomeDaTabela' pelo nome da sua tabela no banco de dados
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            // Loop através dos resultados e adicione à tabela
            while (rs.next()) {
                Object[] linha = {
                           // Altere os nomes das colunas conforme necessário
                    rs.getString("id"),
                    rs.getString("nome_impressora"),
                    rs.getString("local_impressora"),
                    rs.getString("toner"),
                    rs.getString("modelo_toner"),
                    rs.getString("quantidade"),
                    
                };
                modelo.addRow(linha);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao preencher a tabela: " + e.getMessage());
        }

    }


     
    
}
