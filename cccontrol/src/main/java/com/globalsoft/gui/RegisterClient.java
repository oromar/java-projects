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
					double d= java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
					int widthScreen= (int)d -444;
					frame.setLocation(widthScreen,0); 
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
		setBounds(100, 100, 446, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "DADOS CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel.setBounds(10, 33, 410, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfNameClient = new JTextField();
		tfNameClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfNameClient.setBounds(167, 27, 233, 20);
		panel.add(tfNameClient);
		tfNameClient.setColumns(10);
		
		tfCpfClient = new JTextField();
		tfCpfClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfCpfClient.setColumns(10);
		tfCpfClient.setBounds(167, 58, 233, 20);
		panel.add(tfCpfClient);
		
		tfMatriClient = new JTextField();
		tfMatriClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfMatriClient.setColumns(10);
		tfMatriClient.setBounds(167, 89, 233, 20);
		panel.add(tfMatriClient);
		
		tfGerClient = new JTextField();
		tfGerClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfGerClient.setColumns(10);
		tfGerClient.setBounds(167, 120, 233, 20);
		panel.add(tfGerClient);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 29, 122, 17);
		panel.add(lblNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpfcnpj.setBounds(10, 60, 122, 17);
		panel.add(lblCpfcnpj);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMatrcula.setBounds(10, 89, 122, 20);
		panel.add(lblMatrcula);
		
		JLabel lblGerncia = new JLabel("GER\u00CANCIA");
		lblGerncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGerncia.setBounds(10, 120, 122, 20);
		panel.add(lblGerncia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ACORDO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_1.setBounds(10, 186, 410, 309);
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
		label.setBounds(10, 86, 135, 20);
		panel_1.add(label);
		
		tfValorEntra = new JTextField();
		tfValorEntra.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorEntra.setColumns(10);
		tfValorEntra.setBounds(173, 86, 227, 20);
		panel_1.add(tfValorEntra);
		
		JLabel lblQuantidadeDeEntrega = new JLabel("QUANTIDADE DE PARCELAS");
		lblQuantidadeDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeDeEntrega.setBounds(10, 117, 153, 20);
		panel_1.add(lblQuantidadeDeEntrega);
		
		tfQuatParc = new JTextField();
		tfQuatParc.setHorizontalAlignment(SwingConstants.CENTER);
		tfQuatParc.setColumns(10);
		tfQuatParc.setBounds(173, 117, 227, 20);
		panel_1.add(tfQuatParc);
		
		JLabel lblValorDasParcelas = new JLabel("VALOR DA PARCELA");
		lblValorDasParcelas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDasParcelas.setBounds(10, 148, 153, 20);
		panel_1.add(lblValorDasParcelas);
		
		tfValParcela = new JTextField();
		tfValParcela.setHorizontalAlignment(SwingConstants.CENTER);
		tfValParcela.setColumns(10);
		tfValParcela.setBounds(173, 148, 227, 20);
		panel_1.add(tfValParcela);
		
		JComboBox cbFaixaFatura = new JComboBox();
		cbFaixaFatura.setModel(new DefaultComboBoxModel(new String[] {"", "3 \u00C1 6", "7 \u00C1 24", "A PARTIR DE 25"}));
		cbFaixaFatura.setBounds(173, 241, 227, 20);
		panel_1.add(cbFaixaFatura);
		
		JLabel lblFaixaFatura = new JLabel("FAIXA FATURA");
		lblFaixaFatura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFaixaFatura.setBounds(10, 241, 135, 20);
		panel_1.add(lblFaixaFatura);
		
		tfRealizado1 = new JTextField();
		tfRealizado1.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado1.setColumns(10);
		tfRealizado1.setBounds(173, 179, 227, 20);
		panel_1.add(tfRealizado1);
		
		JLabel lblServioRealizadoI = new JLabel("SERVI\u00C7O REALIZADO I");
		lblServioRealizadoI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoI.setBounds(10, 179, 153, 20);
		panel_1.add(lblServioRealizadoI);
		
		tfRealizado2 = new JTextField();
		tfRealizado2.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado2.setColumns(10);
		tfRealizado2.setBounds(173, 210, 227, 20);
		panel_1.add(tfRealizado2);
		
		JLabel lblServioRealizadoIi = new JLabel("SERVI\u00C7O REALIZADO II");
		lblServioRealizadoIi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoIi.setBounds(10, 210, 153, 20);
		panel_1.add(lblServioRealizadoIi);
		
		tdDataPag = new JTextField();
		tdDataPag.setHorizontalAlignment(SwingConstants.CENTER);
		tdDataPag.setColumns(10);
		tdDataPag.setBounds(173, 272, 227, 20);
		panel_1.add(tdDataPag);
		
		JLabel lblDataDoPagamento = new JLabel("DATA DO PAGAMENTO");
		lblDataDoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDoPagamento.setBounds(10, 272, 153, 20);
		panel_1.add(lblDataDoPagamento);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ANOTA\u00C7\u00D5ES", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_2.setBounds(10, 492, 410, 154);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		tfAcao = new JTextField();
		tfAcao.setBounds(173, 22, 227, 20);
		tfAcao.setHorizontalAlignment(SwingConstants.CENTER);
		tfAcao.setColumns(10);
		panel_2.add(tfAcao);
		
		JLabel lblAo = new JLabel("A\u00C7\u00C3O");
		lblAo.setBounds(10, 22, 124, 20);
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(lblAo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 390, 90);
		panel_2.add(scrollPane);
		
		JTextArea taObs = new JTextArea();
		taObs.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		scrollPane.setViewportView(taObs);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(331, 660, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(10, 657, 89, 23);
		contentPane.add(btnSair);
	}
}
