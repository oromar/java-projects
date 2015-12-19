package com.globalsoft.gui;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;

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
import com.globalsoft.entities.OutputMaterials;
import com.globalsoft.entities.Product;
import com.globalsoft.entities.Requester;
import com.globalsoft.util.Util;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Output extends JFrame {

	private static final long serialVersionUID = -1135303629646212467L;
	private JPanel contentPane;
	private JTextField txtCodigoProduto;
	private JTextField txtDescricaoProduto;
	private JTextField txtUnidadeMedidaProduto;
	private JTextField txtQuantidadeEstoque;
	private JTextField txtQuantidade;
	private JTextField txtNomeRequisitante;
	private JTextField txtCentroCusto;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtTelefone;
	private JTextField txtMatricula;
	private JTextField txtAutorizacao;
	private JTextPane txtObsComments;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public Output() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 633, 585);
		//frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnExit = new JButton("Sair");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btnExit.setBounds(527, 502, 89, 23);
		contentPane.add(btnExit);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutputMaterials output = Util.getScreenData(Output.this,
						OutputMaterials.class);
				String idProduto = txtCodigoProduto.getText();
				String idRequester = txtMatricula.getText();
				try {
					if (idProduto == null || idProduto.isEmpty()) {
						throw new Exception("Produto não informado");
					}
					if (idRequester == null || idRequester.isEmpty()) {
						throw new Exception("Solicitante não informado");
					}
					Product p = Facade.getInstance().findProduct(
							Long.valueOf(idProduto));
					Requester r = new Requester();
					r.setMatricula(idRequester);
					Optional<Requester> optR = Facade.getInstance().filter(r)
							.stream().findFirst();
					if (optR.isPresent()) {
						output.setRequester(optR.get());
					}
					if (p != null) {
						output.setProduct(p);
					}
					Facade.getInstance().create(output);
					JOptionPane.showMessageDialog(Output.this,
							"Registro salvo com sucesso.");
					Util.clearScreen(Output.this);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Output.this, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnSalvar.setBounds(428, 502, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util.clearScreen(Output.this);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 502, 89, 23);
		contentPane.add(btnNovo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 609, 480);
		contentPane.add(tabbedPane);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dados Cadastrais", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 584, 150);
		panel_3.add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);

		JButton btnBuscaSolicitante = new JButton("Buscar");
		btnBuscaSolicitante.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnBuscaSolicitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Solicitantes view = new Solicitantes(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);
				view.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						Requester r = view.getSelecionado();
						txtNomeRequisitante.setText(r.getNome());
						txtCpf.setText(r.getCpf());
						txtRg.setText(r.getRg());
						txtTelefone.setText(r.getTel1());
						txtMatricula.setText(r.getMatricula());
						// txtEmail.setText(r.getEmail());
					}
				});
			}
		});
		btnBuscaSolicitante.setToolTipText("Buscar Fornecedor");
		btnBuscaSolicitante.setBounds(469, 111, 105, 28);
		panel_1.add(btnBuscaSolicitante);

		txtNomeRequisitante = new JTextField();
		txtNomeRequisitante.setEditable(false);
		txtNomeRequisitante.setBounds(93, 27, 341, 20);
		panel_1.add(txtNomeRequisitante);
		txtNomeRequisitante.setColumns(10);

		JLabel lblContrato = new JLabel("Requisitante");
		lblContrato.setBounds(93, 13, 341, 14);
		panel_1.add(lblContrato);
		lblContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCpf.setBounds(10, 58, 163, 14);
		panel_1.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 74, 163, 20);
		panel_1.add(txtCpf);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRg.setBounds(183, 58, 151, 14);
		panel_1.add(lblRg);

		txtRg = new JTextField();
		txtRg.setEditable(false);
		txtRg.setColumns(10);
		txtRg.setBounds(183, 74, 151, 20);
		panel_1.add(txtRg);

		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(318, 119, 141, 20);
		panel_1.add(txtTelefone);

		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(318, 103, 122, 14);
		panel_1.add(lblTelefone);

		txtMatricula = new JTextField();
		txtMatricula.setEditable(false);
		txtMatricula.setColumns(10);
		txtMatricula.setBounds(444, 27, 130, 20);
		panel_1.add(txtMatricula);

		JLabel lblTelefone_1 = new JLabel("Matr\u00EDcula");
		lblTelefone_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone_1.setBounds(444, 11, 130, 14);
		panel_1.add(lblTelefone_1);

		txtAutorizacao = new JTextField();
		txtAutorizacao.setColumns(10);
		txtAutorizacao.setBounds(10, 119, 151, 20);
		panel_1.add(txtAutorizacao);

		JLabel lblAutorizaosupervisor = new JLabel(
				"Autoriza\u00E7\u00E3o/Supervisor");
		lblAutorizaosupervisor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAutorizaosupervisor.setBounds(10, 103, 122, 14);
		panel_1.add(lblAutorizaosupervisor);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(344, 74, 230, 20);
		panel_1.add(textField);
		
		JLabel label = new JLabel("Fun\u00E7\u00E3o *");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(344, 58, 230, 14);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 27, 73, 20);
		panel_1.add(textField_1);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(10, 12, 60, 14);
		panel_1.add(lblCodigo);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(171, 119, 141, 20);
		panel_1.add(textField_2);
		
		JLabel lblCentroDeCusto = new JLabel("Centro de Custo");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(171, 103, 122, 14);
		panel_1.add(lblCentroDeCusto);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 172, 584, 171);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNewLabel_1 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 0, 477, 25);
		panel_2.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 564, 134);
		panel_2.add(scrollPane);

		txtObsComments = new JTextPane();
		scrollPane.setViewportView(txtObsComments);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Produto", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 587, 108);
		panel_4.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setEditable(false);
		txtCodigoProduto.setBounds(10, 27, 79, 20);
		panel.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);

		txtDescricaoProduto = new JTextField();
		txtDescricaoProduto.setEditable(false);
		txtDescricaoProduto.setColumns(10);
		txtDescricaoProduto.setBounds(99, 27, 369, 20);
		panel.add(txtDescricaoProduto);

		txtUnidadeMedidaProduto = new JTextField();
		txtUnidadeMedidaProduto.setEditable(false);
		txtUnidadeMedidaProduto.setColumns(10);
		txtUnidadeMedidaProduto.setBounds(478, 27, 99, 20);
		panel.add(txtUnidadeMedidaProduto);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(99, 11, 46, 14);
		panel.add(lblDescrio);

		JLabel lblUnd = new JLabel("Unidade");
		lblUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnd.setBounds(478, 11, 99, 14);
		panel.add(lblUnd);

		JButton btnBuscaProd = new JButton("");
		btnBuscaProd.setIcon(new ImageIcon("Icones\\zoom.png"));
		btnBuscaProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Produtos view = new Produtos(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);

				view.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						Product p = view.getSelecionado();
						txtCodigoProduto.setText(String.valueOf(p.getId()));
						txtDescricaoProduto.setText(p.getNome());
						txtUnidadeMedidaProduto.setText(p.getUnidadeMedida());
						txtQuantidadeEstoque.setText(p.getEmEstoque());
					}
				});

			}
		});
		btnBuscaProd.setToolTipText("Buscar Produto");
		btnBuscaProd.setBounds(442, 66, 28, 28);
		panel.add(btnBuscaProd);

		txtQuantidadeEstoque = new JTextField();
		txtQuantidadeEstoque.setEditable(false);
		txtQuantidadeEstoque.setColumns(10);
		txtQuantidadeEstoque.setBounds(178, 74, 122, 20);
		panel.add(txtQuantidadeEstoque);

		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade Atual");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeEmEstoque.setBounds(178, 58, 122, 14);
		panel.add(lblQuantidadeEmEstoque);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(310, 74, 122, 20);
		panel.add(txtQuantidade);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(310, 58, 122, 14);
		panel.add(lblQuantidade);

		txtCentroCusto = new JTextField();
		txtCentroCusto.setBounds(8, 74, 124, 20);
		panel.add(txtCentroCusto);
		txtCentroCusto.setColumns(10);

		JButton button = new JButton("Add");
		button.setIcon(new ImageIcon("Icones\\accept.png"));
		button.setToolTipText("Add Produto");
		button.setBounds(480, 66, 97, 28);
		panel.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_1.setToolTipText("Buscar Produto");
		button_1.setBounds(140, 66, 28, 28);
		panel.add(button_1);

		JLabel lblCentroDeCusto_1 = new JLabel("Centro de Custo");
		lblCentroDeCusto_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCentroDeCusto_1.setBounds(8, 57, 124, 14);
		panel.add(lblCentroDeCusto_1);
		lblCentroDeCusto_1.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 130, 587, 311);
		panel_4.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
	}
}
