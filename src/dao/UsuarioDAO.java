package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;

public class UsuarioDAO extends GenericDao {
	
	public UsuarioDAO() {
		
	}
	
	public void salvar(String nome, String senha) {

		String sql = "INSERT INTO usuario (nome, nota, senha) VALUES (?,?,?)";
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setInt(2, 0);
			statement.setString(3, senha);
			statement.executeUpdate();
			System.out.println("Conta criada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na criação da conta");
		}
	}
	
	public Usuario logar(String nome, String senha) {

		ResultSet rs = null;
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setString(2, senha);
			rs = statement.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setNota(rs.getInt("nota"));
				usuario.setSenha(rs.getString("senha"));
				System.out.println("Login efetuado com sucesso");
			}
			else {
				System.out.println("Informações de login incorretas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na login");
		}

		return usuario;
	}
	
	public void excluirConta(Integer id) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("Conta excluída sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na remoção da conta");
		}
	}
	
	
	public void alterarNome(Integer id, String nome) {
		
		String sql = "UPDATE usuario SET nome = ? WHERE id = ?";

		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setInt(2, id);
			statement.executeUpdate();
			System.out.println("Nome alterado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na alteração do nome");
		}
	}

	public List<Usuario> listar() {
	
		List<Usuario> usuarios = new ArrayList<>();
		
		String sql = "SELECT * FROM usuario";
		
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setNota(rs.getInt("nota"));
				usuario.setSenha(rs.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			System.out.println("Lista de usuários retornados com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na listagem de usuários");
		}
		
		return usuarios;
	}
	
}
