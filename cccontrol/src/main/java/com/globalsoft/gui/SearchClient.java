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
		setBounds(100, 100, 1299, 675);
		
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
		
		JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setBounds(10, 103, 1263, 501);  
        contentPane.add(scrollPane);  
          
        //Criando a JTable tabela e adicionando no JScrollPane  
        JTable tabela = new JTable();  
        scrollPane.setViewportView(tabela);  
		tabela.setModel(new DefaultTableModel(new Object[][]{{"elias barreto", "10577990411", "corte"},},

		 new String[] { "Nome", "CPF", "Ação" }));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 1263, 81);
		contentPane.add(panel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterClient tela = new RegisterClient();
				tela.setLocationRelativeTo(null); 
				tela.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(10, 11, 56, 48);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(85, 11, 56, 48);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(1197, 11, 56, 48);
		panel.add(button_2);
		
		JLabel lblNegrciar = new JLabel("Neg\u00F3rciar");
		lblNegrciar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNegrciar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNegrciar.setBounds(10, 56, 56, 25);
		panel.add(lblNegrciar);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAtualizar.setBounds(85, 56, 56, 25);
		panel.add(lblAtualizar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setBounds(1197, 56, 56, 25);
		panel.add(lblSair);
		
		JLabel label_3 = new JLabel("Sair");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(1267, 56, 65, 25);
		panel.add(label_3);
		
		
		
	}
}
