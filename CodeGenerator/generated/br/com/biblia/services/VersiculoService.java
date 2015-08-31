package resources;

import br.com.biblia.data.VersiculoDAO;
import br.com.biblia.entidades.Versiculo;

/*
 *
 * Em : 04/07/2015 - 00:59:56
 * 
 * */


public class VersiculoService extends AbstractService<Versiculo> {

	public VersiculoService() {
		super();
		this.setDao(new VersiculoDAO());
	}
	
	@Override
	public void preSave(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Versiculo t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
