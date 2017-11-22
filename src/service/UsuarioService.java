package service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.UsuarioDAO;
import domain.Usuario;
import utility.Conexao;

public class UsuarioService {
	
	private List<Usuario> usuarios;
	private Usuario usuario;
	
	Conexao conexao = new Conexao();
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void criarConta(String nome, Integer nota, String senha) {
		UsuarioDAO dao = new UsuarioDAO();
		
		usuario = new Usuario();
		
		usuario.setNome(nome);
		usuario.setNota(nota);
		usuario.setSenha(senha);
		
		String sql = dao.salvar();
		try {
			PreparedStatement statement = conexao.connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setInt(2, usuario.getNota());
			statement.setString(3, usuario.getSenha());
			statement.executeUpdate(); 
			System.out.println("Conta criada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na criação da conta");
		}
	}
}
