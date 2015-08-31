package resources;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblia.services.ComentarioService;
import br.com.biblia.entidades.Comentario;

/*
 *
 * Em : 04/07/2015 - 00:57:54
 * 
 * */


@ManagedBean(name="comentarioMB")
@ViewScoped
/**/
public class ComentarioMB extends AbstractManagedBean<Comentario> {

	public ComentarioMB() {
		super(Comentario.class);
		this.setService(new ComentarioService());
		this.setBeanSelecionado(new Comentario());
		this.setBeanFiltro(new Comentario());
		list();
	}
}
