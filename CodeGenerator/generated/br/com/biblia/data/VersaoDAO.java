package resources;

import br.com.biblia.entidades.Versao;

/*
 *
 * Em : 04/07/2015 - 00:55:50
 * 
 * */

public class VersaoDAO extends AbstractDAO<Versao> {

	public VersaoDAO() {
		super();
		setClazz(Versao.class);
	}
}
