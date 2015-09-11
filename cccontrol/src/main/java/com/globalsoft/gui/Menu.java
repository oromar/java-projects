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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchClient r = new SearchClient();
				r.setLocationRelativeTo(null);
				//this.setVisible(false); 
				r.setVisible(true);
			}

			
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\8440_32x32.png"));
		btnNewButton.setBounds(10, 11, 56, 48);
		panel.add(btnNewButton);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\280_32x32.png"));
		button_2.setBounds(76, 11, 56, 48);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\exit.png"));
		button_3.setBounds(1267, 11, 65, 48);
		panel.add(button_3);
		
		JLabel lblNovoCadastro = new JLabel("Novo");
		lblNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovoCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoCadastro.setBounds(10, 56, 56, 25);
		panel.add(lblNovoCadastro);
		
		JLabel lblRelatrio = new JLabel("Relat\u00F3rio");
		lblRelatrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRelatrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrio.setBounds(76, 56, 56, 25);
		panel.add(lblRelatrio);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(1267, 56, 65, 25);
		panel.add(lblSair);
	}
}
