package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.IntroducaoService;
import br.com.biblia.entidades.Introducao;

/*
 *
 * Em : 04/07/2015 - 00:58:30
 * 
 * */


@ManagedBean(name="introducaoMB")
@ViewScoped
/**/
public class IntroducaoMB extends AbstractManagedBean<Introducao> {

	public IntroducaoMB() {
		super(Introducao.class);
		this.setService(new IntroducaoService());
		this.setBeanSelecionado(new Introducao());
		this.setBeanFiltro(new Introducao());
		list();
	}
}
