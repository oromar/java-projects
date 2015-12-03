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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.User;
import com.globalsoft.util.Util;

public class CrudUsers extends JFrame {

	private static final long serialVersionUID = 4130940600959307176L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtCpf;
	private JTextField txtBornDate;
	private JTable usersTable;
	private JTextField txtLogin;
	private JTextField txtPhone;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudUsers frame = new CrudUsers();
					Facade.getInstance();

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private User getScreenData() {
		User result = new User();
		result.setCpf(txtCpf.getText());
		result.setName(txtUserName.getText());
		result.setLogin(result.getName());
		result.setPassword(String.valueOf(txtPassword.getPassword()));		
		return result;		
	}

	private void setScreenData(User user){
		if (user != null) {
			if (!Util.isNullOrEmpty(user.getName())) {
				txtUserName.setText(user.getName());
			}
			if (!Util.isNullOrEmpty(user.getCpf())){
				txtCpf.setText(user.getCpf());
			}			
		}		
	}

	/**
	 * Create the frame.
	 */
	public CrudUsers() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 581);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mnArquivo.add(mntmPesquisar);

		JMenuItem menuItemExit = new JMenuItem("Sair");
		menuItemExit.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mnArquivo.add(menuItemExit);

		JMenu mnHelp = new JMenu("Ajuda");
		menuBar.add(mnHelp);
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
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBornDate.setText("");
				txtConfirmPassword.setText("");
				txtUserName.setText("");
				txtCpf.setText("");
				txtLogin.setText("");
				txtPhone.setText("");				
			}
		});
		btnNew.setIcon(new ImageIcon("Icones\\8440_32x32.png"));
		btnNew.setBounds(10, 11, 57, 50);
		panel.add(btnNew);

		JButton btnRemove = new JButton("");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnRemove.setBounds(144, 11, 57, 50);
		panel.add(btnRemove);

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

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("Icones\\exit.png"));
		btnExit.setBounds(679, 11, 57, 50);
		panel.add(btnExit);

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

		JButton btnSave = new JButton("");
		btnSave.setIcon(new ImageIcon("Icones\\8439_32x32.png"));
		btnSave.setBounds(77, 11, 57, 50);
		panel.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Facade.getInstance().create(getScreenData());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(CrudUsers.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}				
			}
		});
				
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dados Cadastrais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(10, 105, 746, 154);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtUserName = new JTextField();
		txtUserName.setBounds(130, 24, 236, 20);
		panel_1.add(txtUserName);
		txtUserName.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(130, 55, 236, 20);
		panel_1.add(txtCpf);

		txtBornDate = new JTextField();
		txtBornDate.setColumns(10);
		txtBornDate.setBounds(499, 24, 236, 20);
		panel_1.add(txtBornDate);

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
		lblSenha.setBounds(379, 89, 119, 17);
		panel_1.add(lblSenha);

		JLabel lblPer = new JLabel("Tipo Usu\u00E1rio");
		lblPer.setBounds(10, 118, 119, 26);
		panel_1.add(lblPer);

		JComboBox cmbUserRole = new JComboBox();
		cmbUserRole.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "Usu\u00E1rio-Financeiro", "Usu\u00E1rio-Estoque"}));
		cmbUserRole.setBounds(130, 121, 236, 20);
		panel_1.add(cmbUserRole);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(376, 58, 119, 14);
		panel_1.add(lblTelefone);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 83, 46, 14);
		panel_1.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(130, 86, 238, 20);
		panel_1.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(379, 123, 119, 17);
		panel_1.add(lblConfirmarSenha);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(499, 55, 236, 20);
		panel_1.add(txtPhone);
		txtPhone.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(499, 87, 236, 20);
		panel_1.add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setBounds(499, 117, 236, 20);
		panel_1.add(txtConfirmPassword);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(10, 270, 746, 240);
		contentPane.add(scrollPane);

		usersTable = new JTable();
		scrollPane.setViewportView(usersTable);
	}
}
