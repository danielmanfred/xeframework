package service;

import dao.OfertaDemandadaDAO;
import utility.Conexao;

public class OfertaDemandadaService {
	
	private OfertaDemandadaDAO dao;
	
	public OfertaDemandadaService(Conexao conexao) {
		dao = new OfertaDemandadaDAO();
		dao.setConexao(conexao);
	}
	
	public void adicionarOferta(Double valor, Integer ofertante, Integer demanda) {
		dao.salvar(valor, ofertante, demanda);
	}
	
}
