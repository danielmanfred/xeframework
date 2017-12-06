package service;

import utility.Conexao;

public class SelecaoOfertaDemandada extends SelecaoOferta {

	@Override
	public void realizarNegocio(Integer oferta, Conexao conexao) {
		NegocioService ns = new NegocioService(conexao);
		
		ns.adicionarNegocioDemandado(oferta);
	}

	@Override
	public void notificarOfertor() {
		// TODO Auto-generated method stub

	}

}
