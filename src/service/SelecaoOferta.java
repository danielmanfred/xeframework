package service;

import utility.Conexao;

public abstract class SelecaoOferta {
	
	public void selecionarOferta(Integer oferta, Conexao conexao) {
		realizarNegocio(oferta, conexao);
		notificarOfertor();
	}
	
	public abstract void realizarNegocio(Integer oferta, Conexao conexao);
	
	public abstract void notificarOfertor();
}
