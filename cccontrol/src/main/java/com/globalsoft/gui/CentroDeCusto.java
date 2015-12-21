package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class CentroDeCusto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;

	public CentroDeCusto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 398, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 120, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 120, 179, 20);
		contentPane.add(textField_1);
		
		JLabel lblCentroDeCusto = new JLabel("N\u00BA Centro de Custo");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(10, 102, 166, 20);
		contentPane.add(lblCentroDeCusto);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrato.setBounds(201, 102, 179, 20);
		contentPane.add(lblContrato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 370, 346);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 169, 166, 20);
		contentPane.add(textField_2);
		
		JLabel lblGestorContrato = new JLabel("Gestor do Contrato");
		lblGestorContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGestorContrato.setBounds(10, 148, 166, 20);
		contentPane.add(lblGestorContrato);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(8, 11, 372, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\11425_32x32.png"));
		button_1.setBounds(10, 11, 56, 48);
		panel.add(button_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\Delete.png"));
		button.setBounds(76, 11, 56, 48);
		panel.add(button);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\1448763830_xfce-system-exit.png"));
		button_2.setBounds(306, 11, 56, 48);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\Yes.png"));
		button_3.setBounds(142, 11, 56, 48);
		panel.add(button_3);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setBounds(10, 55, 56, 25);
		panel.add(lblAtualizar);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setBounds(76, 55, 56, 25);
		panel.add(lblExcluir);
		
		JLabel lblSelecionar = new JLabel("Selecionar");
		lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionar.setBounds(142, 55, 56, 25);
		panel.add(lblSelecionar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(306, 55, 56, 25);
		panel.add(lblSair);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
