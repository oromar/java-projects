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
import javax.swing.JMenuBar;
import javax.swing.JMenu;

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
		setBounds(100, 100, 631, 493);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
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
		txtContrato.setBounds(221, 120, 179, 20);
		contentPane.add(txtContrato);
		
		JLabel lblCentroDeCusto = new JLabel("N\u00BA Centro de Custo");
		lblCentroDeCusto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(10, 102, 166, 20);
		contentPane.add(lblCentroDeCusto);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrato.setBounds(221, 102, 179, 20);
		contentPane.add(lblContrato);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 605, 281);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtGestorContrato = new JTextField();
		txtGestorContrato.setColumns(10);
		txtGestorContrato.setBounds(449, 120, 166, 20);
		contentPane.add(txtGestorContrato);
		
		JLabel lblGestorContrato = new JLabel("Gestor do Contrato");
		lblGestorContrato.setHorizontalAlignment(SwingConstants.LEFT);
		lblGestorContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGestorContrato.setBounds(449, 99, 166, 20);
		contentPane.add(lblGestorContrato);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(8, 11, 607, 80);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizar.setIcon(new ImageIcon("Icones\\8439_32x32.png"));
		btnAtualizar.setBounds(10, 11, 56, 48);
		panel.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setIcon(new ImageIcon("Icones\\11425_32x32.png"));
		btnExcluir.setBounds(76, 11, 56, 48);
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon("Icones\\1448763830_xfce-system-exit.png"));
		btnSair.setBounds(541, 11, 56, 48);
		panel.add(btnSair);
		
		JButton btnSelecionar = new JButton("");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSelecionar.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnSelecionar.setBounds(142, 11, 56, 48);
		btnSelecionar.setVisible(isSelectFrame);
		panel.add(btnSelecionar);
		
		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setBounds(76, 55, 56, 25);
		panel.add(lblAtualizar);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setBounds(142, 55, 56, 25);
		panel.add(lblExcluir);
		
		JLabel lblSelecionar = new JLabel("Selecionar");
		lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionar.setBounds(208, 55, 56, 25);
		lblSelecionar.setVisible(isSelectFrame);
		panel.add(lblSelecionar);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setBounds(541, 55, 56, 25);
		panel.add(lblSair);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("Icones\\Yes.png"));
		button.setBounds(208, 11, 56, 48);
		panel.add(button);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalvar.setBounds(10, 55, 56, 25);
		panel.add(lblSalvar);
		
		JLabel lblCentroDeCusto_1 = new JLabel("Centro De Custo");
		lblCentroDeCusto_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroDeCusto_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCentroDeCusto_1.setBounds(274, 0, 257, 80);
		panel.add(lblCentroDeCusto_1);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
