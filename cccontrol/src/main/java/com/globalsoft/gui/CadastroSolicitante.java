package com.globalsoft.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroSolicitante extends JFrame {

	private static final long serialVersionUID = -5862683290614642467L;
	private JPanel contentPane;
	private JTextField Tfcod;
	private JTextField TfDesc;
	private JTextField TfMarca;
	private JTextField TfFabricante;
	private JTextField TfUnidMedida;
	private JTextField tfCor;
	private JTextField tfSerie;
	private JTextField tfReferencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroSolicitante frame = new CadastroSolicitante();
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
	public CadastroSolicitante() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 472, 512);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsalve = new JButton("Salvar");
		btsalve.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btsalve.setIcon(new ImageIcon("Icones\\disk.png"));
		btsalve.setBounds(269, 451, 89, 23);
		contentPane.add(btsalve);
		
		JButton btExit = new JButton("Sair");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btExit.setBounds(368, 451, 89, 23);
		contentPane.add(btExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 67, 447, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCod.setBounds(10, 11, 67, 14);
		panel.add(lblCod);
		
		Tfcod = new JTextField();
		Tfcod.setEditable(false);
		Tfcod.setBounds(10, 26, 67, 20);
		panel.add(Tfcod);
		Tfcod.setColumns(10);
		
		TfDesc = new JTextField();
		TfDesc.setColumns(10);
		TfDesc.setBounds(82, 26, 349, 20);
		panel.add(TfDesc);
		
		JLabel lblDescrio = new JLabel("Nome");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(355, 103, 100, 14);
		panel.add(lblQuantidade);
		
		TfMarca = new JTextField();
		TfMarca.setColumns(10);
		TfMarca.setBounds(10, 72, 131, 20);
		panel.add(TfMarca);
		
		JLabel lblMarca_1 = new JLabel("CPF*");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 100, 14);
		panel.add(lblMarca_1);
		
		TfFabricante = new JTextField();
		TfFabricante.setColumns(10);
		TfFabricante.setBounds(151, 72, 133, 20);
		panel.add(TfFabricante);
		
		JLabel lblFabricante = new JLabel("RG*");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(151, 57, 133, 14);
		panel.add(lblFabricante);
		
		JLabel lblUnidadeDeMedida = new JLabel("Matr\u00EDcula");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(294, 57, 169, 14);
		panel.add(lblUnidadeDeMedida);
		
		TfUnidMedida = new JTextField();
		TfUnidMedida.setColumns(10);
		TfUnidMedida.setBounds(294, 72, 137, 20);
		panel.add(TfUnidMedida);
		
		tfCor = new JTextField();
		tfCor.setColumns(10);
		tfCor.setBounds(10, 164, 100, 20);
		panel.add(tfCor);
		
		JLabel lblCor = new JLabel("Centro de Custo");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 149, 100, 14);
		panel.add(lblCor);
		
		tfSerie = new JTextField();
		tfSerie.setColumns(10);
		tfSerie.setBounds(120, 164, 153, 20);
		panel.add(tfSerie);
		
		JLabel lblSrie = new JLabel("Telefone 1");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(120, 149, 153, 14);
		panel.add(lblSrie);
		
		JLabel lblReferncia = new JLabel("Telefone 2");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(283, 149, 148, 14);
		panel.add(lblReferncia);
		
		tfReferencia = new JTextField();
		tfReferencia.setColumns(10);
		tfReferencia.setBounds(283, 164, 148, 20);
		panel.add(tfReferencia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 118, 218, 20);
		panel.add(comboBox);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSetor.setBounds(10, 103, 218, 14);
		panel.add(lblSetor);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(238, 119, 193, 20);
		panel.add(comboBox_1);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o");
		lblFuno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFuno.setBounds(238, 103, 193, 14);
		panel.add(lblFuno);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 288, 447, 152);
		contentPane.add(panel_2);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblObservaes.setBounds(10, 0, 81, 25);
		panel_2.add(lblObservaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 427, 117);
		panel_2.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 451, 89, 23);
		contentPane.add(btnNovo);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Solicitante");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroProduto.setBounds(10, 11, 447, 45);
		contentPane.add(lblCadastroProduto);
	}
}
