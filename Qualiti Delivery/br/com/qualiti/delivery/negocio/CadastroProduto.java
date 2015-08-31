/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.negocio;

import br.com.qualiti.delivery.entidades.Produto;
import br.com.qualiti.delivery.interfaces.RepositorioHibernate;

/**
 *
 * @author OROMAR
 */
public class CadastroProduto extends CadastroGenerico<Produto>{

    public CadastroProduto(RepositorioHibernate<Produto> repositorio) {
        super(repositorio);
    }
    
}
