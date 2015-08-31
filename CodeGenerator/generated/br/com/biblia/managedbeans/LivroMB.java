package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.LivroService;
import br.com.biblia.entidades.Livro;

/*
 *
 * Em : 04/07/2015 - 00:56:17
 * 
 * */


@ManagedBean(name="livroMB")
@ViewScoped
/**/
public class LivroMB extends AbstractManagedBean<Livro> {

	public LivroMB() {
		super(Livro.class);
		this.setService(new LivroService());
		this.setBeanSelecionado(new Livro());
		this.setBeanFiltro(new Livro());
		list();
	}
}
