package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.VersaoService;
import br.com.biblia.entidades.Versao;

/*
 *
 * Em : 04/07/2015 - 00:55:50
 * 
 * */


@ManagedBean(name="versaoMB")
@ViewScoped
/**/
public class VersaoMB extends AbstractManagedBean<Versao> {

	public VersaoMB() {
		super(Versao.class);
		this.setService(new VersaoService());
		this.setBeanSelecionado(new Versao());
		this.setBeanFiltro(new Versao());
		list();
	}
}
