package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastroFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField Tfcod;
	private JTextField TfDesc;
	private JTextField tfValUnid;
	private JTextField TfNotaFiscal;
	private JTextField tfEstoqMin;
	private JTextField tfEstoqMax;
	private JTextField tfLoca;
	private JTextField TfMarca;
	private JTextField TfFabricante;
	private JTextField TfUnidMedida;
	private JTextField tfCor;
	private JTextField tfSerie;
	private JTextField tfReferencia;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFornecedor frame = new CadastroFornecedor();
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
	public CadastroFornecedor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsalve = new JButton("Salvar");
		btsalve.setIcon(new ImageIcon("Icones\\page_save.png"));
		btsalve.setBounds(498, 560, 89, 23);
		contentPane.add(btsalve);
		
		JButton btExit = new JButton("Sair");
		btExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setBounds(597, 560, 89, 23);
		contentPane.add(btExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 67, 686, 319);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCod.setBounds(10, 11, 67, 14);
		panel.add(lblCod);
		
		Tfcod = new JTextField();
		Tfcod.setEditable(false);
		Tfcod.setBounds(10, 26, 67, 20);
		panel.add(Tfcod);
		Tfcod.setColumns(10);
		
		TfDesc = new JTextField();
		TfDesc.setColumns(10);
		TfDesc.setBounds(82, 26, 325, 20);
		panel.add(TfDesc);
		
		JLabel lblDescrio = new JLabel("Raz\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);
		
		JLabel lblMarca = new JLabel("Nome Fantasia/Apelido");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(417, 11, 259, 14);
		panel.add(lblMarca);
		
		TfNotaFiscal = new JTextField();
		TfNotaFiscal.setColumns(10);
		TfNotaFiscal.setBounds(417, 26, 259, 20);
		panel.add(TfNotaFiscal);
		
		JLabel lblQuantidade = new JLabel("Cep");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(518, 103, 100, 14);
		panel.add(lblQuantidade);
		
		tfEstoqMin = new JTextField();
		tfEstoqMin.setColumns(10);
		tfEstoqMin.setBounds(518, 118, 158, 20);
		panel.add(tfEstoqMin);
		
		tfLoca = new JTextField();
		tfLoca.setColumns(10);
		tfLoca.setBounds(11, 288, 294, 20);
		panel.add(tfLoca);
		
		JLabel lblLocalizao = new JLabel("Banco");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalizao.setBounds(10, 273, 100, 14);
		panel.add(lblLocalizao);
		
		TfMarca = new JTextField();
		TfMarca.setColumns(10);
		TfMarca.setBounds(10, 72, 326, 20);
		panel.add(TfMarca);
		
		JLabel lblMarca_1 = new JLabel("Endere\u00E7o");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 148, 14);
		panel.add(lblMarca_1);
		
		TfFabricante = new JTextField();
		TfFabricante.setColumns(10);
		TfFabricante.setBounds(345, 72, 118, 20);
		panel.add(TfFabricante);
		
		JLabel lblFabricante = new JLabel("N\u00FAmero");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(345, 57, 100, 14);
		panel.add(lblFabricante);
		
		JLabel lblUnidadeDeMedida = new JLabel("Complemento");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(473, 57, 193, 14);
		panel.add(lblUnidadeDeMedida);
		
		TfUnidMedida = new JTextField();
		TfUnidMedida.setColumns(10);
		TfUnidMedida.setBounds(473, 72, 203, 20);
		panel.add(TfUnidMedida);
		
		tfCor = new JTextField();
		tfCor.setColumns(10);
		tfCor.setBounds(10, 118, 210, 20);
		panel.add(tfCor);
		
		JLabel lblCor = new JLabel("Bairro");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 103, 100, 14);
		panel.add(lblCor);
		
		tfSerie = new JTextField();
		tfSerie.setColumns(10);
		tfSerie.setBounds(230, 118, 210, 20);
		panel.add(tfSerie);
		
		JLabel lblSrie = new JLabel("Cidade");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(230, 103, 100, 14);
		panel.add(lblSrie);
		
		JLabel lblReferncia = new JLabel("UF");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(450, 103, 58, 14);
		panel.add(lblReferncia);
		
		tfReferencia = new JTextField();
		tfReferencia.setColumns(10);
		tfReferencia.setBounds(450, 118, 58, 20);
		panel.add(tfReferencia);
		
		JLabel lblValorUnd = new JLabel("Conta");
		lblValorUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnd.setBounds(477, 273, 81, 14);
		panel.add(lblValorUnd);
		
		JLabel lblQtdMaxima = new JLabel("Ag\u00EAncia");
		lblQtdMaxima.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQtdMaxima.setBounds(315, 273, 100, 14);
		panel.add(lblQtdMaxima);
		
		tfValUnid = new JTextField();
		tfValUnid.setBounds(473, 288, 203, 20);
		panel.add(tfValUnid);
		tfValUnid.setColumns(10);
		
		tfEstoqMax = new JTextField();
		tfEstoqMax.setBounds(315, 288, 148, 20);
		panel.add(tfEstoqMax);
		tfEstoqMax.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(11, 164, 209, 20);
		panel.add(textField);
		
		JLabel lblCnpjcpf = new JLabel("CNPJ/CPF");
		lblCnpjcpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCnpjcpf.setBounds(10, 149, 100, 14);
		panel.add(lblCnpjcpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(233, 164, 207, 20);
		panel.add(textField_1);
		
		JLabel lblInscrioEstadualrg = new JLabel("Inscri\u00E7\u00E3o Estadual/RG");
		lblInscrioEstadualrg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInscrioEstadualrg.setBounds(233, 149, 207, 14);
		panel.add(lblInscrioEstadualrg);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 210, 148, 20);
		panel.add(textField_2);
		
		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(11, 195, 81, 14);
		panel.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(168, 210, 148, 20);
		panel.add(textField_3);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_1.setBounds(169, 195, 81, 14);
		panel.add(lblTelefone_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(326, 210, 148, 20);
		panel.add(textField_4);
		
		JLabel lblTelefone_2 = new JLabel("Telefone 3");
		lblTelefone_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_2.setBounds(327, 195, 81, 14);
		panel.add(lblTelefone_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(450, 164, 226, 20);
		panel.add(textField_5);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContato.setBounds(451, 149, 225, 14);
		panel.add(lblContato);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(484, 210, 192, 20);
		panel.add(textField_6);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFax.setBounds(485, 195, 81, 14);
		panel.add(lblFax);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(11, 247, 325, 20);
		panel.add(textField_7);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(10, 232, 326, 14);
		panel.add(lblEmail);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(350, 248, 326, 20);
		panel.add(textField_8);
		
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
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnNovo = new JButton("Novo");
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
