package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mntmFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrudUsers tela = new CrudUsers();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				
			}
		});
		mnArquivo.add(mntmFuncionrios);
		
		JMenu mnMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(mnMovimentao);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 1342, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btProduto = new JButton("");
		btProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Produtos r = new Produtos();
				r.setLocationRelativeTo(null);
				r.setVisible(true);
			}

			
		});
		btProduto.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\1448763544_deliverables.png"));
		btProduto.setBounds(10, 11, 56, 48);
		panel.add(btProduto);
		
		JButton btRelatorio = new JButton("");
		btRelatorio.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\280_32x32.png"));
		btRelatorio.setBounds(1201, 11, 56, 48);
		panel.add(btRelatorio);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\1448763830_xfce-system-exit.png"));
		button_3.setBounds(1267, 11, 65, 48);
		panel.add(button_3);
		
		JLabel lblNovoCadastro = new JLabel("Produtos");
		lblNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCadastro.setBounds(10, 56, 56, 25);
		panel.add(lblNovoCadastro);
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRelatrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrio.setBounds(1201, 56, 56, 25);
		panel.add(lblRelatrio);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(1267, 56, 65, 25);
		panel.add(lblSair);
		
		JLabel lblClientes = new JLabel("Solicitantes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblClientes.setBounds(340, 56, 56, 25);
		panel.add(lblClientes);
		
		JButton btCliente = new JButton("");
		btCliente.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\User group.png"));
		btCliente.setBounds(340, 11, 56, 48);
		panel.add(btCliente);
		
		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedores.setBounds(86, 56, 86, 25);
		panel.add(lblFornecedores);
		
		JButton btfornecedor = new JButton("");
		btfornecedor.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\1448763387_Supervisor.png"));
		btfornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores view = new Fornecedores();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		btfornecedor.setBounds(101, 11, 56, 48);
		panel.add(btfornecedor);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEntrada.setBounds(182, 56, 56, 25);
		panel.add(lblEntrada);
		
		JButton btEntrada = new JButton("");
		btEntrada.setToolTipText("Entrada de Materiais");
		btEntrada.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\Down.png"));
		btEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Input view = new Input();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		btEntrada.setBounds(182, 11, 56, 48);
		panel.add(btEntrada);
		
		JLabel lblSaida = new JLabel("Saida");
		lblSaida.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSaida.setBounds(263, 56, 56, 25);
		panel.add(lblSaida);
		
		JButton btSaida = new JButton("");
		btSaida.setToolTipText("Saida de Materiais");
		btSaida.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\Raise.png"));
		btSaida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Output view = new Output();
				view.setLocationRelativeTo(null);
				view.setVisible(true);

			}
		});
		btSaida.setBounds(263, 11, 56, 48);
		panel.add(btSaida);
		
		JLabel lblOcompra = new JLabel("Ordem De Compra");
		lblOcompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcompra.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOcompra.setBounds(399, 56, 109, 25);
		panel.add(lblOcompra);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(425, 11, 56, 48);
		panel.add(button);
	}
}