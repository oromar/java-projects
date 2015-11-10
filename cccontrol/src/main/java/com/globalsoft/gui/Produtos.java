package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Produtos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos frame = new Produtos();
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
	public Produtos() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1318, 706);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNovoProduto = new JMenuItem("Novo Produto");
		mntmNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto tela = new CadastroProduto();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		mnArquivo.add(mntmNovoProduto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 1282, 81);
		contentPane.add(panel);
		
		JButton button = new JButton("");
		button.setBounds(10, 11, 56, 48);
		panel.add(button);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(1207, 11, 65, 48);
		panel.add(button_2);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAtualizar.setBounds(10, 56, 56, 25);
		panel.add(lblAtualizar);
		
		JLabel label_2 = new JLabel("Sair");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(1207, 56, 65, 25);
		panel.add(label_2);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExcluir.setBounds(76, 56, 56, 25);
		panel.add(lblExcluir);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(76, 11, 56, 48);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(228, 27, 393, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblProcurar = new JLabel("Procurar.:");
		lblProcurar.setBounds(163, 27, 65, 25);
		panel.add(lblProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1282, 536);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
