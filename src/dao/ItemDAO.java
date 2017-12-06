package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAO extends GenericDao {

	public void salvar(String nome, String descricao, Integer categoria) {
		
		String sql = "INSERT INTO item (nome, descricao, categoria_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, descricao);
			statement.setInt(3, categoria);
			statement.executeUpdate();
			System.out.println("Item criado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na criação do item");
		}
	}
	
	public Integer buscarItemRecemcriado(String nome, Integer categoria) {
		
		ResultSet rs = null;
		Integer itemId = null;
		String sql = "SELECT * FROM item WHERE nome = ? AND categoria_id = ?";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			
			statement.setString(1, nome);
			statement.setInt(2, categoria);
			
			rs = statement.executeQuery();
			
			if (rs.next()) {
				itemId = rs.getInt("id");
			}
			else {
				System.out.println("Item não foi localizado");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na na busca do item");
		}
		
		return itemId;
	}
}
