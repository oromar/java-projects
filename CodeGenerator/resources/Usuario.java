package resources;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


@Entity
@Table(name="usuario")
public class Usuario extends EntidadeBasica {

	private static final long serialVersionUID = 8064915889545304157L;
	@Column(name="PASSWORD")
	private String password;
	
	public Usuario(){
		
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return password;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String password) {
		this.password = password;
	}
}
