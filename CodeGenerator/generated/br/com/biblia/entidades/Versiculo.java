package resources;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


/*
 * Em : 04/07/2015 - 00:59:56
 * 
 * */

@Entity
@Table(name = "versiculo")
public class Versiculo extends EntidadeBasica implements Serializable {

	 @Column(name="VERSAO")
	 private Versao versao;

	 @Column(name="LIVRO")
	 private Livro livro;

	 @Column(name="CAPITULO")
	 private Integer capitulo;

	 @Column(name="VERSICULO")
	 private Integer versiculo;

	 @Column(name="TEXTO")
	 private String texto;


	
	 public Versiculo() {
	 }

	 // métodos getters

	 public Versao getVersao() { 
		 return this.versao;
	 }

	 public Livro getLivro() { 
		 return this.livro;
	 }

	 public Integer getCapitulo() { 
		 return this.capitulo;
	 }

	 public Integer getVersiculo() { 
		 return this.versiculo;
	 }

	 public String getTexto() { 
		 return this.texto;
	 }



	 // métodos setters

	 public void setVersao(Versao versao) { 
		 this.versao = versao; 
	 }

	 public void setLivro(Livro livro) { 
		 this.livro = livro; 
	 }

	 public void setCapitulo(Integer capitulo) { 
		 this.capitulo = capitulo; 
	 }

	 public void setVersiculo(Integer versiculo) { 
		 this.versiculo = versiculo; 
	 }

	 public void setTexto(String texto) { 
		 this.texto = texto; 
	 }


}
