/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.FormaPagamento;
import br.com.qualiti.delivery.negocio.Fachada;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OROMAR
 */
public class ListFormaPagamento extends ListTemplate<FormaPagamento> {

    public ListFormaPagamento(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Cadastro de Forma de Pagamento");
        getLblTitulo().setText("Forma de Pagamento");
    }

    @Override
    public void edtPesquisarKeyReleasedAction(KeyEvent evt) {

        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            btnPesquisarActionPerformed();
        } else if (getEdtPesquisar().getText().isEmpty() && getTabelaDados().getRowCount() > 0) {
            getTabelaDados().removeRowSelectionInterval(0, 0);
            createTableModel();
        }
    }

    @Override
    public void btnPesquisarActionPerformed() {
        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setNome(getEdtPesquisar().getText());
        Collection<FormaPagamento> collection = Fachada.getInstancia().filtrar(formaPagamento);
        FormaPagamento[] array = collection.toArray(new FormaPagamento[collection.size()]);
        createTable(array);
        if (getTabelaDados().getRowCount() > 0) {
            getTabelaDados().addRowSelectionInterval(0, 0);
            getTabelaDados().requestFocus();
        }
    }

    @Override
    public void btnNovoActionPerformed() {
        CreateEditFormaPagamento criarFormaPagamentoView = new CreateEditFormaPagamento((Frame) getParent(), true);
        criarFormaPagamentoView.setLocationRelativeTo(getParent());
        criarFormaPagamentoView.setVisible(true);
    }

    @Override
    public void btnExcluirActionPerformed() {
        int index = -1;
        try {
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String codigoString = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (codigoString != null && !codigoString.isEmpty()) {
                    Integer codigo = Integer.parseInt(codigoString);
                    if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(rootPane, "Tem certeza ?", "Confirma", JOptionPane.YES_NO_OPTION)) {
                        Fachada.getInstancia().removerFormaPagamento(codigo);
                        createTableModel();
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void btnEditarActionPerformed() {
        int index = -1;
        try {
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String codigoString = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (codigoString != null && !codigoString.isEmpty()) {
                    Integer codigo = Integer.parseInt(codigoString);
                    FormaPagamento formaPagamento = new FormaPagamento();
                    formaPagamento.setCodigo(codigo);
                    formaPagamento.setNome(String.valueOf(getTabelaDados().getValueAt(index, 1)));
                    CreateEditFormaPagamento telaEditar = new CreateEditFormaPagamento(null, "Editar Forma de Pagamento", formaPagamento, true);
                    telaEditar.setVisible(true);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onWindowGainedFocus() {
        createTableModel();
    }

    @Override
    public void createTable(FormaPagamento[] array) {

        String[] colunas = {"Código", "Nome"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] linha = null;
        for (FormaPagamento f : array) {
            linha = new String[2];
            linha[0] = String.valueOf(f.getCodigo());
            linha[1] = f.getNome();
            model.addRow(linha);
        }
        getTabelaDados().setModel(model);
        getTabelaDados().createDefaultColumnsFromModel();

    }

    @Override
    public void createTableModel() {
        try {
            FormaPagamento[] array = Fachada.getInstancia().buscarTodasFormasPagamento();
            createTable(array);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
