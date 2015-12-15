package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.Supplier;
import com.globalsoft.util.Util;

public class CadastroFornecedor extends JFrame {

	private static final long serialVersionUID = 6365077286725296898L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtRazaoSocial;
	private JTextField txtConta;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtAgencia;
	private JTextField txtBanco;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtDocumento1;
	private JTextField txtDocumento2;
	private JTextField txtTelefone1;
	private JTextField txtTelefone2;
	private JTextField txtTelefone3;
	private JTextField txtContato;
	private JTextField txtFax;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JButton btnNovo;
	private JButton btnSair;
	private JTextPane txtObsComments;

	public CadastroFornecedor(Supplier supplier) {
		this();
		Util.setScreenData(this, supplier);
	}

	/**
	 * Create the frame.
	 */
	public CadastroFornecedor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier sup = Util.getScreenData(CadastroFornecedor.this, Supplier.class);
				try {
					if (sup.getId() == null) {
						Facade.getInstance().create(sup);
					} else {
						Facade.getInstance().update(sup);
					}
					JOptionPane.showMessageDialog(CadastroFornecedor.this,
							"Registro salvo com sucesso");
					Util.clearScreen(CadastroFornecedor.this);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(CadastroFornecedor.this,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSalvar.setBounds(498, 560, 89, 23);
		contentPane.add(btnSalvar);

		btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon("Icones\\door_in.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(597, 560, 89, 23);
		contentPane.add(btnSair);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 67, 686, 319);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCod.setBounds(10, 11, 67, 14);
		panel.add(lblCod);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(10, 26, 67, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(82, 26, 325, 20);
		panel.add(txtRazaoSocial);

		JLabel lblDescrio = new JLabel("Raz\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);

		JLabel lblMarca = new JLabel("Nome Fantasia/Apelido");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(417, 11, 259, 14);
		panel.add(lblMarca);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(417, 26, 259, 20);
		panel.add(txtNome);

		JLabel lblQuantidade = new JLabel("Cep");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(518, 103, 100, 14);
		panel.add(lblQuantidade);

		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(518, 118, 158, 20);
		panel.add(txtCep);

		txtBanco = new JTextField();
		txtBanco.setColumns(10);
		txtBanco.setBounds(11, 288, 294, 20);
		panel.add(txtBanco);

		JLabel lblLocalizao = new JLabel("Banco");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalizao.setBounds(10, 273, 100, 14);
		panel.add(lblLocalizao);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 72, 326, 20);
		panel.add(txtEndereco);

		JLabel lblMarca_1 = new JLabel("Endere\u00E7o");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 148, 14);
		panel.add(lblMarca_1);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(345, 72, 118, 20);
		panel.add(txtNumero);

		JLabel lblFabricante = new JLabel("N\u00FAmero");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(345, 57, 100, 14);
		panel.add(lblFabricante);

		JLabel lblUnidadeDeMedida = new JLabel("Complemento");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(473, 57, 193, 14);
		panel.add(lblUnidadeDeMedida);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(473, 72, 203, 20);
		panel.add(txtComplemento);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(10, 118, 210, 20);
		panel.add(txtBairro);

		JLabel lblCor = new JLabel("Bairro");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 103, 100, 14);
		panel.add(lblCor);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(230, 118, 210, 20);
		panel.add(txtCidade);

		JLabel lblSrie = new JLabel("Cidade");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(230, 103, 100, 14);
		panel.add(lblSrie);

		JLabel lblReferncia = new JLabel("UF");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(450, 103, 58, 14);
		panel.add(lblReferncia);

		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(450, 118, 58, 20);
		panel.add(txtEstado);

		JLabel lblValorUnd = new JLabel("Conta");
		lblValorUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnd.setBounds(477, 273, 81, 14);
		panel.add(lblValorUnd);

		JLabel lblQtdMaxima = new JLabel("Ag\u00EAncia");
		lblQtdMaxima.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQtdMaxima.setBounds(315, 273, 100, 14);
		panel.add(lblQtdMaxima);

		txtConta = new JTextField();
		txtConta.setBounds(473, 288, 203, 20);
		panel.add(txtConta);
		txtConta.setColumns(10);

		txtAgencia = new JTextField();
		txtAgencia.setBounds(315, 288, 148, 20);
		panel.add(txtAgencia);
		txtAgencia.setColumns(10);

		txtDocumento1 = new JTextField();
		txtDocumento1.setColumns(10);
		txtDocumento1.setBounds(11, 164, 209, 20);
		panel.add(txtDocumento1);

		JLabel lblCnpjcpf = new JLabel("CNPJ/CPF");
		lblCnpjcpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCnpjcpf.setBounds(10, 149, 100, 14);
		panel.add(lblCnpjcpf);

		txtDocumento2 = new JTextField();
		txtDocumento2.setColumns(10);
		txtDocumento2.setBounds(233, 164, 207, 20);
		panel.add(txtDocumento2);

		JLabel lblInscrioEstadualrg = new JLabel(
				"Inscri\u00E7\u00E3o Estadual/RG");
		lblInscrioEstadualrg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInscrioEstadualrg.setBounds(233, 149, 207, 14);
		panel.add(lblInscrioEstadualrg);

		txtTelefone1 = new JTextField();
		txtTelefone1.setColumns(10);
		txtTelefone1.setBounds(10, 210, 148, 20);
		panel.add(txtTelefone1);

		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(11, 195, 81, 14);
		panel.add(lblTelefone);

		txtTelefone2 = new JTextField();
		txtTelefone2.setColumns(10);
		txtTelefone2.setBounds(168, 210, 148, 20);
		panel.add(txtTelefone2);

		JLabel lblTelefone_1 = new JLabel("Telefone 2");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_1.setBounds(169, 195, 81, 14);
		panel.add(lblTelefone_1);

		txtTelefone3 = new JTextField();
		txtTelefone3.setColumns(10);
		txtTelefone3.setBounds(326, 210, 148, 20);
		panel.add(txtTelefone3);

		JLabel lblTelefone_2 = new JLabel("Telefone 3");
		lblTelefone_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_2.setBounds(327, 195, 81, 14);
		panel.add(lblTelefone_2);

		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(450, 164, 226, 20);
		panel.add(txtContato);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContato.setBounds(451, 149, 225, 14);
		panel.add(lblContato);

		txtFax = new JTextField();
		txtFax.setColumns(10);
		txtFax.setBounds(484, 210, 192, 20);
		panel.add(txtFax);

		JLabel lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFax.setBounds(485, 195, 81, 14);
		panel.add(lblFax);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(11, 247, 325, 20);
		panel.add(txtEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 232, 326, 14);
		panel.add(lblEmail);

		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(350, 248, 326, 20);
		panel.add(txtSite);

		JLabel lblSite = new JLabel("Site");
		lblSite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSite.setBounds(350, 232, 326, 14);
		panel.add(lblSite);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 397, 686, 152);
		contentPane.add(panel_2);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblObservaes.setBounds(10, 0, 81, 25);
		panel_2.add(lblObservaes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 666, 117);
		panel_2.add(scrollPane);

		txtObsComments = new JTextPane();
		scrollPane.setViewportView(txtObsComments);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util.clearScreen(CadastroFornecedor.this);
			}
		});
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 560, 89, 23);
		contentPane.add(btnNovo);

		JLabel lblCadastroProduto = new JLabel("Cadastro Fornecedores");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroProduto.setBounds(10, 11, 676, 45);
		contentPane.add(lblCadastroProduto);
	}
}
