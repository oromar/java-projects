package resources;

import br.com.biblia.data.ComentarioDAO;
import br.com.biblia.entidades.Comentario;

/*
 *
 * Em : 04/07/2015 - 00:57:54
 * 
 * */


public class ComentarioService extends AbstractService<Comentario> {

	public ComentarioService() {
		super();
		this.setDao(new ComentarioDAO());
	}
	
	@Override
	public void preSave(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Comentario t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
