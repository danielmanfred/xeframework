package dao;

import utility.Conexao;

public class GenericDao {
	
	protected Conexao conexao;
	
	public GenericDao() {
		                                        
	}
	
	public Conexao getConexao() {
		return conexao;
	}
	
	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}
	
}
