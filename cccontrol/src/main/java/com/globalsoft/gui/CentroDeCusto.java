package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CentroDeCusto extends JFrame {

	private static final long serialVersionUID = 7167351565071980283L;
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtContrato;
	private JTable table;
	private JTextField txtGestorContrato;

	public CentroDeCusto(boolean isSelectFrame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 120, 166, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtContrato = new JTextField();
		txtContrato.setColumns(10);
		txtContrato.setBounds(201, 120, 179, 20);
		contentPane.add(txtContrato);
		
		JLabel lblCentroDeCusto = new JLabel("N\u00BA Centro de Custo");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(10, 102, 166, 20);
		contentPane.add(lblCentroDeCusto);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrato.setBounds(201, 102, 179, 20);
		contentPane.add(lblContrato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 370, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtGestorContrato = new JTextField();
		txtGestorContrato.setColumns(10);
		txtGestorContrato.setBounds(10, 169, 166, 20);
		contentPane.add(txtGestorContrato);
		
		JLabel lblGestorContrato = new JLabel("Gestor do Contrato");
		lblGestorContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGestorContrato.setBounds(10, 148, 166, 20);
		contentPane.add(lblGestorContrato);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(8, 11, 372, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.setIcon(new ImageIcon("\\Icones\\11425_32x32.png"));
		btnAtualizar.setBounds(10, 11, 56, 48);
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("\\Icones\\Delete.png"));
		btnExcluir.setBounds(76, 11, 56, 48);
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon("\\Icones\\1448763830_xfce-system-exit.png"));
		btnSair.setBounds(306, 11, 56, 48);
		panel.add(btnSair);
		
		JButton btnSelecionar = new JButton("");
		btnSelecionar.setIcon(new ImageIcon("\\Icones\\Yes.png"));
		btnSelecionar.setBounds(142, 11, 56, 48);
		btnSelecionar.setVisible(isSelectFrame);
		panel.add(btnSelecionar);
		
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
		lblSelecionar.setVisible(isSelectFrame);
		panel.add(lblSelecionar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(306, 55, 56, 25);
		panel.add(lblSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
