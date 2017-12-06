package service;

import dao.ItemDAO;
import domain.Item;
import utility.Conexao;

public class ItemService {
	
	@SuppressWarnings("unused")
	private Item item;
	private ItemDAO dao;
	
	public ItemService(Conexao conexao) {
		dao = new ItemDAO();
		dao.setConexao(conexao);
	}
	
	public Integer adicionarItem(String nome, String descricao, Integer categoria) {
		dao.salvar(nome, descricao, categoria);
		
		return dao.buscarItemRecemcriado(nome, categoria);
	}

}
