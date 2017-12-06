package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NegocioDAO extends GenericDao {

	public void salvarNaoDemandada(Integer oferta) {
		String sql = "INSERT INTO negocio (oferta_nao_demandada) VALUES (?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setInt(1, oferta);
			statement.executeUpdate();
			System.out.println("Negociação realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na negociação");
		}
	}
	
	public void salvarDemandada(Integer oferta) {
		String sql = "INSERT INTO negocio (oferta_demandada) VALUES (?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setInt(1, oferta);
			statement.executeUpdate();
			System.out.println("Negociação realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na negociação");
		}
	}
}
