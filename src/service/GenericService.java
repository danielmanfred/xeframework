package service;

import utility.Conexao;

public class GenericService {

	protected Conexao conexao;
	
	public GenericService() {
		                                        
	}
	
	public Conexao getConexao() {
		return conexao;
	}
	
	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}
}
