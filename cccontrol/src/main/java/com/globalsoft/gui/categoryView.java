package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class categoryView extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					categoryView frame = new categoryView();
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
	public categoryView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 542);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 411, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnDelete.setBounds(10, 11, 56, 48);
		panel.add(btnDelete);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDelete.setBounds(10, 55, 56, 25);
		panel.add(lblDelete);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("Icones\\1448763830_xfce-system-exit.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(345, 11, 56, 48);
		panel.add(btnExit);
		
		JLabel lblExit = new JLabel("Sair");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExit.setBounds(345, 55, 56, 25);
		panel.add(lblExit);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategoria.setBounds(142, 11, 193, 58);
		panel.add(lblCategoria);
		
		JButton btnSelect = new JButton("");
		btnSelect.setIcon(new ImageIcon("Icones\\Yes.png"));
		btnSelect.setBounds(76, 11, 56, 48);
		panel.add(btnSelect);
		
		JLabel lblSelecionar = new JLabel("Selecionar");
		lblSelecionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecionar.setBounds(76, 55, 56, 25);
		panel.add(lblSelecionar);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(125, 111, 211, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNomeCategoria = new JLabel("Nome Da Categoria");
		lblNomeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeCategoria.setBounds(20, 102, 113, 34);
		contentPane.add(lblNomeCategoria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 411, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setIcon(new ImageIcon("Icones\\add.png"));
		btnAdd.setBounds(346, 102, 73, 29);
		contentPane.add(btnAdd);
	}
}