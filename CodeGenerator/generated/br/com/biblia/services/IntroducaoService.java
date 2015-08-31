package resources;

import br.com.biblia.data.IntroducaoDAO;
import br.com.biblia.entidades.Introducao;

/*
 *
 * Em : 04/07/2015 - 00:58:30
 * 
 * */


public class IntroducaoService extends AbstractService<Introducao> {

	public IntroducaoService() {
		super();
		this.setDao(new IntroducaoDAO());
	}
	
	@Override
	public void preSave(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Introducao t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
