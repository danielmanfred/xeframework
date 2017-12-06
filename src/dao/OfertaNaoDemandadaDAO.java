package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfertaNaoDemandadaDAO extends GenericDao {
	
	public void salvar(Double valor, Integer ofertante, Integer item) {
		String sql = "INSERT INTO ofertanaodemandada (valor, ofertante, item_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			
			statement.setDouble(1, valor);
			statement.setInt(2, ofertante);
			statement.setInt(3, item);
			
			
			statement.executeUpdate();
			System.out.println("Oferta criada com sucesso");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println("Erro na criação da oferta");
		}
	}
	
	public void listar(Integer categoria) {
		
		ResultSet rs = null;
		String sql = "SELECT i.nome AS item, u.nome AS ofertante, o.valor FROM ofertanaodemandada o JOIN usuario u ON o.ofertante = u.id "
				+ "JOIN item i ON o.item_id = i.id";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			
			//statement.setInt(1, categoria);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("item") + " - " + rs.getString("ofertante") + " - " +  
						rs.getString("valor"));
			}
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println("Erro na Listagem de ofertas");
		}
	}
	
	public Integer buscar() {
		return null;
	}
}
