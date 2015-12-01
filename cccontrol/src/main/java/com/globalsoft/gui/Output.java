package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Output extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_11;
	private JTextField textField_8;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_3;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;

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
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 27, 79, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(99, 27, 460, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(569, 27, 116, 20);
		panel.add(textField_2);
		
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
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\zoom.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos view = new Produtos();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		button.setToolTipText("Buscar Produto");
		button.setBounds(695, 19, 28, 28);
		panel.add(button);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(10, 74, 122, 20);
		panel.add(textField_4);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade Atual");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeEmEstoque.setBounds(10, 58, 122, 14);
		panel.add(lblQuantidadeEmEstoque);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(142, 74, 122, 20);
		panel.add(textField_5);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(142, 58, 122, 14);
		panel.add(lblQuantidade);
		
		textField_6 = new JTextField();
		textField_6.setBounds(274, 74, 122, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCentroDeCusto_1 = new JLabel("Centro de Custo");
		lblCentroDeCusto_1.setBounds(274, 58, 122, 14);
		panel.add(lblCentroDeCusto_1);
		lblCentroDeCusto_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_8 = new JTextField();
		textField_8.setBounds(406, 74, 137, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(406, 58, 122, 14);
		panel.add(lblDepartamento);
		lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		textField_7 = new JTextField();
		textField_7.setBounds(553, 74, 170, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblContrato_1 = new JLabel("Contrato");
		lblContrato_1.setBounds(553, 58, 170, 14);
		panel.add(lblContrato_1);
		lblContrato_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 167, 738, 103);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\zoom.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setToolTipText("Buscar Fornecedor");
		button_3.setBounds(700, 64, 28, 28);
		panel_1.add(button_3);
		
		textField_11 = new JTextField();
		textField_11.setBounds(10, 27, 435, 20);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblContrato = new JLabel("Requisitante");
		lblContrato.setBounds(10, 11, 449, 14);
		panel_1.add(lblContrato);
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(455, 11, 122, 14);
		panel_1.add(lblCpf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(455, 27, 141, 20);
		panel_1.add(textField_3);
		
		JLabel lblRg = new JLabel("RG *");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(606, 11, 122, 14);
		panel_1.add(lblRg);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(606, 27, 122, 20);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(10, 72, 141, 20);
		panel_1.add(textField_10);
		
		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 56, 122, 14);
		panel_1.add(lblTelefone);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(157, 72, 141, 20);
		panel_1.add(textField_12);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_1.setBounds(157, 58, 122, 14);
		panel_1.add(lblTelefone_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(308, 72, 151, 20);
		panel_1.add(textField_13);
		
		JLabel lblAutorizaosupervisor = new JLabel("Autoriza\u00E7\u00E3o/Supervisor");
		lblAutorizaosupervisor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAutorizaosupervisor.setBounds(308, 56, 122, 14);
		panel_1.add(lblAutorizaosupervisor);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(465, 72, 225, 20);
		panel_1.add(textField_14);
		
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
		btnExit.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\door_in.png"));
		btnExit.setBounds(659, 395, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\page_save.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(560, 395, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\page_white_horizontal.png"));
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
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
	}
}
