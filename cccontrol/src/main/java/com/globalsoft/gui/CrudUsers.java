package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CrudUsers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudUsers frame = new CrudUsers();
					
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrudUsers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 526, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNew = new JButton("");
		btnNew.setBounds(10, 11, 57, 50);
		panel.add(btnNew);
		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.setBounds(77, 11, 57, 50);
		panel.add(btnPesquisa);
		
		JButton BtnEditar = new JButton("");
		BtnEditar.setBounds(144, 11, 57, 50);
		panel.add(BtnEditar);
		
		JButton BtnExcluir = new JButton("");
		BtnExcluir.setBounds(459, 11, 57, 50);
		panel.add(BtnExcluir);
		
		JLabel lblNovo = new JLabel("Novo");
		lblNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovo.setBounds(10, 58, 57, 25);
		panel.add(lblNovo);
		
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setBounds(77, 58, 57, 25);
		panel.add(lblEditar);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisar.setBounds(144, 58, 57, 25);
		panel.add(lblPesquisar);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setBounds(459, 58, 57, 25);
		panel.add(lblExcluir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Dados Cadastrais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(10, 105, 526, 157);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(130, 24, 386, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 55, 386, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 86, 386, 20);
		panel_1.add(textField_2);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 27, 119, 14);
		panel_1.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 58, 119, 14);
		panel_1.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data De Nascimento");
		lblDataDeNascimento.setBounds(10, 89, 119, 14);
		panel_1.add(lblDataDeNascimento);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 120, 119, 14);
		panel_1.add(lblSenha);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 117, 386, 20);
		panel_1.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 273, 526, 330);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("");
		button.setBounds(10, 614, 57, 50);
		contentPane.add(button);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(10, 663, 57, 25);
		contentPane.add(lblSair);
	}
}
