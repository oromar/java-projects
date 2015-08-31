package resources;

import br.com.biblia.entidades.Comentario;

/*
 *
 * Em : 04/07/2015 - 00:57:54
 * 
 * */

public class ComentarioDAO extends AbstractDAO<Comentario> {

	public ComentarioDAO() {
		super();
		setClazz(Comentario.class);
	}
}
