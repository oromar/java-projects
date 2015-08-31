/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.Produto;
import br.com.qualiti.delivery.negocio.Fachada;
import br.com.qualiti.delivery.util.Util;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OROMAR
 */
public class ListProduto extends ListTemplate<Produto> {

    public ListProduto(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Cadastro de Produto");
        getLblTitulo().setText("Produto");
    }

    @Override
    public void edtPesquisarKeyReleasedAction(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisarActionPerformed();
        } else if (getEdtPesquisar().getText().isEmpty() && getTabelaDados().getRowCount() > 0) {
            getTabelaDados().removeRowSelectionInterval(0, 0);
            createTableModel();
        }
    }

    @Override
    public void btnPesquisarActionPerformed() {
        Produto p = new Produto();
        p.setNome(getEdtPesquisar().getText());
        Collection<Produto> collection = Fachada.getInstancia().filtrar(p);
        createTable(collection.toArray(new Produto[collection.size()]));
        if (getTabelaDados().getRowCount() > 0) {
            getTabelaDados().addRowSelectionInterval(0, 0);
            getTabelaDados().requestFocus();
        }
    }

    @Override
    public void btnNovoActionPerformed() {
        CreateEditProduto tela = new CreateEditProduto((Frame) getParent(), true);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    @Override
    public void btnExcluirActionPerformed() {
          try {
            int index = -1;
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String codigoString = String.valueOf(getTabelaDados().getValueAt(index, 0));
                Integer i = Integer.parseInt(codigoString);
                if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Tem certeza ?", "Confirma exclusão", JOptionPane.YES_NO_OPTION)){
                    Fachada.getInstancia().remover(i);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void btnEditarActionPerformed() {
        try {
            int index = -1;
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                Produto p = new Produto();
                p.setCodigo(Integer.parseInt(String.valueOf(getTabelaDados().getValueAt(index, 0))));
                p.setNome(String.valueOf(getTabelaDados().getValueAt(index, 1)));
                p.setPrecoUnitario(Double.parseDouble(String.valueOf(getTabelaDados().getValueAt(index, 2))));
                Object obj = getTabelaDados().getValueAt(index, 3);
                if (obj != null && !String.valueOf(obj).trim().isEmpty()) {
                    p.setDataValidade(Util.getStringAsDate(String.valueOf(obj)));
                }
                CreateEditProduto tela = new CreateEditProduto(null, "Editar Produto", p);
                tela.setLocationRelativeTo(null);
                tela.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onWindowGainedFocus() {
        createTableModel();
    }

    @Override
    public void createTable(Produto[] array) {
        String[] colunas = {"Código", "Nome", "Preço Unitário", "Data de Validade"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] linha = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Produto p : array) {
            linha = new String[4];
            linha[0] = String.valueOf(p.getCodigo());
            linha[1] = p.getNome();
            linha[2] = String.valueOf(p.getPrecoUnitario());
            linha[3] = p.getDataValidade() != null ? df.format(p.getDataValidade()) : "";
            model.addRow(linha);
        }
        getTabelaDados().setModel(model);
        getTabelaDados().createDefaultColumnsFromModel();
    }

    @Override
    public void createTableModel() {
         try {
            Produto[] array = Fachada.getInstancia().buscarTodosProdutos();
            createTable(array);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
