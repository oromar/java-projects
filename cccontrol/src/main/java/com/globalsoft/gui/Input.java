package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.InputMaterials;
import com.globalsoft.entities.Product;
import com.globalsoft.entities.Supplier;
import com.globalsoft.util.Util;

public class Input extends JFrame {

	private static final long serialVersionUID = 4627718026424582707L;
	private JPanel contentPane;
	private JTextField txtIdProduto;
	private JTextField txtDescricaoProduto;
	private JTextField txtUnidadeMedidaProduto;
	private JTextField txtNotaFiscal;
	private JTextField txtQuantidadeAtual;
	private JTextField txtQuantidade;
	private JTextField txtIdFornecedor;
	private JTextField txtNomeFornecedor;
	private JTextField txtValorUnitario;
	private JTextField txtValorTotal;
	private JTextField txtIpi;
	private JTextField txtCentroCusto;
	private JTextField txtContatoFornecedor;
	private JTextField txtTelefoneFornecedor;
	private JTextField txtFaxFornecedor;
	private JTextPane txtObsComments;
	private JTable table;
	private Collection<Product> listaProdutos;

	public Input() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 468);

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
		btnExit.setBounds(481, 378, 89, 23);
		contentPane.add(btnExit);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputMaterials entrada = Util.getScreenData(Input.this,
						InputMaterials.class);
				try {
					String idFornecedor = txtIdFornecedor.getText();
					if (idFornecedor == null || idFornecedor.isEmpty()) {
						throw new Exception("Fornecedor não informado");
					}
					entrada.setFornecedor(Facade.getInstance().findSupplier(
							Long.valueOf(idFornecedor)));
					entrada.setProdutos(listaProdutos);
					if (entrada.getId() == null) {
						Facade.getInstance().create(entrada);
					} else {
						Facade.getInstance().update(entrada);
					}
					JOptionPane.showMessageDialog(Input.this,
							"Registro salvo com sucesso.");
					Util.clearScreen(Input.this);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Input.this, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(376, 378, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Util.clearScreen(Input.this);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 378, 89, 23);
		contentPane.add(btnNovo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 560, 356);
		contentPane.add(tabbedPane);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dados Cadastrais", null, panel_3, null);
		panel_3.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 535, 103);
		panel_3.add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(null);

		JLabel lblCdFornecedor = new JLabel("C\u00F3d. Fornecedor");
		lblCdFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCdFornecedor.setBounds(10, 11, 122, 14);
		panel_1.add(lblCdFornecedor);

		txtIdFornecedor = new JTextField();
		txtIdFornecedor.setEditable(false);
		txtIdFornecedor.setBounds(10, 27, 86, 20);
		panel_1.add(txtIdFornecedor);
		txtIdFornecedor.setColumns(10);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(106, 11, 367, 14);
		panel_1.add(lblFornecedor);

		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.setBounds(106, 27, 419, 20);
		panel_1.add(txtNomeFornecedor);
		txtNomeFornecedor.setEditable(false);
		txtNomeFornecedor.setColumns(10);

		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final Fornecedores view = new Fornecedores(true);
				view.setLocationRelativeTo(null);
				view.setVisible(true);
				view.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						Supplier f = view.getFornecedorSelecionado();
						txtIdFornecedor.setText(String.valueOf(f.getId()));
						txtNomeFornecedor.setText(f.getNome());
						// txtEmailContatoFornecedor.setText(f.getEmail());
						txtContatoFornecedor.setText(f.getContato());
						txtFaxFornecedor.setText(f.getFax());
						txtTelefoneFornecedor.setText(f.getTel1());
					}
				});
			}
		});
		button_3.setToolTipText("Buscar Fornecedor");
		button_3.setBounds(383, 64, 28, 28);
		panel_1.add(button_3);

		txtContatoFornecedor = new JTextField();
		txtContatoFornecedor.setColumns(10);
		txtContatoFornecedor.setBounds(226, 72, 147, 20);
		panel_1.add(txtContatoFornecedor);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContato.setBounds(226, 56, 121, 14);
		panel_1.add(lblContato);

		txtTelefoneFornecedor = new JTextField();
		txtTelefoneFornecedor.setEditable(false);
		txtTelefoneFornecedor.setColumns(10);
		txtTelefoneFornecedor.setBounds(10, 72, 96, 20);
		panel_1.add(txtTelefoneFornecedor);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefone.setBounds(10, 56, 96, 14);
		panel_1.add(lblTelefone);

		JLabel lblFax = new JLabel("Fax");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFax.setBounds(116, 58, 102, 14);
		panel_1.add(lblFax);

		txtFaxFornecedor = new JTextField();
		txtFaxFornecedor.setBounds(118, 72, 100, 20);
		panel_1.add(txtFaxFornecedor);
		txtFaxFornecedor.setEditable(false);
		txtFaxFornecedor.setColumns(10);

		JButton button_4 = new JButton("Add");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.setIcon(new ImageIcon("Icones\\accept.png"));
		button_4.setToolTipText("Adicionar Produto");
		button_4.setBounds(421, 64, 104, 28);
		panel_1.add(button_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 125, 535, 146);
		panel_3.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		JLabel lblNewLabel_1 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 0, 515, 25);
		panel_2.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 515, 106);
		panel_2.add(scrollPane);

		txtObsComments = new JTextPane();
		scrollPane.setViewportView(txtObsComments);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Produto", null, panel_4, null);
		panel_4.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 537, 147);
		panel_4.add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(null);

		txtIdProduto = new JTextField();
		txtIdProduto.setEditable(false);
		txtIdProduto.setBounds(10, 27, 79, 20);
		panel.add(txtIdProduto);
		txtIdProduto.setColumns(10);

		txtDescricaoProduto = new JTextField();
		txtDescricaoProduto.setEditable(false);
		txtDescricaoProduto.setColumns(10);
		txtDescricaoProduto.setBounds(99, 27, 340, 20);
		panel.add(txtDescricaoProduto);

		txtUnidadeMedidaProduto = new JTextField();
		txtUnidadeMedidaProduto.setEditable(false);
		txtUnidadeMedidaProduto.setColumns(10);
		txtUnidadeMedidaProduto.setBounds(449, 27, 79, 20);
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
		lblUnd.setBounds(449, 11, 79, 14);
		panel.add(lblUnd);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon("Icones\\zoom.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Produtos view = new Produtos(true);
				view.setLocationRelativeTo(Input.this);
				view.setVisible(true);
				view.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						Product p = view.getSelecionado();
						txtIdProduto.setText(String.valueOf(p.getId()));
						txtDescricaoProduto.setText(p.getNome());
						txtUnidadeMedidaProduto.setText(p.getUnidadeMedida());
						txtQuantidadeAtual.setText(p.getEmEstoque());
					}
				});
			}
		});
		button.setToolTipText("Buscar Produto");
		button.setBounds(406, 108, 28, 28);
		panel.add(button);

		txtNotaFiscal = new JTextField();
		txtNotaFiscal.setColumns(10);
		txtNotaFiscal.setBounds(10, 74, 122, 20);
		panel.add(txtNotaFiscal);

		JLabel lblNNotaFiscal = new JLabel("N\u00BA Nota Fiscal");
		lblNNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNNotaFiscal.setBounds(10, 58, 122, 14);
		panel.add(lblNNotaFiscal);

		txtQuantidadeAtual = new JTextField();
		txtQuantidadeAtual.setEditable(false);
		txtQuantidadeAtual.setColumns(10);
		txtQuantidadeAtual.setBounds(142, 74, 122, 20);
		panel.add(txtQuantidadeAtual);

		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade Atual");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidadeEmEstoque.setBounds(142, 58, 122, 14);
		panel.add(lblQuantidadeEmEstoque);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(274, 74, 122, 20);
		panel.add(txtQuantidade);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(274, 58, 122, 14);
		panel.add(lblQuantidade);

		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnitrio.setBounds(142, 100, 122, 14);
		panel.add(lblValorUnitrio);

		txtValorUnitario = new JTextField();
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBounds(142, 116, 122, 20);
		panel.add(txtValorUnitario);

		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(274, 116, 122, 20);
		panel.add(txtValorTotal);

		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorTotal.setBounds(274, 100, 122, 14);
		panel.add(lblValorTotal);

		txtIpi = new JTextField();
		txtIpi.setColumns(10);
		txtIpi.setBounds(10, 116, 127, 20);
		panel.add(txtIpi);

		JLabel lblIpi = new JLabel("I.P.I.");
		lblIpi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIpi.setBounds(10, 100, 127, 14);
		panel.add(lblIpi);

		txtCentroCusto = new JTextField();
		txtCentroCusto.setColumns(10);
		txtCentroCusto.setBounds(406, 74, 86, 20);
		panel.add(txtCentroCusto);

		JLabel lblCentroDeCusto = new JLabel("Centro de Custo");
		lblCentroDeCusto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCentroDeCusto.setBounds(406, 58, 122, 14);
		panel.add(lblCentroDeCusto);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button_1.setIcon(new ImageIcon("Icones\\zoom.png"));
		button_1.setToolTipText("Buscar Centro de Custo");
		button_1.setBounds(500, 66, 28, 28);
		panel.add(button_1);

		JButton btnAddProduto = new JButton("Add");
		btnAddProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (listaProdutos == null) {
						listaProdutos = new ArrayList<Product>();
					}
					String idProduto = txtIdProduto.getText();
					if (idProduto != null && !idProduto.isEmpty()) {
						listaProdutos.add(Facade.getInstance().findProduct(
								Long.valueOf(idProduto)));						
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddProduto.setIcon(new ImageIcon("Icones\\accept.png"));
		btnAddProduto.setToolTipText("Add Produto");
		btnAddProduto.setBounds(444, 108, 84, 28);
		panel.add(btnAddProduto);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 166, 537, 152);
		panel_4.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
	}
}
