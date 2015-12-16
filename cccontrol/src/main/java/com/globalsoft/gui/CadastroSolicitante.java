package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.Requester;
import com.globalsoft.util.Util;

public class CadastroSolicitante extends JFrame {

	private static final long serialVersionUID = -5862683290614642467L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtMatricula;
	private JTextField txtCentroCusto;
	private JTextField txtTelefone1;
	private JTextField txtTelefone2;
	private JTextField txtSetor;
	private JTextField txtFuncao;
	private JTextPane txtObsComments;


	public CadastroSolicitante(Requester req){
		this();
		Util.setScreenData(this, req);
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
		btsalve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Requester req = Util.getScreenData(CadastroSolicitante.this, Requester.class);
				try {
					if (req.getId() == null) { 
						Facade.getInstance().create(req);
					} else {
						Facade.getInstance().update(req);
					}
					JOptionPane.showMessageDialog(CadastroSolicitante.this, "Registro salvo com sucesso.");
					Util.clearScreen(CadastroSolicitante.this);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
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

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(10, 26, 67, 20);
		panel.add(txtId);
		txtId.setColumns(10);

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

		txtMatricula = new JTextField();
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(294, 72, 137, 20);
		panel.add(txtMatricula);

		txtCentroCusto = new JTextField();
		txtCentroCusto.setColumns(10);
		txtCentroCusto.setBounds(10, 164, 111, 20);
		panel.add(txtCentroCusto);

		JLabel lblCor = new JLabel("Centro de Custo *");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 149, 111, 14);
		panel.add(lblCor);

		txtTelefone1 = new JTextField();
		txtTelefone1.setText("(81) 9999999999");
		txtTelefone1.setColumns(10);
		txtTelefone1.setBounds(164, 164, 126, 20);
		panel.add(txtTelefone1);

		JLabel lblSrie = new JLabel("Telefone 1 *");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(164, 149, 126, 14);
		panel.add(lblSrie);

		JLabel lblReferncia = new JLabel("Telefone 2");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(294, 149, 137, 14);
		panel.add(lblReferncia);

		txtTelefone2 = new JTextField();
		txtTelefone2.setColumns(10);
		txtTelefone2.setBounds(294, 164, 137, 20);
		panel.add(txtTelefone2);

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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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

		txtObsComments = new JTextPane();
		scrollPane.setViewportView(txtObsComments);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util.clearScreen(CadastroSolicitante.this);
			}
		});
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
