package dao;

import domain.Usuario;

public class UsuarioDAO extends GenericDao<Usuario> {
	
	public String salvar() {
		return "INSERT INTO usuario (nome, nota, senha) VALUES (?,?,?)";
	}
	
}
