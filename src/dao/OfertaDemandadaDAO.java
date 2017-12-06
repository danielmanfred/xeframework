package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OfertaDemandadaDAO extends GenericDao {
	
	public void salvar(Double valor, Integer ofertante, Integer demanda) {
		
		String sql = "INSERT INTO ofertademandada (valor, ofertante, demanda_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			
			statement.setDouble(1, valor);
			statement.setInt(2, ofertante);
			statement.setInt(3, demanda);
			
			statement.executeUpdate();
			System.out.println("Oferta criada com sucesso");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println("Erro na criação da oferta");
		}
	}

}
