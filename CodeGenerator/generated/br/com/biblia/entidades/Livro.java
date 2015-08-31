package resources;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;


/*
 * Em : 04/07/2015 - 00:56:17
 * 
 * */

@Entity
@Table(name = "livro")
public class Livro extends EntidadeBasica implements Serializable {

	 @Column(name="TESTAMENTO")
	 private Testamento testamento;

	 @Column(name="POSICAO")
	 private Integer posicao;


	
	 public Livro() {
	 }

	 // métodos getters

	 public Testamento getTestamento() { 
		 return this.testamento;
	 }

	 public Integer getPosicao() { 
		 return this.posicao;
	 }



	 // métodos setters

	 public void setTestamento(Testamento testamento) { 
		 this.testamento = testamento; 
	 }

	 public void setPosicao(Integer posicao) { 
		 this.posicao = posicao; 
	 }


}
