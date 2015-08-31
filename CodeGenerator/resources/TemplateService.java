package resources;

import BASE_PACKAGE.data.NOME_ENTIDADEDAO;
import BASE_PACKAGE.entidades.NOME_ENTIDADE;

/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


public class NOME_ENTIDADEService extends AbstractService<NOME_ENTIDADE> {

	public NOME_ENTIDADEService() {
		super();
		this.setDao(new NOME_ENTIDADEDAO());
	}
	
	@Override
	public void preSave(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio antes de salvar entidade, se houver
	}

	@Override
	public void preRemove(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio antes de remover entidade, se houver
	}

	@Override
	public void preUpdate(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio antes de atualizar entidade, se houver
	}
	
	@Override
	public void posSave(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio depois de salvar entidade, se houver
	}

	@Override
	public void posRemove(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio depois de remover entidade, se houver
	}

	@Override
	public void posUpdate(NOME_ENTIDADE t) throws Exception {
		//TODO Adicionar regra de negócio depois de atualizar entidade, se houver
	}

}
