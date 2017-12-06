package service;

import dao.NegocioDAO;
import utility.Conexao;

public class NegocioService {
	
	private NegocioDAO dao;
	
	public NegocioService(Conexao conexao) {
		dao = new NegocioDAO();
		dao.setConexao(conexao);
	}

	public void adicionarNegocioNaoDemandado(Integer oferta) {
		dao.salvarNaoDemandada(oferta);;
	}
	
	public void adicionarNegocioDemandado(Integer oferta) {
		dao.salvarDemandada(oferta);;
	}
}
