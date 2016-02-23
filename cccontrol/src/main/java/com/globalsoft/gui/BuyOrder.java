package com.globalsoft.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.globalsoft.entities.Product;

public class BuyOrder extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtCnpj;
	private JTextField txtIe;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtTelefone;
	private JTextField txtSite;
	private JTextField txtFax;
	private JTextField txtLocalEntrega;
	private JTextField txtNomeSoli;
	private JTextField txtCpfSoli;
	private JTextField txtRgSoli;
	private JTextField txtTelSoli;
	private JTextField txtMatriSoli;
	private JTextField txtCodForn;
	private JTextField txtNomeForn;
	private JTextField txtContatoForn;
	private JTextField txtTelForn;
	private JTextField txtFaxForn;
	private JTextField txtEmailForn;
	private JTextField txtCodProd;
	private JTextField txtNomeProd;
	private JTextField txtUnidMedProd;
	private JTextField txtQtdATProd;
	private JTextField txtQtdProd;
	private JTextField txtUnitValueProd;
	private JTextField txtValueTotalProd;
	private JTextField txtIpiProd;
	private JTextField txtCentroCustoProd;
	private JTextField txtContratoProd;
	private JTextField txtContratoSoli;
	private JTextField txtCentroCustoSoli;
	private JTable table;
	private JTextField txtPrazoEntrega;
	private JTextField txtCondPag;
	private JTextField txtSubTotal;
	private JTextField txtDesconto;
	private JTextField txtIss;
	private JTextField txtFrete;
	private JTextField txtOutros;
	private JTextField txtValueTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyOrder frame = new BuyOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuyOrder() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 764, 742);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmEditarCampos = new JMenuItem("Editar Campos");
		mntmEditarCampos
				.setIcon(new ImageIcon(
						"C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\pencil.png"));
		mnNewMenu.add(mntmEditarCampos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 738, 631);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Dados", null, panel, null);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Faturamento",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25,
						112)));
		panel_3.setBounds(10, 11, 713, 165);
		panel.add(panel_3);

		txtnome = new JTextField();
		txtnome.setText("ENORSUL - Servi\u00E7os em Saneamento Ltda.");
		txtnome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtnome.setColumns(10);
		txtnome.setBounds(10, 38, 357, 20);
		panel_3.add(txtnome);

		JLabel label = new JLabel("CNPJ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(377, 21, 127, 14);
		panel_3.add(label);

		txtCnpj = new JTextField();
		txtCnpj.setText("07.192.861/0005-91");
		txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(377, 37, 178, 20);
		panel_3.add(txtCnpj);

		JLabel label_1 = new JLabel("Nome");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 22, 296, 14);
		panel_3.add(label_1);

		txtIe = new JTextField();
		txtIe.setText("Isento");
		txtIe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtIe.setColumns(10);
		txtIe.setBounds(565, 37, 138, 20);
		panel_3.add(txtIe);

		JLabel label_2 = new JLabel("I.E.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(565, 21, 138, 14);
		panel_3.add(label_2);

		txtEndereco = new JTextField();
		txtEndereco.setText("RUA DOUTOR ARNULFO LINS E SILVA");
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 84, 357, 20);
		panel_3.add(txtEndereco);

		JLabel label_3 = new JLabel("Endere\u00E7o");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 68, 296, 14);
		panel_3.add(label_3);

		txtCidade = new JTextField();
		txtCidade.setText("OLINDA/PE");
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(565, 83, 138, 20);
		panel_3.add(txtCidade);

		JLabel label_4 = new JLabel("Cidade");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(565, 68, 138, 14);
		panel_3.add(label_4);

		txtNumero = new JTextField();
		txtNumero.setText("52 B");
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNumero.setColumns(10);
		txtNumero.setBounds(377, 83, 77, 20);
		panel_3.add(txtNumero);

		JLabel label_5 = new JLabel("N\u00FAmero");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(377, 68, 77, 14);
		panel_3.add(label_5);

		txtBairro = new JTextField();
		txtBairro.setText("Umuarama.");
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		txtBairro.setBounds(464, 84, 91, 20);
		panel_3.add(txtBairro);

		JLabel label_6 = new JLabel("Bairro");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(464, 68, 91, 14);
		panel_3.add(label_6);

		txtTelefone = new JTextField();
		txtTelefone.setText("(81) 3493-8400");
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 131, 167, 20);
		panel_3.add(txtTelefone);

		JLabel label_7 = new JLabel("Telefone");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(10, 115, 167, 14);
		panel_3.add(label_7);

		txtSite = new JTextField();
		txtSite.setText("www.enorsul.com.br");
		txtSite.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSite.setColumns(10);
		txtSite.setBounds(361, 132, 194, 20);
		panel_3.add(txtSite);

		JLabel label_8 = new JLabel("Site");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(361, 116, 194, 14);
		panel_3.add(label_8);

		txtFax = new JTextField();
		txtFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtFax.setColumns(10);
		txtFax.setBounds(187, 131, 164, 20);
		panel_3.add(txtFax);

		JLabel label_9 = new JLabel("Fax");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(187, 115, 116, 14);
		panel_3.add(label_9);

		txtLocalEntrega = new JTextField();
		txtLocalEntrega.setText("O Mesmo");
		txtLocalEntrega.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtLocalEntrega.setColumns(10);
		txtLocalEntrega.setBounds(565, 131, 138, 20);
		panel_3.add(txtLocalEntrega);

		JLabel label_10 = new JLabel("Local de Entrega");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(565, 115, 138, 14);
		panel_3.add(label_10);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Solicitante",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(25, 25,
						112)));
		panel_4.setBounds(10, 187, 713, 121);
		panel.add(panel_4);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solicitantes view = new Solicitantes(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_3.setToolTipText("Buscar Solicitante");
		button_3.setBounds(672, 37, 28, 28);
		panel_4.add(button_3);

		txtNomeSoli = new JTextField();
		txtNomeSoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNomeSoli.setEditable(false);
		txtNomeSoli.setColumns(10);
		txtNomeSoli.setBounds(10, 45, 369, 20);
		panel_4.add(txtNomeSoli);

		JLabel label_11 = new JLabel("Nome");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(10, 29, 384, 14);
		panel_4.add(label_11);

		JLabel label_12 = new JLabel("CPF *");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setBounds(389, 29, 122, 14);
		panel_4.add(label_12);

		txtCpfSoli = new JTextField();
		txtCpfSoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCpfSoli.setEditable(false);
		txtCpfSoli.setColumns(10);
		txtCpfSoli.setBounds(389, 45, 141, 20);
		panel_4.add(txtCpfSoli);

		JLabel label_13 = new JLabel("RG *");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setBounds(540, 29, 122, 14);
		panel_4.add(label_13);

		txtRgSoli = new JTextField();
		txtRgSoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtRgSoli.setEditable(false);
		txtRgSoli.setColumns(10);
		txtRgSoli.setBounds(540, 45, 122, 20);
		panel_4.add(txtRgSoli);

		txtTelSoli = new JTextField();
		txtTelSoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTelSoli.setEditable(false);
		txtTelSoli.setColumns(10);
		txtTelSoli.setBounds(10, 90, 141, 20);
		panel_4.add(txtTelSoli);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 74, 122, 14);
		panel_4.add(lblTelefone);

		txtMatriSoli = new JTextField();
		txtMatriSoli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMatriSoli.setEditable(false);
		txtMatriSoli.setColumns(10);
		txtMatriSoli.setBounds(157, 90, 141, 20);
		panel_4.add(txtMatriSoli);

		JLabel label_15 = new JLabel("Matr\u00EDcula");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_15.setBounds(157, 76, 122, 14);
		panel_4.add(label_15);

		txtContratoSoli = new JTextField();
		txtContratoSoli.setEditable(false);
		txtContratoSoli.setColumns(10);
		txtContratoSoli.setBounds(440, 92, 263, 20);
		panel_4.add(txtContratoSoli);

		txtCentroCustoSoli = new JTextField();
		txtCentroCustoSoli.setEditable(false);
		txtCentroCustoSoli.setColumns(10);
		txtCentroCustoSoli.setBounds(308, 92, 122, 20);
		panel_4.add(txtCentroCustoSoli);

		JLabel label_16 = new JLabel("Centro de Custo");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(308, 76, 122, 14);
		panel_4.add(label_16);

		JLabel label_17 = new JLabel("Contrato");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_17.setBounds(440, 76, 263, 14);
		panel_4.add(label_17);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Dados Fornecedor",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25,
						112)));
		panel_5.setBounds(10, 319, 713, 121);
		panel.add(panel_5);

		JLabel label_14 = new JLabel("C\u00F3d. Fornecedor");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(10, 27, 122, 14);
		panel_5.add(label_14);

		txtCodForn = new JTextField();
		txtCodForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtCodForn.setEditable(false);
		txtCodForn.setColumns(10);
		txtCodForn.setBounds(10, 43, 122, 20);
		panel_5.add(txtCodForn);

		JLabel label_18 = new JLabel("Fornecedor");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_18.setBounds(142, 27, 122, 14);
		panel_5.add(label_18);

		txtNomeForn = new JTextField();
		txtNomeForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtNomeForn.setEditable(false);
		txtNomeForn.setColumns(10);
		txtNomeForn.setBounds(142, 43, 383, 20);
		panel_5.add(txtNomeForn);

		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores view = new Fornecedores(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		button_4.setToolTipText("Buscar Fornecedor");
		button_4.setBounds(667, 80, 28, 28);
		panel_5.add(button_4);

		txtContatoForn = new JTextField();
		txtContatoForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtContatoForn.setColumns(10);
		txtContatoForn.setBounds(535, 43, 160, 20);
		panel_5.add(txtContatoForn);

		JLabel label_19 = new JLabel("Contato");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_19.setBounds(535, 27, 127, 14);
		panel_5.add(label_19);

		txtTelForn = new JTextField();
		txtTelForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTelForn.setEditable(false);
		txtTelForn.setColumns(10);
		txtTelForn.setBounds(10, 88, 148, 20);
		panel_5.add(txtTelForn);

		JLabel label_20 = new JLabel("Telefone");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_20.setBounds(10, 72, 148, 14);
		panel_5.add(label_20);

		txtFaxForn = new JTextField();
		txtFaxForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtFaxForn.setEditable(false);
		txtFaxForn.setColumns(10);
		txtFaxForn.setBounds(168, 88, 139, 20);
		panel_5.add(txtFaxForn);

		JLabel label_21 = new JLabel("Fax");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_21.setBounds(168, 72, 139, 14);
		panel_5.add(label_21);

		txtEmailForn = new JTextField();
		txtEmailForn.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEmailForn.setColumns(10);
		txtEmailForn.setBounds(317, 88, 340, 20);
		panel_5.add(txtEmailForn);

		JLabel label_22 = new JLabel("Email Contato");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_22.setBounds(317, 72, 127, 14);
		panel_5.add(label_22);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(
				EtchedBorder.LOWERED, null, null), "Observa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(25, 25,
						112)));
		panel_6.setBounds(10, 451, 713, 141);
		panel.add(panel_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 687, 104);
		panel_6.add(scrollPane);

		JTextPane txtObs = new JTextPane();
		scrollPane.setViewportView(txtObs);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Produto", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_7.setBounds(10, 11, 713, 147);
		panel_1.add(panel_7);

		txtCodProd = new JTextField();
		txtCodProd.setEditable(false);
		txtCodProd.setColumns(10);
		txtCodProd.setBounds(10, 27, 79, 20);
		panel_7.add(txtCodProd);

		txtNomeProd = new JTextField();
		txtNomeProd.setEditable(false);
		txtNomeProd.setColumns(10);
		txtNomeProd.setBounds(99, 27, 497, 20);
		panel_7.add(txtNomeProd);

		txtUnidMedProd = new JTextField();
		txtUnidMedProd.setEditable(false);
		txtUnidMedProd.setColumns(10);
		txtUnidMedProd.setBounds(606, 27, 97, 20);
		panel_7.add(txtUnidMedProd);

		JLabel label_23 = new JLabel("C\u00F3digo");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_23.setBounds(10, 11, 46, 14);
		panel_7.add(label_23);

		JLabel label_24 = new JLabel("Descri\u00E7\u00E3o");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_24.setBounds(99, 11, 46, 14);
		panel_7.add(label_24);

		JLabel label_25 = new JLabel("Unidade");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_25.setBounds(606, 11, 79, 14);
		panel_7.add(label_25);

		txtQtdATProd = new JTextField();
		txtQtdATProd.setEditable(false);
		txtQtdATProd.setColumns(10);
		txtQtdATProd.setBounds(542, 74, 161, 20);
		panel_7.add(txtQtdATProd);

		JLabel label_27 = new JLabel("Quantidade Atual");
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_27.setBounds(542, 58, 143, 14);
		panel_7.add(label_27);

		txtQtdProd = new JTextField();
		txtQtdProd.setColumns(10);
		txtQtdProd.setBounds(10, 116, 122, 20);
		panel_7.add(txtQtdProd);

		JLabel label_28 = new JLabel("Quantidade");
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_28.setBounds(10, 100, 122, 14);
		panel_7.add(label_28);

		JLabel label_29 = new JLabel("Valor Unit\u00E1rio");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_29.setBounds(279, 100, 122, 14);
		panel_7.add(label_29);

		txtUnitValueProd = new JTextField();
		txtUnitValueProd.setColumns(10);
		txtUnitValueProd.setBounds(279, 116, 122, 20);
		panel_7.add(txtUnitValueProd);

		txtValueTotalProd = new JTextField();
		txtValueTotalProd.setColumns(10);
		txtValueTotalProd.setBounds(411, 116, 142, 20);
		panel_7.add(txtValueTotalProd);

		JLabel label_30 = new JLabel("Valor Total");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_30.setBounds(411, 100, 142, 14);
		panel_7.add(label_30);

		txtIpiProd = new JTextField();
		txtIpiProd.setColumns(10);
		txtIpiProd.setBounds(142, 116, 127, 20);
		panel_7.add(txtIpiProd);

		JLabel label_31 = new JLabel("I.P.I.");
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_31.setBounds(142, 100, 127, 14);
		panel_7.add(label_31);

		txtCentroCustoProd = new JTextField();
		txtCentroCustoProd.setColumns(10);
		txtCentroCustoProd.setBounds(10, 74, 122, 20);
		panel_7.add(txtCentroCustoProd);

		JLabel label_32 = new JLabel("Centro de Custo");
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_32.setBounds(10, 58, 122, 14);
		panel_7.add(label_32);

		txtContratoProd = new JTextField();
		txtContratoProd.setColumns(10);
		txtContratoProd.setBounds(142, 74, 390, 20);
		panel_7.add(txtContratoProd);

		JLabel label_33 = new JLabel("Contrato");
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_33.setBounds(142, 58, 337, 14);
		panel_7.add(label_33);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(606, 108, 97, 28);
		panel_7.add(btnAdd);
		btnAdd.setIcon(new ImageIcon("Icones\\accept.png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setToolTipText("Add Produto");

		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button_6.setToolTipText("Buscar Produto");
		button_6.setBounds(563, 108, 33, 28);
		panel_7.add(button_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 165, 713, 427);
		panel_1.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Total", null, panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_8.setBounds(10, 11, 713, 108);
		panel_2.add(panel_8);

		txtPrazoEntrega = new JTextField();
		txtPrazoEntrega.setText("30 Dias");
		txtPrazoEntrega.setColumns(10);
		txtPrazoEntrega.setBounds(10, 74, 143, 20);
		panel_8.add(txtPrazoEntrega);

		JLabel lblPrazoDeEntrega = new JLabel("Prazo de Entrega");
		lblPrazoDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrazoDeEntrega.setBounds(10, 58, 143, 14);
		panel_8.add(lblPrazoDeEntrega);

		txtCondPag = new JTextField();
		txtCondPag.setText("IMEDIATO");
		txtCondPag.setColumns(10);
		txtCondPag.setBounds(163, 74, 143, 20);
		panel_8.add(txtCondPag);

		JLabel lblCondPagamento = new JLabel("Cond. Pagamento");
		lblCondPagamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCondPagamento.setBounds(163, 58, 122, 14);
		panel_8.add(lblCondPagamento);

		txtSubTotal = new JTextField();
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(10, 27, 122, 20);
		panel_8.add(txtSubTotal);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSubtotal.setBounds(10, 11, 143, 14);
		panel_8.add(lblSubtotal);

		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(142, 27, 102, 20);
		panel_8.add(txtDesconto);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesconto.setBounds(142, 11, 102, 14);
		panel_8.add(lblDesconto);

		txtIss = new JTextField();
		txtIss.setColumns(10);
		txtIss.setBounds(254, 27, 54, 20);
		panel_8.add(txtIss);

		JLabel lblIss = new JLabel("ISS");
		lblIss.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIss.setBounds(254, 11, 54, 14);
		panel_8.add(lblIss);

		txtFrete = new JTextField();
		txtFrete.setColumns(10);
		txtFrete.setBounds(380, 27, 99, 20);
		panel_8.add(txtFrete);

		JLabel lblFrete = new JLabel("Frete");
		lblFrete.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblFrete.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFrete.setBounds(316, 11, 163, 14);
		panel_8.add(lblFrete);

		txtOutros = new JTextField();
		txtOutros.setColumns(10);
		txtOutros.setBounds(489, 27, 82, 20);
		panel_8.add(txtOutros);

		JLabel lblOutros = new JLabel("Outros");
		lblOutros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOutros.setBounds(489, 11, 82, 14);
		panel_8.add(lblOutros);

		txtValueTotal = new JTextField();
		txtValueTotal.setColumns(10);
		txtValueTotal.setBounds(581, 27, 122, 20);
		panel_8.add(txtValueTotal);

		JLabel lblTotalGeral = new JLabel("TOTAL GERAL");
		lblTotalGeral.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTotalGeral.setBounds(581, 11, 122, 14);
		panel_8.add(lblTotalGeral);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "CIF", "FOB" }));
		comboBox.setBounds(316, 27, 54, 20);
		panel_8.add(comboBox);

		JButton button = new JButton("Novo");
		button.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(10, 653, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon("Icones\\disk.png"));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_1.setBounds(560, 653, 89, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Sair");
		button_2.setIcon(new ImageIcon("Icones\\door_in.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_2.setBounds(659, 653, 89, 23);
		contentPane.add(button_2);
	}
}
