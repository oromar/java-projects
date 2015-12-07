package com.globalsoft.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

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
import javax.swing.table.DefaultTableModel;

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

	private User getScreenData() {
		User result = new User();
		try {
			result.setCpf(txtCpf.getText());
			result.setName(txtUserName.getText());
			result.setLogin(result.getName());		
			result.setPassword(String.valueOf(txtPassword.getPassword()));	
			if (txtBornDate.getText() != null && !txtBornDate.getText().isEmpty())
				result.setBornDate(new SimpleDateFormat("dd/MM/yyyy").parse(txtBornDate.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
			if (user.getBornDate() != null) {
				txtBornDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(user.getBornDate()));
			}
		}		
	}

	private void createTableModel(User[] users) {

		String[] columnNames = {"User Name", "Login", "Role"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0){
			private static final long serialVersionUID = -6314077983354763441L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (users != null && users.length > 0){
			String[] line = null;
			for (User u : users) {
				line = new String[3];
				line[0] = u.getName();
				line[1] = u.getLogin();
				line[2] = "";
				model.addRow(line);
			}
		}
		usersTable.setModel(model);
		usersTable.createDefaultColumnsFromModel();
	}

	private void clearScreen(){
		txtBornDate.setText("");
		txtPassword.setText("");
		txtConfirmPassword.setText("");
		txtUserName.setText("");
		txtCpf.setText("");
		txtLogin.setText("");
		txtPhone.setText("");	
	}

	/**
	 * Create the frame.
	 */
	public CrudUsers() {
		setTitle("Cadastro de Usu\u00E1rios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				clearScreen();		
			}
		});
		btnNew.setIcon(new ImageIcon("Icones\\8440_32x32.png"));
		btnNew.setBounds(10, 11, 57, 50);
		panel.add(btnNew);

		JButton btnRemove = new JButton("");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = txtLogin.getText();
				User u = new User();
				u.setLogin(login);
				Optional<User> result = Facade.getInstance().filter(u).stream().findFirst();
				if (result.isPresent()){
					if (JOptionPane.showConfirmDialog(CrudUsers.this, "Tem certeza ?") == JOptionPane.YES_OPTION){
						try {
							Facade.getInstance().remove(result.get().getId());
							createTableModel(Facade.getInstance().findAllUsers());
							clearScreen();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(CrudUsers.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
					}					
				}
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
					createTableModel(Facade.getInstance().findAllUsers());
					clearScreen();
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
		usersTable.setDragEnabled(false);
		usersTable.setAutoCreateColumnsFromModel(false);
		usersTable.setAutoCreateRowSorter(true);
		usersTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = usersTable.getSelectedRow();
				if (index > -1) {
					String login = String.valueOf(usersTable.getValueAt(index, 1));
					User u = new User();
					u.setLogin(login);
					Optional<User> result = Facade.getInstance().filter(u).stream().findFirst();
					if (result.isPresent()) {
						setScreenData(result.get());
					}
				}
			}
		});
		scrollPane.setViewportView(usersTable);
		try {
			createTableModel(Facade.getInstance().findAllUsers());
		} catch (Exception e1) {			
			JOptionPane.showMessageDialog(CrudUsers.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
