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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField tfOs;
	private JTextField tfMat;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField tfCateg;
	private JTextField tfPerf;
	private JTextField tfSituAg;
	private JTextField textField_8;
	private JTextField tfTel;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

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
		setBounds(100, 100, 867, 565);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Editar Dados Pessoais");
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
		panel.setBounds(10, 106, 830, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfNameClient = new JTextField();
		tfNameClient.setEnabled(false);
		tfNameClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfNameClient.setBounds(82, 11, 233, 20);
		panel.add(tfNameClient);
		tfNameClient.setColumns(10);
		
		tfCpfClient = new JTextField();
		tfCpfClient.setEnabled(false);
		tfCpfClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfCpfClient.setColumns(10);
		tfCpfClient.setBounds(656, 11, 161, 20);
		panel.add(tfCpfClient);
		
		tfMatriClient = new JTextField();
		tfMatriClient.setEnabled(false);
		tfMatriClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfMatriClient.setColumns(10);
		tfMatriClient.setBounds(396, 11, 184, 20);
		panel.add(tfMatriClient);
		
		tfGerClient = new JTextField();
		tfGerClient.setEnabled(false);
		tfGerClient.setHorizontalAlignment(SwingConstants.CENTER);
		tfGerClient.setColumns(10);
		tfGerClient.setBounds(82, 73, 233, 20);
		panel.add(tfGerClient);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNome.setBounds(10, 13, 122, 17);
		panel.add(lblNome);
		
		JLabel lblCpfcnpj = new JLabel("CPF/CNPJ");
		lblCpfcnpj.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCpfcnpj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpfcnpj.setBounds(590, 13, 122, 17);
		panel.add(lblCpfcnpj);
		
		JLabel lblMatrcula = new JLabel("MATR\u00CDCULA");
		lblMatrcula.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMatrcula.setBounds(325, 11, 122, 20);
		panel.add(lblMatrcula);
		
		JLabel lblGerncia = new JLabel("GER\u00CANCIA");
		lblGerncia.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGerncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGerncia.setBounds(10, 73, 122, 20);
		panel.add(lblGerncia);
		
		JLabel lblElo_1 = new JLabel("N\u00BA O.S.");
		lblElo_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblElo_1.setAlignmentX(0.5f);
		lblElo_1.setBounds(325, 42, 122, 20);
		panel.add(lblElo_1);
		
		tfOs = new JTextField();
		tfOs.setEnabled(false);
		tfOs.setHorizontalAlignment(SwingConstants.CENTER);
		tfOs.setColumns(10);
		tfOs.setBounds(396, 42, 184, 20);
		panel.add(tfOs);
		
		JLabel lblGerenciaReg = new JLabel("GER\u00CANCIA Reg.");
		lblGerenciaReg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGerenciaReg.setAlignmentX(0.5f);
		lblGerenciaReg.setBounds(10, 42, 122, 20);
		panel.add(lblGerenciaReg);
		
		tfMat = new JTextField();
		tfMat.setEnabled(false);
		tfMat.setHorizontalAlignment(SwingConstants.CENTER);
		tfMat.setColumns(10);
		tfMat.setBounds(82, 42, 233, 20);
		panel.add(tfMat);
		
		JLabel lblElo = new JLabel("SETOR");
		lblElo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblElo.setAlignmentX(0.5f);
		lblElo.setBounds(589, 73, 113, 20);
		panel.add(lblElo);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(656, 73, 161, 20);
		panel.add(textField_2);
		
		JLabel lblSetor = new JLabel("QUADRA");
		lblSetor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSetor.setAlignmentX(0.5f);
		lblSetor.setBounds(325, 73, 113, 20);
		panel.add(lblSetor);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(396, 73, 184, 20);
		panel.add(textField_3);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEndereo.setAlignmentX(0.5f);
		lblEndereo.setBounds(10, 135, 122, 20);
		panel.add(lblEndereo);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(82, 135, 735, 20);
		panel.add(textField_4);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategoria.setAlignmentX(0.5f);
		lblCategoria.setBounds(10, 104, 122, 20);
		panel.add(lblCategoria);
		
		tfCateg = new JTextField();
		tfCateg.setEnabled(false);
		tfCateg.setHorizontalAlignment(SwingConstants.CENTER);
		tfCateg.setColumns(10);
		tfCateg.setBounds(82, 104, 107, 20);
		panel.add(tfCateg);
		
		JLabel lblPerfil = new JLabel("PERFIL");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPerfil.setAlignmentX(0.5f);
		lblPerfil.setBounds(199, 104, 82, 20);
		panel.add(lblPerfil);
		
		tfPerf = new JTextField();
		tfPerf.setEnabled(false);
		tfPerf.setHorizontalAlignment(SwingConstants.CENTER);
		tfPerf.setColumns(10);
		tfPerf.setBounds(243, 104, 122, 20);
		panel.add(tfPerf);
		
		JLabel lblSituaogua = new JLabel("Sit. \u00C1GUA");
		lblSituaogua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSituaogua.setAlignmentX(0.5f);
		lblSituaogua.setBounds(370, 104, 107, 20);
		panel.add(lblSituaogua);
		
		tfSituAg = new JTextField();
		tfSituAg.setEnabled(false);
		tfSituAg.setHorizontalAlignment(SwingConstants.CENTER);
		tfSituAg.setColumns(10);
		tfSituAg.setBounds(458, 104, 122, 20);
		panel.add(tfSituAg);
		
		JLabel lblSitesgoto = new JLabel("Sit.ESGOTO");
		lblSitesgoto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSitesgoto.setAlignmentX(0.5f);
		lblSitesgoto.setBounds(589, 104, 82, 20);
		panel.add(lblSitesgoto);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(656, 104, 161, 20);
		panel.add(textField_8);
		
		JLabel lblCodLocalidade = new JLabel("TELEFONE");
		lblCodLocalidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodLocalidade.setAlignmentX(0.5f);
		lblCodLocalidade.setBounds(590, 44, 122, 17);
		panel.add(lblCodLocalidade);
		
		tfTel = new JTextField();
		tfTel.setEnabled(false);
		tfTel.setHorizontalAlignment(SwingConstants.CENTER);
		tfTel.setColumns(10);
		tfTel.setBounds(656, 42, 161, 20);
		panel.add(tfTel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 282, 830, 215);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox cbFormaNego = new JComboBox();
		cbFormaNego.setModel(new DefaultComboBoxModel(new String[] {"", "\u00C1 VISTA", "PARCELADO"}));
		cbFormaNego.setBounds(139, 52, 227, 20);
		panel_1.add(cbFormaNego);
		
		JLabel lblFormaDeNegociao = new JLabel("FORMA DE NEGOCIA\u00C7\u00C3O");
		lblFormaDeNegociao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFormaDeNegociao.setBounds(10, 52, 135, 20);
		panel_1.add(lblFormaDeNegociao);
		
		JLabel lblValorDeEntrada = new JLabel("VALOR NEGOCIADO");
		lblValorDeEntrada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDeEntrada.setBounds(10, 83, 135, 20);
		panel_1.add(lblValorDeEntrada);
		
		tfValorNego = new JTextField();
		tfValorNego.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorNego.setColumns(10);
		tfValorNego.setBounds(139, 83, 227, 20);
		panel_1.add(tfValorNego);
		
		JLabel label = new JLabel("VALOR DE ENTRADA");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(376, 52, 135, 20);
		panel_1.add(label);
		
		tfValorEntra = new JTextField();
		tfValorEntra.setHorizontalAlignment(SwingConstants.CENTER);
		tfValorEntra.setColumns(10);
		tfValorEntra.setBounds(521, 52, 299, 20);
		panel_1.add(tfValorEntra);
		
		JLabel lblQuantidadeDeEntrega = new JLabel("QUANTIDADE DE PARCELAS");
		lblQuantidadeDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeDeEntrega.setBounds(376, 83, 153, 20);
		panel_1.add(lblQuantidadeDeEntrega);
		
		tfQuatParc = new JTextField();
		tfQuatParc.setHorizontalAlignment(SwingConstants.CENTER);
		tfQuatParc.setColumns(10);
		tfQuatParc.setBounds(521, 83, 299, 20);
		panel_1.add(tfQuatParc);
		
		JLabel lblValorDasParcelas = new JLabel("VALOR DA PARCELA");
		lblValorDasParcelas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDasParcelas.setBounds(10, 114, 153, 20);
		panel_1.add(lblValorDasParcelas);
		
		tfValParcela = new JTextField();
		tfValParcela.setHorizontalAlignment(SwingConstants.CENTER);
		tfValParcela.setColumns(10);
		tfValParcela.setBounds(139, 114, 227, 20);
		panel_1.add(tfValParcela);
		
		JComboBox cbFaixaFatura = new JComboBox();
		cbFaixaFatura.setModel(new DefaultComboBoxModel(new String[] {"", "3 \u00C1 6", "7 \u00C1 24", "A PARTIR DE 25"}));
		cbFaixaFatura.setBounds(521, 145, 299, 20);
		panel_1.add(cbFaixaFatura);
		
		JLabel lblFaixaFatura = new JLabel("FAIXA FATURA");
		lblFaixaFatura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFaixaFatura.setBounds(376, 145, 135, 20);
		panel_1.add(lblFaixaFatura);
		
		tfRealizado1 = new JTextField();
		tfRealizado1.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado1.setColumns(10);
		tfRealizado1.setBounds(139, 145, 227, 20);
		panel_1.add(tfRealizado1);
		
		JLabel lblServioRealizadoI = new JLabel("SERVI\u00C7O REALIZADO I");
		lblServioRealizadoI.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoI.setBounds(10, 145, 153, 20);
		panel_1.add(lblServioRealizadoI);
		
		tfRealizado2 = new JTextField();
		tfRealizado2.setHorizontalAlignment(SwingConstants.CENTER);
		tfRealizado2.setColumns(10);
		tfRealizado2.setBounds(521, 114, 299, 20);
		panel_1.add(tfRealizado2);
		
		JLabel lblServioRealizadoIi = new JLabel("SERVI\u00C7O REALIZADO II");
		lblServioRealizadoIi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblServioRealizadoIi.setBounds(376, 114, 153, 20);
		panel_1.add(lblServioRealizadoIi);
		
		tdDataPag = new JTextField();
		tdDataPag.setHorizontalAlignment(SwingConstants.CENTER);
		tdDataPag.setColumns(10);
		tdDataPag.setBounds(139, 176, 227, 20);
		panel_1.add(tdDataPag);
		
		JLabel lblDataDoPagamento = new JLabel("DATA DO PAGAMENTO");
		lblDataDoPagamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDoPagamento.setBounds(10, 176, 153, 20);
		panel_1.add(lblDataDoPagamento);
		
		JLabel lblAo = new JLabel("A\u00C7\u00C3O");
		lblAo.setBounds(384, 176, 124, 20);
		panel_1.add(lblAo);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		tfAcao = new JTextField();
		tfAcao.setBounds(521, 176, 299, 20);
		panel_1.add(tfAcao);
		tfAcao.setHorizontalAlignment(SwingConstants.CENTER);
		tfAcao.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(139, 21, 165, 20);
		panel_1.add(textField_10);
		
		JLabel lblValorDoDbito = new JLabel("VALOR DO D\u00C9BITO");
		lblValorDoDbito.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorDoDbito.setBounds(10, 21, 135, 20);
		panel_1.add(lblValorDoDbito);
		
		JLabel lblDataDo = new JLabel("DT. DO VENCIEMENTO");
		lblDataDo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDo.setAlignmentX(0.5f);
		lblDataDo.setBounds(314, 21, 122, 20);
		panel_1.add(lblDataDo);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(446, 21, 107, 20);
		panel_1.add(textField_11);
		
		JLabel lblDataDoUltimo = new JLabel("DT. DO ULTIMO PAGAMENTO");
		lblDataDoUltimo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDataDoUltimo.setAlignmentX(0.5f);
		lblDataDoUltimo.setBounds(563, 21, 161, 20);
		panel_1.add(lblDataDoUltimo);
		
		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		textField_12.setBounds(713, 21, 107, 20);
		panel_1.add(textField_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 11, 830, 81);
		contentPane.add(panel_3);
		
		JButton button = new JButton("");
		button.setBounds(10, 11, 56, 48);
		panel_3.add(button);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSalvar.setBounds(10, 56, 56, 25);
		panel_3.add(lblSalvar);
		
		JLabel label_6 = new JLabel("Sair");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(1267, 56, 65, 25);
		panel_3.add(label_6);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_3.setBounds(764, 11, 56, 48);
		panel_3.add(button_3);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setHorizontalAlignment(SwingConstants.CENTER);
		lblSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSair.setBounds(764, 56, 56, 25);
		panel_3.add(lblSair);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchClient tela = new SearchClient();
				tela.setLocationRelativeTo(null); 
				tela.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(698, 11, 56, 48);
		panel_3.add(button_1);
		
		JLabel lblVoltar = new JLabel("Voltar");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVoltar.setBounds(698, 56, 56, 25);
		panel_3.add(lblVoltar);
	}
}
