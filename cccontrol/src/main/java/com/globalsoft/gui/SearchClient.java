package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class SearchClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchClient frame = new SearchClient();
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
	public SearchClient() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 867, 560);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPesquisaAvanada = new JMenuItem("Pesquisa Avan\u00E7ada");
		mnNewMenu.add(mntmPesquisaAvanada);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mnNewMenu.add(mntmSair);
		
		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(552, 11, 226, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnExit = new JButton("");
		btnExit.setBounds(76, 11, 56, 48);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\LUPA_22x22.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(778, 11, 44, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setBounds(10, 76, 831, 413);  
        contentPane.add(scrollPane);  
          
        //Criando a JTable tabela e adicionando no JScrollPane  
        JTable tabela = new JTable();  
        scrollPane.setViewportView(tabela);  
		tabela.setModel(new DefaultTableModel(new Object[][]{{"elias barreto", "10577990411", "corte"},},

		 new String[] { "Nome", "CPF", "Ação" }));
		
		JButton btnSave = new JButton("");
		btnSave.setBounds(10, 11, 56, 48);
		contentPane.add(btnSave);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setBounds(10, 58, 56, 14);
		contentPane.add(lblSalvar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(76, 58, 56, 14);
		contentPane.add(lblSair);
		
		
		
	}
}
