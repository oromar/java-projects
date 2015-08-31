package resources;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


/*
 * Em : 04/07/2015 - 00:57:54
 * 
 * */

@Entity
@Table(name = "comentario")
public class Comentario extends EntidadeBasica implements Serializable {

	 @Column(name="VERSICULO")
	 private Versiculo versiculo;

	 @Column(name="TEXTO")
	 private String texto;

	 @Column(name="DATA")
	 private java.util.Date data;

	 @Column(name="AUTOR")
	 private String autor;


	
	 public Comentario() {
	 }

	 // métodos getters

	 public Versiculo getVersiculo() { 
		 return this.versiculo;
	 }

	 public String getTexto() { 
		 return this.texto;
	 }

	 public java.util.Date getData() { 
		 return this.data;
	 }

	 public String getAutor() { 
		 return this.autor;
	 }



	 // métodos setters

	 public void setVersiculo(Versiculo versiculo) { 
		 this.versiculo = versiculo; 
	 }

	 public void setTexto(String texto) { 
		 this.texto = texto; 
	 }

	 public void setData(java.util.Date data) { 
		 this.data = data; 
	 }

	 public void setAutor(String autor) { 
		 this.autor = autor; 
	 }


}
