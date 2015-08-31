package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import BASE_PACKAGE.services.NOME_ENTIDADEService;
import BASE_PACKAGE.entidades.NOME_ENTIDADE;

/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


@ManagedBean(name="NOME_MB")
@ViewScoped
/**/
public class NOME_ENTIDADEMB extends AbstractManagedBean<NOME_ENTIDADE> {

	public NOME_ENTIDADEMB() {
		super(NOME_ENTIDADE.class);
		this.setService(new NOME_ENTIDADEService());
		this.setBeanSelecionado(new NOME_ENTIDADE());
		this.setBeanFiltro(new NOME_ENTIDADE());
		list();
	}
}
