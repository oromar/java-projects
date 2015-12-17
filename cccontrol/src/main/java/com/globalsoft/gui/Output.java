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

import com.globalsoft.entities.Product;

public class Output extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodProd;
	private JTextField txtDescProd;
	private JTextField txtUnidProd;
	private JTextField txtQtdEstoque;
	private JTextField txtQtdSaida;
	private JTextField txtRequisitante;
	private JTextField txtDepartamento;
	private JTextField txtCentroCusto;
	private JTextField txtContrato;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtTel;
	private JTextField txtMatricula;
	private JTextField txtAutorizacao;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Output frame = new Output();
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
	public Output() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 771, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 53, 738, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCodProd = new JTextField();
		txtCodProd.setEditable(false);
		txtCodProd.setBounds(10, 27, 79, 20);
		panel.add(txtCodProd);
		txtCodProd.setColumns(10);
		
		txtDescProd = new JTextField();
		txtDescProd.setEditable(false);
		txtDescProd.setColumns(10);
		txtDescProd.setBounds(99, 27, 460, 20);
		panel.add(txtDescProd);
		
		txtUnidProd = new JTextField();
		txtUnidProd.setEditable(false);
		txtUnidProd.setColumns(10);
		txtUnidProd.setBounds(569, 27, 116, 20);
		panel.add(txtUnidProd);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(99, 11, 46, 14);
		panel.add(lblDescrio);
		
		JLabel lblUnd = new JLabel("Unidade");
		lblUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnd.setBounds(569, 11, 79, 14);
		panel.add(lblUnd);
		
		JButton btnBuscaProd = new JButton("");
		btnBuscaProd.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnBuscaProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos view = new Produtos(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);
				Product p = view.getSelecionado();
			}
		});
		btnBuscaProd.setToolTipText("Buscar Produto");
		btnBuscaProd.setBounds(695, 19, 28, 28);
		panel.add(btnBuscaProd);
		
		txtQtdEstoque = new JTextField();
		txtQtdEstoque.setEditable(false);
		txtQtdEstoque.setColumns(10);
		txtQtdEstoque.setBounds(10, 74, 122, 20);
		panel.add(txtQtdEstoque);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade Atual");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeEmEstoque.setBounds(10, 58, 122, 14);
		panel.add(lblQuantidadeEmEstoque);
		
		txtQtdSaida = new JTextField();
		txtQtdSaida.setColumns(10);
		txtQtdSaida.setBounds(142, 74, 122, 20);
		panel.add(txtQtdSaida);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(142, 58, 122, 14);
		panel.add(lblQuantidade);
		
		txtCentroCusto = new JTextField();
		txtCentroCusto.setBounds(274, 74, 122, 20);
		panel.add(txtCentroCusto);
		txtCentroCusto.setColumns(10);
		
		JLabel lblCentroDeCusto_1 = new JLabel("Centro de Custo");
		lblCentroDeCusto_1.setBounds(274, 58, 122, 14);
		panel.add(lblCentroDeCusto_1);
		lblCentroDeCusto_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(406, 74, 137, 20);
		panel.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(406, 58, 122, 14);
		panel.add(lblDepartamento);
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtContrato = new JTextField();
		txtContrato.setBounds(553, 74, 170, 20);
		panel.add(txtContrato);
		txtContrato.setColumns(10);
		
		JLabel lblContrato_1 = new JLabel("Contrato");
		lblContrato_1.setBounds(553, 58, 170, 14);
		panel.add(lblContrato_1);
		lblContrato_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 167, 738, 103);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBuscaSolicitante = new JButton("");
		btnBuscaSolicitante.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnBuscaSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Solicitantes view = new Solicitantes();
      			view.setLocationRelativeTo(null);
				view.setVisible(true);
				
			}
		});
		btnBuscaSolicitante.setToolTipText("Buscar Fornecedor");
		btnBuscaSolicitante.setBounds(700, 64, 28, 28);
		panel_1.add(btnBuscaSolicitante);
		
		txtRequisitante = new JTextField();
		txtRequisitante.setEditable(false);
		txtRequisitante.setBounds(10, 27, 435, 20);
		panel_1.add(txtRequisitante);
		txtRequisitante.setColumns(10);
		
		JLabel lblContrato = new JLabel("Requisitante");
		lblContrato.setBounds(10, 11, 449, 14);
		panel_1.add(lblContrato);
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(455, 11, 122, 14);
		panel_1.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(455, 27, 141, 20);
		panel_1.add(txtCpf);
		
		JLabel lblRg = new JLabel("RG *");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(606, 11, 122, 14);
		panel_1.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setColumns(10);
		txtRg.setBounds(606, 27, 122, 20);
		panel_1.add(txtRg);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(10, 72, 141, 20);
		panel_1.add(txtTel);
		
		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 56, 122, 14);
		panel_1.add(lblTelefone);
		
		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(157, 72, 141, 20);
		panel_1.add(txtMatricula);
		
		JLabel lblTelefone_1 = new JLabel("Matr\u00EDcula");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_1.setBounds(157, 58, 122, 14);
		panel_1.add(lblTelefone_1);
		
		txtAutorizacao = new JTextField();
		txtAutorizacao.setColumns(10);
		txtAutorizacao.setBounds(308, 72, 151, 20);
		panel_1.add(txtAutorizacao);
		
		JLabel lblAutorizaosupervisor = new JLabel("Autoriza\u00E7\u00E3o/Supervisor");
		lblAutorizaosupervisor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAutorizaosupervisor.setBounds(308, 56, 122, 14);
		panel_1.add(lblAutorizaosupervisor);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(465, 72, 225, 20);
		panel_1.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(465, 56, 225, 14);
		panel_1.add(lblEmail);
		
		JLabel lblEntradaDeProduto = new JLabel("Saida Produto");
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
		btnExit.setBounds(659, 395, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(560, 395, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 395, 89, 23);
		contentPane.add(btnNovo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 281, 738, 103);
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
