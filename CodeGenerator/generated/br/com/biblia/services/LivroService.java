package resources;

import br.com.biblia.data.LivroDAO;
import br.com.biblia.entidades.Livro;

/*
 *
 * Em : 04/07/2015 - 00:56:17
 * 
 * */


public class LivroService extends AbstractService<Livro> {

	public LivroService() {
		super();
		this.setDao(new LivroDAO());
	}
	
	@Override
	public void preSave(Livro t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Livro t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Livro t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Livro t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Livro t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Livro t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
