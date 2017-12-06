package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemandaDAO extends GenericDao {

	public void salvar(Integer solicitador, Integer item) {
		
		String sql = "INSERT INTO demanda (solicitador, item_id) VALUES (?,?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setInt(1, solicitador);
			statement.setInt(2, item);
			statement.executeUpdate();
			System.out.println("Demanda realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na realização da demanda");
		}
	}
	
	public void listarDemandasUsuario(Integer solicitador) {
		
	}
}
