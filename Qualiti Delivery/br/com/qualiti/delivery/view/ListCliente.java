/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.negocio.Fachada;
import br.com.qualiti.delivery.util.Util;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OROMAR
 */
public class ListCliente extends ListTemplate<Cliente> {

    public ListCliente(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Cadastro de Cliente");
        getLblTitulo().setText("Cliente");
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
        try {
            Cliente cliente = null;

            Collection<Cliente> colecao = null;

            String valor = getEdtPesquisar().getText();

            if (Util.onlyNumbers(valor)) {
                cliente = Fachada.getInstancia().procurarCliente(valor);
                if (!Objects.isNull(cliente)) {
                    Cliente[] array = new Cliente[1];
                    array[0] = cliente;
                    createTable(array);
                }
            } else if (valor.contains("@")) {
                cliente = new Cliente();
                cliente.setEmail(valor);
                colecao = Fachada.getInstancia().filtrarClientes(cliente);
                createTable(colecao.toArray(new Cliente[colecao.size()]));

            } else {
                cliente = new Cliente();
                cliente.setNome(valor);
                colecao = Fachada.getInstancia().filtrarClientes(cliente);
                createTable(colecao.toArray(new Cliente[colecao.size()]));
            }

            if (getTabelaDados().getRowCount() > 0) {
                getTabelaDados().addRowSelectionInterval(0, 0);
                getTabelaDados().requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(ListCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void btnNovoActionPerformed() {
        CreateEditCliente createEditCliente = new CreateEditCliente((Frame) getParent(), true);
        createEditCliente.setLocationRelativeTo(getParent());
        createEditCliente.setVisible(true);
    }

    @Override
    public void btnExcluirActionPerformed() {
        try {
            int index = -1;
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String cpfCliente = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (cpfCliente != null && !cpfCliente.isEmpty()) {
                    if (JOptionPane.YES_OPTION == JOptionPane
                            .showConfirmDialog(this, "Tem certeza ?", "Confirma",
                                    JOptionPane.YES_NO_OPTION)) {
                        Fachada.getInstancia().removerCliente(cpfCliente);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void btnEditarActionPerformed() {
        try {
            int index = -1;
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String cpfCliente = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (cpfCliente != null && !cpfCliente.isEmpty()) {
                    Cliente cliente = Fachada.getInstancia().procurarCliente(cpfCliente);
                    CreateEditCliente telaEditarCliente = new CreateEditCliente(null, "Atualizar Cliente", cliente);
                    telaEditarCliente.setVisible(true);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onWindowGainedFocus() {
        createTableModel();
    }

    @Override
    public void createTable(Cliente[] array) {
        String[] colunas = {"CPF", "NOME", "EMAIL", "TELEFONE", "CELULAR"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] linha = null;
        for (Cliente cliente : array) {
            linha = new String[5];
            linha[0] = cliente.getCpf();
            linha[1] = cliente.getNome();
            linha[2] = cliente.getEmail();
            linha[3] = cliente.getTelefone();
            linha[4] = cliente.getCelular();
            model.addRow(linha);
        }

        getTabelaDados().setModel(model);
        getTabelaDados().createDefaultColumnsFromModel();

    }

    @Override
    public void createTableModel() {
        try {
            Cliente[] array = Fachada.getInstancia().buscarTodosClientes();
            createTable(array);
        } catch (Exception ex) {
            Logger.getLogger(ListCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
