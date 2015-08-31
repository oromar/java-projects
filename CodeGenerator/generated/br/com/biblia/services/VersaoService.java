package resources;

import br.com.biblia.data.VersaoDAO;
import br.com.biblia.entidades.Versao;

/*
 *
 * Em : 04/07/2015 - 00:55:50
 * 
 * */


public class VersaoService extends AbstractService<Versao> {

	public VersaoService() {
		super();
		this.setDao(new VersaoDAO());
	}
	
	@Override
	public void preSave(Versao t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Versao t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Versao t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Versao t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Versao t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Versao t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
