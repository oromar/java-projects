package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.TestamentoService;
import br.com.biblia.entidades.Testamento;

/*
 *
 * Em : 04/07/2015 - 00:55:43
 * 
 * */


@ManagedBean(name="testamentoMB")
@ViewScoped
/**/
public class TestamentoMB extends AbstractManagedBean<Testamento> {

	public TestamentoMB() {
		super(Testamento.class);
		this.setService(new TestamentoService());
		this.setBeanSelecionado(new Testamento());
		this.setBeanFiltro(new Testamento());
		list();
	}
}
