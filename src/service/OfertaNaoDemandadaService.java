package service;

import dao.OfertaNaoDemandadaDAO;
import utility.Conexao;

public class OfertaNaoDemandadaService {
	
	private OfertaNaoDemandadaDAO dao;
	
	public OfertaNaoDemandadaService(Conexao conexao) {
		dao = new OfertaNaoDemandadaDAO();
		dao.setConexao(conexao);
	}
	
	public void adicionarOferta(Double valor, Integer ofertante, Integer item) {
		dao.salvar(valor, ofertante, item);
	}
	
	public void listarOfertas(Integer categoria) {
		dao.listar(categoria);
	}
	
	public void buscarOferta() {
		
	}
}
