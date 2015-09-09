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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RegisterClient extends JFrame {

	private JPanel contentPane;
	private JTextField tfNameClient;
	private JTextField tfCpfClient;
	private JTextField tfMatriClient;
	private JTextField tfGerClient;
	private JTextField tfValorNego;
	private JTextField tfValorEntra;
	private JTextField tfQuatParc;
	private JTextField tfValParcela;
	private JTextField tfRealizado1;
	private JTextField tfRealizado2;
	private JTextField tdDataPag;
	private JTextField tfAcao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterClient frame = new RegisterClient();
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
	public RegisterClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 573);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnNewMenu.add(mntmSair);
		
		JMenu mnNewMenu_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 73, 830, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfNameClient = new JTextField();
		tfNameClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfNameClient.setBounds(166, 11, 233, 20);
		panel.add(tfNameClient);
		tfNameClient.setColumns(10);
		
		tfCpfClient = new JTextField();
		tfCpfClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfCpfClient.setColumns(10);
		tfCpfClient.setBounds(572, 11, 233, 20);
		panel.add(tfCpfClient);
		
		tfMatriClient = new JTextField();
		tfMatriClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfMatriClient.setColumns(10);
		tfMatriClient.setBounds(166, 41, 233, 20);
		panel.add(tfMatriClient);
		
		tfGerClient = new JTextField();
		tfGerClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfGerClient.setColumns(10);
		tfGerClient.setBounds(572, 41, 233, 20);
		panel.add(tfGerClient);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 13, 122, 17);
		panel.add(lblNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCpfcnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpfcnpj.setBounds(425, 13, 122, 17);
		panel.add(lblCpfcnpj);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
		lblMatrcula.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMatrcula.setBounds(10, 41, 122, 20);
		panel.add(lblMatrcula);
		
		JLabel lblGerncia = new JLabel("GER\u00CANCIA");
		lblGerncia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGerncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGerncia.setBounds(425, 41, 122, 20);
		panel.add(lblGerncia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 154, 830, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbFormaNego = new JComboBox();
		cbFormaNego.setModel(new DefaultComboBoxModel(new String[] {"", "\u00C1 VISTA", "PARCELADO"}));
		cbFormaNego.setBounds(173, 24, 227, 20);
		panel_1.add(cbFormaNego);
		
		JLabel lblFormaDeNegociao = new JLabel("FORMA DE NEGOCIA\u00C7\u00C3O");
		lblFormaDeNegociao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormaDeNegociao.setBounds(10, 24, 135, 20);
		panel_1.add(lblFormaDeNegociao);
		
		JLabel lblValorDeEntrada = new JLabel("VALOR NEGOCIADO");
		lblValorDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDeEntrada.setBounds(10, 55, 135, 20);
		panel_1.add(lblValorDeEntrada);
		
		tfValorNego = new JTextField();
		tfValorNego.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorNego.setColumns(10);
		tfValorNego.setBounds(173, 55, 227, 20);
		panel_1.add(tfValorNego);
		
		JLabel label = new JLabel("VALOR DE ENTRADA");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(426, 24, 135, 20);
		panel_1.add(label);
		
		tfValorEntra = new JTextField();
		tfValorEntra.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorEntra.setColumns(10);
		tfValorEntra.setBounds(575, 24, 227, 20);
		panel_1.add(tfValorEntra);
		
		JLabel lblQuantidadeDeEntrega = new JLabel("QUANTIDADE DE PARCELAS");
		lblQuantidadeDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeDeEntrega.setBounds(426, 55, 153, 20);
		panel_1.add(lblQuantidadeDeEntrega);
		
		tfQuatParc = new JTextField();
		tfQuatParc.setHorizontalAlignment(SwingConstants.CENTER);
		tfQuatParc.setColumns(10);
		tfQuatParc.setBounds(575, 55, 227, 20);
		panel_1.add(tfQuatParc);
		
		JLabel lblValorDasParcelas = new JLabel("VALOR DA PARCELA");
		lblValorDasParcelas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDasParcelas.setBounds(10, 86, 153, 20);
		panel_1.add(lblValorDasParcelas);
		
		tfValParcela = new JTextField();
		tfValParcela.setHorizontalAlignment(SwingConstants.CENTER);
		tfValParcela.setColumns(10);
		tfValParcela.setBounds(173, 86, 227, 20);
		panel_1.add(tfValParcela);
		
		JComboBox cbFaixaFatura = new JComboBox();
		cbFaixaFatura.setModel(new DefaultComboBoxModel(new String[] {"", "3 \u00C1 6", "7 \u00C1 24", "A PARTIR DE 25"}));
		cbFaixaFatura.setBounds(575, 117, 227, 20);
		panel_1.add(cbFaixaFatura);
		
		JLabel lblFaixaFatura = new JLabel("FAIXA FATURA");
		lblFaixaFatura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFaixaFatura.setBounds(426, 117, 135, 20);
		panel_1.add(lblFaixaFatura);
		
		tfRealizado1 = new JTextField();
		tfRealizado1.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado1.setColumns(10);
		tfRealizado1.setBounds(173, 117, 227, 20);
		panel_1.add(tfRealizado1);
		
		JLabel lblServioRealizadoI = new JLabel("SERVI\u00C7O REALIZADO I");
		lblServioRealizadoI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoI.setBounds(10, 117, 153, 20);
		panel_1.add(lblServioRealizadoI);
		
		tfRealizado2 = new JTextField();
		tfRealizado2.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado2.setColumns(10);
		tfRealizado2.setBounds(575, 86, 227, 20);
		panel_1.add(tfRealizado2);
		
		JLabel lblServioRealizadoIi = new JLabel("SERVI\u00C7O REALIZADO II");
		lblServioRealizadoIi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoIi.setBounds(426, 86, 153, 20);
		panel_1.add(lblServioRealizadoIi);
		
		tdDataPag = new JTextField();
		tdDataPag.setHorizontalAlignment(SwingConstants.CENTER);
		tdDataPag.setColumns(10);
		tdDataPag.setBounds(173, 148, 227, 20);
		panel_1.add(tdDataPag);
		
		JLabel lblDataDoPagamento = new JLabel("DATA DO PAGAMENTO");
		lblDataDoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDoPagamento.setBounds(10, 148, 153, 20);
		panel_1.add(lblDataDoPagamento);
		
		JLabel lblAo = new JLabel("A\u00C7\u00C3O");
		lblAo.setBounds(426, 148, 124, 20);
		panel_1.add(lblAo);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		tfAcao = new JTextField();
		tfAcao.setBounds(575, 148, 227, 20);
		panel_1.add(tfAcao);
		tfAcao.setHorizontalAlignment(SwingConstants.CENTER);
		tfAcao.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 348, 830, 154);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 810, 120);
		panel_2.add(scrollPane);
		
		JTextArea taObs = new JTextArea();
		taObs.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		scrollPane.setViewportView(taObs);
	}
}
