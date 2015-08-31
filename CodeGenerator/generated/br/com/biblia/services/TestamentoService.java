package resources;

import br.com.biblia.data.TestamentoDAO;
import br.com.biblia.entidades.Testamento;

/*
 *
 * Em : 04/07/2015 - 00:55:43
 * 
 * */


public class TestamentoService extends AbstractService<Testamento> {

	public TestamentoService() {
		super();
		this.setDao(new TestamentoDAO());
	}
	
	@Override
	public void preSave(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(Testamento t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
