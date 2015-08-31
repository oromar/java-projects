package resources;

import br.com.biblia.entidades.Livro;

/*
 *
 * Em : 04/07/2015 - 00:56:17
 * 
 * */

public class LivroDAO extends AbstractDAO<Livro> {

	public LivroDAO() {
		super();
		setClazz(Livro.class);
	}
}
