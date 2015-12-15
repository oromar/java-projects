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
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtMatri;
	private JTextField txtCentroCusto;
	private JTextField txtTel1;
	private JTextField txtTel2;
	private JTextField txtSetor;
	private JTextField txtFuncao;

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
		setBounds(100, 100, 472, 488);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsalve = new JButton("Salvar");
		btsalve.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btsalve.setIcon(new ImageIcon("Icones\\disk.png"));
		btsalve.setBounds(269, 429, 89, 23);
		contentPane.add(btsalve);
		
		JButton btExit = new JButton("Sair");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btExit.setBounds(368, 429, 89, 23);
		contentPane.add(btExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 54, 447, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo");
		lblCod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCod.setBounds(10, 11, 67, 14);
		panel.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(10, 26, 67, 20);
		panel.add(txtCod);
		txtCod.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(82, 26, 349, 20);
		panel.add(txtNome);
		
		JLabel lblDescrio = new JLabel("Nome *");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(355, 103, 100, 14);
		panel.add(lblQuantidade);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 72, 131, 20);
		panel.add(txtCpf);
		
		JLabel lblMarca_1 = new JLabel("CPF*");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 100, 14);
		panel.add(lblMarca_1);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(151, 72, 133, 20);
		panel.add(txtRg);
		
		JLabel lblFabricante = new JLabel("RG*");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(151, 57, 133, 14);
		panel.add(lblFabricante);
		
		JLabel lblUnidadeDeMedida = new JLabel("Matr\u00EDcula");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(294, 57, 169, 14);
		panel.add(lblUnidadeDeMedida);
		
		txtMatri = new JTextField();
		txtMatri.setColumns(10);
		txtMatri.setBounds(294, 72, 137, 20);
		panel.add(txtMatri);
		
		txtCentroCusto = new JTextField();
		txtCentroCusto.setEditable(false);
		txtCentroCusto.setColumns(10);
		txtCentroCusto.setBounds(10, 164, 111, 20);
		panel.add(txtCentroCusto);
		
		JLabel lblCor = new JLabel("Centro de Custo *");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 149, 111, 14);
		panel.add(lblCor);
		
		txtTel1 = new JTextField();
		txtTel1.setText("(81) 9999999999");
		txtTel1.setColumns(10);
		txtTel1.setBounds(164, 164, 126, 20);
		panel.add(txtTel1);
		
		JLabel lblSrie = new JLabel("Telefone 1 *");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(164, 149, 126, 14);
		panel.add(lblSrie);
		
		JLabel lblReferncia = new JLabel("Telefone 2");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(294, 149, 137, 14);
		panel.add(lblReferncia);
		
		txtTel2 = new JTextField();
		txtTel2.setColumns(10);
		txtTel2.setBounds(294, 164, 137, 20);
		panel.add(txtTel2);
		
		JLabel lblSetor = new JLabel("Setor *");
		lblSetor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSetor.setBounds(10, 103, 201, 14);
		panel.add(lblSetor);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o *");
		lblFuno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFuno.setBounds(221, 103, 210, 14);
		panel.add(lblFuno);
		
		txtSetor = new JTextField();
		txtSetor.setColumns(10);
		txtSetor.setBounds(10, 118, 201, 20);
		panel.add(txtSetor);
		
		txtFuncao = new JTextField();
		txtFuncao.setColumns(10);
		txtFuncao.setBounds(221, 118, 210, 20);
		panel.add(txtFuncao);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("Icones\\zoom.png"));
		button.setToolTipText("Cadastrar Fornecedor");
		button.setBounds(126, 156, 28, 28);
		panel.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 266, 447, 152);
		contentPane.add(panel_2);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblObservaes.setBounds(10, 0, 81, 25);
		panel_2.add(lblObservaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 427, 117);
		panel_2.add(scrollPane);
		
		JTextPane txtObs = new JTextPane();
		scrollPane.setViewportView(txtObs);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 429, 89, 23);
		contentPane.add(btnNovo);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Solicitante");
		lblCadastroProduto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroProduto.setBounds(10, 11, 447, 45);
		contentPane.add(lblCadastroProduto);
	}
}
