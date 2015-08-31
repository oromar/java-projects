package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.VersiculoService;
import br.com.biblia.entidades.Versiculo;

/*
 *
 * Em : 04/07/2015 - 00:59:56
 * 
 * */


@ManagedBean(name="versiculoMB")
@ViewScoped
/**/
public class VersiculoMB extends AbstractManagedBean<Versiculo> {

	public VersiculoMB() {
		super(Versiculo.class);
		this.setService(new VersiculoService());
		this.setBeanSelecionado(new Versiculo());
		this.setBeanFiltro(new Versiculo());
		list();
	}
}
