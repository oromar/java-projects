package resources;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


/*
 * Em : 04/07/2015 - 00:58:30
 * 
 * */

@Entity
@Table(name = "introducao")
public class Introducao extends EntidadeBasica implements Serializable {

	 @Column(name="LIVRO")
	 private Livro livro;

	 @Column(name="TEXTO")
	 private String texto;


	
	 public Introducao() {
	 }

	 // métodos getters

	 public Livro getLivro() { 
		 return this.livro;
	 }

	 public String getTexto() { 
		 return this.texto;
	 }



	 // métodos setters

	 public void setLivro(Livro livro) { 
		 this.livro = livro; 
	 }

	 public void setTexto(String texto) { 
		 this.texto = texto; 
	 }


}
