package service;

import dao.DemandaDAO;
import utility.Conexao;

public class DemandaService {
	
	private DemandaDAO dao;
	
	public DemandaService(Conexao conexao) {
		dao = new DemandaDAO();
		dao.setConexao(conexao);
	}
	
	public void criarDemanda(Integer solicitador, Integer item) {
		dao.salvar(solicitador, item);
	}
	
}
