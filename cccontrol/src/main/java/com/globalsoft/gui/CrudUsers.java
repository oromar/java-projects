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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CrudUsers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

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
		setBounds(100, 100, 787, 531);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mnArquivo.add(mntmPesquisar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 746, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\8440_32x32.png"));
		btnNew.setBounds(10, 11, 57, 50);
		panel.add(btnNew);
		
		JButton BtnExcluir = new JButton("");
		BtnExcluir.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\Delete.png"));
		BtnExcluir.setBounds(144, 11, 57, 50);
		panel.add(BtnExcluir);
		
		JLabel lblNovo = new JLabel("Novo");
		lblNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovo.setBounds(10, 58, 57, 25);
		panel.add(lblNovo);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setBounds(144, 58, 57, 25);
		panel.add(lblExcluir);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\exit.png"));
		button.setBounds(679, 11, 57, 50);
		panel.add(button);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setBounds(679, 58, 57, 25);
		panel.add(lblSair);
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setBounds(77, 58, 57, 25);
		panel.add(lblSalvar);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\8439_32x32.png"));
		button_1.setBounds(77, 11, 57, 50);
		panel.add(button_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dados Cadastrais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(10, 105, 746, 93);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(130, 24, 236, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 55, 236, 20);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(499, 24, 236, 20);
		panel_1.add(textField_2);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 27, 119, 14);
		panel_1.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 58, 119, 14);
		panel_1.add(lblCpf);
		
		JLabel lblDataDeNascimento = new JLabel("Data De Nascimento");
		lblDataDeNascimento.setBounds(379, 27, 119, 14);
		panel_1.add(lblDataDeNascimento);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(379, 58, 119, 14);
		panel_1.add(lblSenha);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(499, 55, 236, 20);
		panel_1.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(10, 209, 746, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
