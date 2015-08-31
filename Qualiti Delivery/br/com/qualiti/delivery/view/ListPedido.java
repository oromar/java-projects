/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.entidades.Pedido;
import br.com.qualiti.delivery.negocio.Fachada;
import br.com.qualiti.delivery.util.Util;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ListPedido extends ListTemplate<Pedido> {

    public ListPedido(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Cadastro de Pedidos");
        getLblTitulo().setText("Pedidos");
        setLocationRelativeTo(parent);
    }

    @Override
    public void edtPesquisarKeyReleasedAction(KeyEvent evt) {
        if (getEdtPesquisar().getText().isEmpty()) {
            createTableModel();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           btnPesquisarActionPerformed();
       }
    }

    @Override
    public void btnPesquisarActionPerformed() {
         String texto = getEdtPesquisar().getText();
        try {
            if (texto.isEmpty()) {
                 createTableModel();
            } else {
                if (texto.matches("[0-9]+")) {
                    Pedido p = Fachada.getInstancia().procurarPedido(Integer.valueOf(texto));
                    if (p != null) {
                        Pedido[] array = new Pedido[]{p};
                        createTable(array);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void btnNovoActionPerformed() {
       try {
            String cpf = Util.getCodigoComoString("Novo Pedido", "Digite o CPF do cliente:");
            if (cpf != null && !cpf.isEmpty()) {
                Cliente cliente = Fachada.getInstancia().procurarCliente(cpf);
                if (cliente != null) {
                    CreateEditPedido tela = new CreateEditPedido(null, true, cliente, null);
                    tela.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Cliente não encontrado !", "Cliente não encontrado", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public void btnExcluirActionPerformed() {
        int index = -1;
        index = getTabelaDados().getSelectedRow();
        if (index != -1) {
            try {
                String codigo = getTabelaDados().getValueAt(index, 0).toString();
                Integer i = Integer.valueOf(codigo);
                Pedido p = Fachada.getInstancia().procurarPedido(i);
                if (p != null) {
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Confirma exclusão ?")){
                        Fachada.getInstancia().removerPedido(i);
                        JOptionPane.showMessageDialog(this, "Pedido removido com sucesso !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Pedido não encontrado !");
                }
            } catch (Exception ex) {
                Logger.getLogger(ListPedido.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }               
    }

    @Override
    public void btnEditarActionPerformed() {
          int index = -1;
        index = getTabelaDados().getSelectedRow();
        if (index != -1) {
            try {
                String codigo = getTabelaDados().getValueAt(index, 0).toString();
                Pedido p = Fachada.getInstancia().procurarPedido(Integer.valueOf(codigo));
                if (p != null) {
                   CreateEditPedido tela = new CreateEditPedido(null, true, p.getCliente(), p);
                   tela.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Pedido não encontrado !");
                }
            } catch (Exception ex) {
                Logger.getLogger(ListPedido.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 
    }

    @Override
    public void onWindowGainedFocus() {
        try {
            createTableModel();
        } catch (Exception ex) {
            Logger.getLogger(ListPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createTable(Pedido[] array) {
        String[] colunas = {"CODIGO", "NOME DO CLIENTE", "DATA DO PEDIDO"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }            
        };
        String[] linha = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (array != null) {
            for (Pedido p : array){
                linha = new String[3];
                linha[0] = p.getCodigo().toString();
                linha[1] = p.getCliente().getNome();
                linha[2] = df.format(p.getDataPedido());
                model.addRow(linha);               
            }
            getTabelaDados().setModel(model);
            getTabelaDados().createDefaultColumnsFromModel();
         }
    }

    @Override
    public void createTableModel() {
        Pedido[] array = null;
        try {
            array = Fachada.getInstancia().buscarTodosPedidos();
        } catch (Exception ex) {
            Logger.getLogger(ListPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        createTable(array);        
    }

}
