package resources;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 *
 * Em : DATA_CRIACAO_ARQUIVO
 * 
 * */


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class EntidadeBasica implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	@Column
	private String nome;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInsercao;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRemocao;
	@Column
	private Boolean removido;
	@OneToOne
	private Usuario usuarioInclusao;
	@OneToOne
	private Usuario usuarioAlteracao;
	@OneToOne
	private Usuario usuarioExclusao;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the dataInsercao
	 */
	public Date getDataInsercao() {
		return dataInsercao;
	}

	/**
	 * @return the dataAlteracao
	 */
	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	/**
	 * @return the dataRemocao
	 */
	public Date getDataRemocao() {
		return dataRemocao;
	}

	/**
	 * @return the removido
	 */
	public Boolean getRemovido() {
		return removido;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param dataInsercao the dataInsercao to set
	 */
	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	/**
	 * @param dataAlteracao the dataAlteracao to set
	 */
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	/**
	 * @param dataRemocao the dataRemocao to set
	 */
	public void setDataRemocao(Date dataRemocao) {
		this.dataRemocao = dataRemocao;
	}

	/**
	 * @param removido the removido to set
	 */
	public void setRemovido(Boolean removido) {
		this.removido = removido;
	}

	/**
	 * @return the usuarioInclusao
	 */
	public Usuario getUsuarioInclusao() {
		return usuarioInclusao;
	}

	/**
	 * @return the usuarioAlteracao
	 */
	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	/**
	 * @return the usuarioExclusao
	 */
	public Usuario getUsuarioExclusao() {
		return usuarioExclusao;
	}

	/**
	 * @param usuarioInclusao the usuarioInclusao to set
	 */
	public void setUsuarioInclusao(Usuario usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	/**
	 * @param usuarioAlteracao the usuarioAlteracao to set
	 */
	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	/**
	 * @param usuarioExclusao the usuarioExclusao to set
	 */
	public void setUsuarioExclusao(Usuario usuarioExclusao) {
		this.usuarioExclusao = usuarioExclusao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EntidadeBasica)) {
			return false;
		}
		EntidadeBasica other = (EntidadeBasica) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
