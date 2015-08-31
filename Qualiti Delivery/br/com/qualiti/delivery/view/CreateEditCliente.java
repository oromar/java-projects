/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.qualiti.delivery.view;

import br.com.qualiti.delivery.entidades.Cliente;
import br.com.qualiti.delivery.entidades.Endereco;
import br.com.qualiti.delivery.negocio.Fachada;
import java.awt.Frame;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

/**
 *
 * @author OROMAR
 */
public class CreateEditCliente extends javax.swing.JDialog {

    private boolean editMode = false;
    private Cliente clienteToEdit;

    /**
     * Creates new form CreateEditCliente
     */
    public CreateEditCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public CreateEditCliente(Frame parent, String titulo, Cliente cliente) {
        this(parent, true);
        setTitle("Atualizar Cliente");
        clienteToEdit = cliente;
        btnAddCliente.setText("Salvar");
        editMode = true;
        setDadosTela(clienteToEdit);
    }

    private Cliente getDadosTela() throws Exception {
        String cpf = edtCpfCliente.getText();
        String nome = edtNomeCliente.getText();
        String email = edtEmailCliente.getText();
        String emailAlternativo = edtEmailAlternativo.getText();
        String telefone = edtTelefoneCliente.getText();
        String celular = edtCelularCliente.getText();
        String dataNascimento = edtDataNascimentoCliente.getText();
        String logradouro = edtLogradour.getText();
        String numero = edtNumero.getText();
        String bairro = edtBairro.getText();
        String cep = edtCep.getText();
        String cidade = edtCidade.getText();
        String estado = cmbEstado.getSelectedItem().toString();
        String complemento = edtComplemento.getText();

        Cliente cliente = new Cliente();
        cliente.setCelular(celular);
        cliente.setCpf(cpf);
        cliente.setDateString(dataNascimento);
        cliente.setEmail(email);
        cliente.setEmail2(emailAlternativo);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        Endereco endereco = new Endereco();
        endereco.setCpfCliente(cpf);
        endereco.setLogradouro(logradouro);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        cliente.setEndereco(endereco);
        cliente.validar();
        return cliente;
    }

    private void setDadosTela(Cliente cliente) {
        edtCpfCliente.setText(cliente.getCpf());
        edtNomeCliente.setText(cliente.getNome());
        edtEmailCliente.setText(cliente.getEmail());
        edtEmailAlternativo.setText(cliente.getEmail2());
        edtTelefoneCliente.setText(cliente.getTelefone());
        edtCelularCliente.setText(cliente.getCelular());
        edtDataNascimentoCliente.setText(new SimpleDateFormat("dd/MM/yyyy").format(cliente.getDataNascimento()));
        edtLogradour.setText(cliente.getEndereco().getLogradouro());
        edtNumero.setText(cliente.getEndereco().getNumero());
        edtBairro.setText(cliente.getEndereco().getBairro());
        edtCep.setText(cliente.getEndereco().getCep());
        edtCidade.setText(cliente.getEndereco().getCidade());
        cmbEstado.setSelectedItem(cliente.getEndereco().getEstado());
        edtComplemento.setText(cliente.getEndereco().getComplemento());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField12 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        panel = new javax.swing.JTabbedPane();
        panelDadosPessoais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtCpfCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edtNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edtEmailCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edtTelefoneCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        edtCelularCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edtDataNascimentoCliente = new javax.swing.JTextField();
        edtEmailAlternativo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        panelEndereco = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        edtLogradour = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        edtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        edtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        edtCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        edtCep = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        edtComplemento = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnAddCliente = new javax.swing.JButton();

        jLabel16.setText("Cep:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");

        panel.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Dados Pessoais");

        jLabel2.setText("CPF:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Email:");

        jLabel5.setText("Telefone:");

        jLabel6.setText("Celular:");

        jLabel7.setText("Data de Nascimento (DD/MM/YYYY) :");

        jLabel15.setText("Email Alternativo:");

        javax.swing.GroupLayout panelDadosPessoaisLayout = new javax.swing.GroupLayout(panelDadosPessoais);
        panelDadosPessoais.setLayout(panelDadosPessoaisLayout);
        panelDadosPessoaisLayout.setHorizontalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(edtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(edtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(edtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(edtDataNascimentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(edtEmailAlternativo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(edtCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(edtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDadosPessoaisLayout.setVerticalGroup(
            panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(panelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtDataNascimentoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtEmailAlternativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))
                    .addGroup(panelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panel.addTab("Dados Pessoais", panelDadosPessoais);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Endereço");

        jLabel9.setText("Logradouro:");

        jLabel10.setText("Bairro:");

        jLabel11.setText("Número:");

        jLabel12.setText("Cidade:");

        jLabel13.setText("Estado");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AM", "BA", "ES", "MG", "PE", "PR", "RJ", "SP", " ", " " }));

        jLabel14.setText("Cep:");

        jLabel17.setText("Complemento:");

        javax.swing.GroupLayout panelEnderecoLayout = new javax.swing.GroupLayout(panelEndereco);
        panelEndereco.setLayout(panelEnderecoLayout);
        panelEnderecoLayout.setHorizontalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtComplemento)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(edtLogradour, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addComponent(edtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addComponent(cmbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelEnderecoLayout.setVerticalGroup(
            panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEnderecoLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtLogradour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEnderecoLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEnderecoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panel.addTab("Endereço", panelEndereco);

        btnAddCliente.setText("Add");
        btnAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddCliente)
                .addContainerGap())
        );

        panel.getAccessibleContext().setAccessibleName("Dados Pessoais");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddClienteActionPerformed

        try {
            if (editMode) {
                clienteToEdit = getDadosTela();
                Fachada.getInstancia().atualizarCliente(clienteToEdit);
                JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso !", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Cliente cliente = getDadosTela();
                Fachada.getInstancia().inserirCliente(cliente);
                JOptionPane.showMessageDialog(this, "Registro inserido com sucesso !", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCliente;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JTextField edtBairro;
    private javax.swing.JTextField edtCelularCliente;
    private javax.swing.JTextField edtCep;
    private javax.swing.JTextField edtCidade;
    private javax.swing.JTextField edtComplemento;
    private javax.swing.JTextField edtCpfCliente;
    private javax.swing.JTextField edtDataNascimentoCliente;
    private javax.swing.JTextField edtEmailAlternativo;
    private javax.swing.JTextField edtEmailCliente;
    private javax.swing.JTextField edtLogradour;
    private javax.swing.JTextField edtNomeCliente;
    private javax.swing.JTextField edtNumero;
    private javax.swing.JTextField edtTelefoneCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JPanel panelDadosPessoais;
    private javax.swing.JPanel panelEndereco;
    // End of variables declaration//GEN-END:variables
}
