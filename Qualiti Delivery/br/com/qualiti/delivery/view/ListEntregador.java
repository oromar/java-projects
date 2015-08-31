/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.Entregador;
import br.com.qualiti.delivery.negocio.Fachada;
import br.com.qualiti.delivery.util.Util;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OROMAR
 */
public class ListEntregador extends ListTemplate<Entregador> {

    public ListEntregador(Frame parent, boolean modal) {
        super(parent, modal);
        setTitle("Cadastro de Entregador");
        getLblTitulo().setText("Entregador");
    }

    @Override
    public void edtPesquisarKeyReleasedAction(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisarActionPerformed();
        } else if (getEdtPesquisar().getText().isEmpty()) {
            createTableModel();
        }
    }

    @Override
    public void btnPesquisarActionPerformed() {
        try {
            String valor = getEdtPesquisar().getText();
            Entregador entregador = null;
            if (Util.onlyNumbers(valor)) {
                entregador = new Entregador();
                entregador.setMatricula(valor);
                Collection<Entregador> collecao = Fachada.getInstancia().filtrar(entregador);
                createTable(collecao.toArray(new Entregador[collecao.size()]));
            } else if (valor.matches("[a-zA-Z]{3}-[0-9]{4}")) {
                entregador = new Entregador();
                entregador.setPlacaMoto(valor);
                Collection<Entregador> collecao = Fachada.getInstancia().filtrar(entregador);
                createTable(collecao.toArray(new Entregador[collecao.size()]));
            } else {
                entregador = new Entregador();
                entregador.setNome(valor);
                Collection<Entregador> collecao = Fachada.getInstancia().filtrar(entregador);
                createTable(collecao.toArray(new Entregador[collecao.size()]));
            }
            if (getTabelaDados().getRowCount() > 0) {
                getTabelaDados().addRowSelectionInterval(0, 0);
                getTabelaDados().requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(ListEntregador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void btnNovoActionPerformed() {
        CreateEditEntregador tela = new CreateEditEntregador((Frame) getParent(), true);
        tela.setLocationRelativeTo(getParent());
        tela.setVisible(true);
    }

    @Override
    public void btnExcluirActionPerformed() {
        int index = -1;
        try {
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String matricula = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (!Util.isNullOrEmpty(matricula)) {
                    if (JOptionPane.showConfirmDialog(this, "Tem certeza ?", "Confirma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        String hql = HQL_ENTREGADOR_BY_MATRICULA;
                        Map<String, Object> map = new HashMap<>();
                        map.put("matricula", matricula);
                        Entregador ent = Fachada.getInstancia().findUniqueByHQL(hql, map);
                        Fachada.getInstancia().removerEntregador(ent.getCpf());
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static final String HQL_ENTREGADOR_BY_MATRICULA = "FROM Entregador e WHERE e.matricula = :matricula";

    @Override
    public void btnEditarActionPerformed() {
        int index = -1;
        try {
            index = getTabelaDados().getSelectedRow();
            if (index != -1) {
                String matricula = String.valueOf(getTabelaDados().getValueAt(index, 0));
                if (!Util.isNullOrEmpty(matricula)) {
                    String hql = HQL_ENTREGADOR_BY_MATRICULA;
                    Map<String, Object> map = new HashMap<>();
                    map.put("matricula", matricula);
                    Entregador ent = Fachada.getInstancia().findUniqueByHQL(hql, map);
                    CreateEditEntregador tela = new CreateEditEntregador((Frame) getParent(), "Alterar Entregador", ent);
                    tela.setLocationRelativeTo(null);
                    tela.setVisible(true);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void createTable(Entregador[] array) {

        String[] colunas = {"MATRICULA", "NOME", "PLACA DA MOTO", "CELULAR"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }            
        };

        String[] linha = null;
        for (Entregador entregador : array) {
            linha = new String[4];
            linha[0] = entregador.getMatricula();
            linha[1] = entregador.getNome();
            linha[2] = entregador.getPlacaMoto();
            linha[3] = entregador.getTelefone();
            model.addRow(linha);
        }
        getTabelaDados().setModel(model);
        getTabelaDados().createDefaultColumnsFromModel();
    }

    @Override
    public void createTableModel() {
        try {
            createTable(Fachada.getInstancia().buscarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onWindowGainedFocus() {
        createTableModel();
    }

}
