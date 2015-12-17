package com.globalsoft.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Input extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDescProd;
	private JTextField txtUndProd;
	private JTextField txtNotaFiscal;
	private JTextField txtQtdAtual;
	private JTextField txtQtdEntrada;
	private JTextField txtCodFone;
	private JTextField txtNameForn;
	private JTextField txtValueUnit;
	private JTextField txtValueTotal;
	private JTextField txtIPI;
	private JTextField txtCentroCusto;
	private JTextField txtContrato;
	private JTextField txtContato;
	private JTextField txtTel;
	private JTextField txtFax;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input frame = new Input();
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
	public Input() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 53, 738, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 27, 79, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		txtDescProd = new JTextField();
		txtDescProd.setEditable(false);
		txtDescProd.setColumns(10);
		txtDescProd.setBounds(99, 27, 497, 20);
		panel.add(txtDescProd);
		
		txtUndProd = new JTextField();
		txtUndProd.setEditable(false);
		txtUndProd.setColumns(10);
		txtUndProd.setBounds(606, 27, 79, 20);
		panel.add(txtUndProd);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(99, 11, 46, 14);
		panel.add(lblDescrio);
		
		JLabel lblUnd = new JLabel("Unidade");
		lblUnd.setBounds(606, 11, 79, 14);
		panel.add(lblUnd);
		
		JButton btnFindProd = new JButton("");
		btnFindProd.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnFindProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos view = new Produtos();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		btnFindProd.setToolTipText("Buscar Produto");
		btnFindProd.setBounds(695, 19, 28, 28);
		panel.add(btnFindProd);
		
		txtNotaFiscal = new JTextField();
		txtNotaFiscal.setColumns(10);
		txtNotaFiscal.setBounds(10, 74, 122, 20);
		panel.add(txtNotaFiscal);
		
		JLabel lblNNotaFiscal = new JLabel("N\u00BA Nota Fiscal");
		lblNNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNNotaFiscal.setBounds(10, 58, 122, 14);
		panel.add(lblNNotaFiscal);
		
		txtQtdAtual = new JTextField();
		txtQtdAtual.setEditable(false);
		txtQtdAtual.setColumns(10);
		txtQtdAtual.setBounds(10, 116, 122, 20);
		panel.add(txtQtdAtual);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade Atual");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeEmEstoque.setBounds(10, 100, 122, 14);
		panel.add(lblQuantidadeEmEstoque);
		
		txtQtdEntrada = new JTextField();
		txtQtdEntrada.setColumns(10);
		txtQtdEntrada.setBounds(142, 116, 122, 20);
		panel.add(txtQtdEntrada);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(142, 100, 122, 14);
		panel.add(lblQuantidade);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnitrio.setBounds(411, 100, 122, 14);
		panel.add(lblValorUnitrio);
		
		txtValueUnit = new JTextField();
		txtValueUnit.setColumns(10);
		txtValueUnit.setBounds(411, 116, 122, 20);
		panel.add(txtValueUnit);
		
		txtValueTotal = new JTextField();
		txtValueTotal.setColumns(10);
		txtValueTotal.setBounds(543, 116, 180, 20);
		panel.add(txtValueTotal);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorTotal.setBounds(543, 100, 185, 14);
		panel.add(lblValorTotal);
		
		txtIPI = new JTextField();
		txtIPI.setColumns(10);
		txtIPI.setBounds(274, 116, 127, 20);
		panel.add(txtIPI);
		
		JLabel lblIpi = new JLabel("I.P.I.");
		lblIpi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIpi.setBounds(274, 100, 127, 14);
		panel.add(lblIpi);
		
		txtCentroCusto = new JTextField();
		txtCentroCusto.setColumns(10);
		txtCentroCusto.setBounds(142, 74, 122, 20);
		panel.add(txtCentroCusto);
		
		JLabel lblCentroDeCusto = new JLabel("Centro de Custo");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(142, 58, 122, 14);
		panel.add(lblCentroDeCusto);
		
		txtContrato = new JTextField();
		txtContrato.setColumns(10);
		txtContrato.setBounds(274, 74, 449, 20);
		panel.add(txtContrato);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrato.setBounds(274, 58, 449, 14);
		panel.add(lblContrato);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 211, 738, 103);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdFornecedor = new JLabel("C\u00F3d. Fornecedor");
		lblCdFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdFornecedor.setBounds(10, 11, 122, 14);
		panel_1.add(lblCdFornecedor);
		
		txtCodFone = new JTextField();
		txtCodFone.setEditable(false);
		txtCodFone.setBounds(10, 27, 122, 20);
		panel_1.add(txtCodFone);
		txtCodFone.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(142, 11, 122, 14);
		panel_1.add(lblFornecedor);
		
		txtNameForn = new JTextField();
		txtNameForn.setBounds(142, 27, 411, 20);
		panel_1.add(txtNameForn);
		txtNameForn.setEditable(false);
		txtNameForn.setColumns(10);
		
		JButton btnFindForn = new JButton("");
		btnFindForn.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnFindForn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Fornecedores view = new Fornecedores();
				view.setLocationRelativeTo(null);
				view.setVisible(true);	
			}
		});
		btnFindForn.setToolTipText("Buscar Fornecedor");
		btnFindForn.setBounds(696, 64, 28, 28);
		panel_1.add(btnFindForn);
		
		txtContato = new JTextField();
		txtContato.setColumns(10);
		txtContato.setBounds(564, 27, 160, 20);
		panel_1.add(txtContato);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContato.setBounds(564, 11, 127, 14);
		panel_1.add(lblContato);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(10, 72, 148, 20);
		panel_1.add(txtTel);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 56, 148, 14);
		panel_1.add(lblTelefone);
		
		txtFax = new JTextField();
		txtFax.setEditable(false);
		txtFax.setColumns(10);
		txtFax.setBounds(168, 74, 139, 20);
		panel_1.add(txtFax);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFax.setBounds(168, 58, 139, 14);
		panel_1.add(lblFax);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(317, 72, 369, 20);
		panel_1.add(txtEmail);
		
		JLabel lblEmailContato = new JLabel("Email Contato");
		lblEmailContato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmailContato.setBounds(317, 56, 127, 14);
		panel_1.add(lblEmailContato);
		
		JLabel lblEntradaDeProduto = new JLabel("Entrada de Produto");
		lblEntradaDeProduto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEntradaDeProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradaDeProduto.setBounds(10, 11, 735, 44);
		contentPane.add(lblEntradaDeProduto);
		
		JButton btnExit = new JButton("Sair");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btnExit.setBounds(659, 440, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(560, 440, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 440, 89, 23);
		contentPane.add(btnNovo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 325, 738, 103);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 0, 714, 25);
		panel_2.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 714, 66);
		panel_2.add(scrollPane);
		
		JTextPane txtObs = new JTextPane();
		scrollPane.setViewportView(txtObs);
	}
}
