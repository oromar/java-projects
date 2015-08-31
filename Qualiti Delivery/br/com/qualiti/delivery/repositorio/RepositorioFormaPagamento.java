package br.com.qualiti.delivery.repositorio;
import br.com.qualiti.delivery.entidades.FormaPagamento;


public class RepositorioFormaPagamento {

	private static final int TAM_MAX_CACHE = 100;
	private FormaPagamento[] repositorio;
	private int indice = 0;

	public RepositorioFormaPagamento() {
		repositorio = new FormaPagamento[TAM_MAX_CACHE];
	}

	private int procurarIndice(int codigo){
		int retorno = -1;
		for(int i = 0; i < indice; i++){
			if (repositorio[i].getCodigo() == codigo){
				retorno = i;
				break;
			}
		}
		return retorno;
	}

	public boolean existe(int codigo){
		return procurarIndice(codigo) != -1;
	}

	public FormaPagamento procurar(int codigo){
		if (existe(codigo)){
			return repositorio[procurarIndice(codigo)];
		}
		return null;
	}

	public void inserir(FormaPagamento formaPagamento){
		repositorio[indice++] = formaPagamento;
	}

	public void atualizar(FormaPagamento formaPagamento){
		int i =0;
		if (existe(formaPagamento.getCodigo())){
			i = procurarIndice(formaPagamento.getCodigo());
			repositorio[i] = formaPagamento;
		}
	}

	public void remover(int codigo){
		if (existe(codigo)){
			int i = procurarIndice(codigo);
			repositorio[i] = repositorio[indice-1];
			repositorio[indice- 1] = null;
			indice--;

		}
	}	

}
