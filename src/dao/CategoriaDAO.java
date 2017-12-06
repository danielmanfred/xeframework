package dao;

import java.sql.PreparedStatement;

public class CategoriaDAO extends GenericDao {

	public void salvar(Integer id, String nome) {
		
		String sql = salvar();
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setString(2, nome);
			statement.executeUpdate();
			System.out.println("A categoria foi adicionada");
		}
		catch (Exception e) {
			System.out.println("A categoria foi adicionada");
		}
	}
	
	public String salvar() {
		return "INSERT INTO categoria (id, nome) VALUES (?, ?)";
	}
	
	public String buscar() {
		return "SELECT ";
	}
	
	public String listar() {
		return "SELECT nome FROM categoria";
	}
}
