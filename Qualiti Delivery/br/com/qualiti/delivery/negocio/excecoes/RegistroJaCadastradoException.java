package br.com.qualiti.delivery.negocio.excecoes;

public class RegistroJaCadastradoException extends Exception {

	private static final long serialVersionUID = -3797778463520364789L;

	public RegistroJaCadastradoException(String mensagem) {
		super(mensagem);
	}
	
	public RegistroJaCadastradoException() {
		this("Registro já cadastrado !");
	}

	
	
}
