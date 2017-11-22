package dao;

import java.lang.reflect.ParameterizedType;

public class GenericDao<Entidade> {
	
	@SuppressWarnings("unused")
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
