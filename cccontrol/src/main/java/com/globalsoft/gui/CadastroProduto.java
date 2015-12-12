package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.globalsoft.entities.Category;
import com.globalsoft.entities.Product;
import com.globalsoft.entities.Subcategory;
import com.globalsoft.entities.Supplier;
import com.globalsoft.util.Util;

public class CadastroProduto extends JFrame {

	private static final long serialVersionUID = -5862683290614642467L;
	private JPanel contentPane;
	private JComboBox<Category> cbCatego;
	private JComboBox<Subcategory> cbSubcat;
	private JComboBox<Supplier> cmbFornecedor;
	private JTextField txtCod;
	private JTextField txtDescription;
	private JTextField txtValorUnitario;
	private JTextField txtNotaFiscal;
	private JTextField txtEstoqueMinimo;
	private JTextField txtEstoqueMaximo;
	private JTextField txtLocalEstoque;
	private JTextField txtMarca;
	private JTextField txtFabricante;
	private JTextField txtUnidadeMedida;
	private JTextField txtCor;
	private JTextField txtSerie;
	private JTextField txtReferencia;
	private JTextPane txtObservacao;

	private void clearScreen() {
		txtCod.setText("");
		txtDescription.setText("");
		txtValorUnitario.setText("");
		txtNotaFiscal.setText("");
		txtEstoqueMinimo.setText("");
		txtEstoqueMaximo.setText("");
		txtLocalEstoque.setText("");
		txtMarca.setText("");
		txtFabricante.setText("");
		txtUnidadeMedida.setText("");
		txtCor.setText("");
		txtSerie.setText("");
		txtReferencia.setText("");
	}
	
	private Product getScreenData() {
		Product result = new Product();
		String id = txtCod.getText();
		if (!Util.isNullOrEmpty(id)) {
			result.setId(Long.valueOf(txtCod.getText()));
		}
		result.setNome(txtDescription.getText());
		result.setEstoqueMin(txtEstoqueMinimo.getText());
		result.setEstoqueMax(txtEstoqueMaximo.getText());
		result.setFabricante(txtFabricante.getText());
		result.setCor(txtCor.getText());	
		result.setFornecedor((Supplier) cmbFornecedor.getSelectedItem());
		result.setMarca(txtMarca.getText());
		result.setLocalEstoque(txtLocalEstoque.getText());
		result.setNotaFiscal(txtNotaFiscal.getText());
		result.setValorUnit(txtValorUnitario.getText());
		result.setSerie(txtSerie.getText());	
		result.setSubCategory((Subcategory) cbSubcat.getSelectedItem());
		result.setUnidadeMedida(txtUnidadeMedida.getText());
		result.setReferencia(txtReferencia.getText());
		result.setObsComments(txtObservacao.getText());
		return result;
	}
	
	private void setScreenData(Product product){
		if (product.getId() != null) {
			txtCod.setText(String.valueOf(product.getId()));
		}
		txtCor.setText(product.getCor());
		txtDescription.setText(product.getNome());
		txtEstoqueMaximo.setText(product.getEstoqueMax());
		txtEstoqueMinimo.setText(product.getEstoqueMin());
		txtFabricante.setText(product.getFabricante());
		txtLocalEstoque.setText(product.getLocalEstoque());
		txtMarca.setText(product.getMarca());
		txtNotaFiscal.setText(product.getNotaFiscal());
		txtReferencia.setText(product.getReferencia());
		txtSerie.setText(product.getSerie());
		txtUnidadeMedida.setText(product.getUnidadeMedida());
		txtValorUnitario.setText(product.getValorUnit());
		txtObservacao.setText(product.getObsComments());
	}

	public CadastroProduto(Product product) {
		this();
		setScreenData(product);
	}
	
	public CadastroProduto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 594);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSave = new JButton("Salvar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Product p = getScreenData();
					if (p.getId() != null){
						Facade.getInstance().update(p);
					} else {
						Facade.getInstance().create(p);
					}
					JOptionPane.showMessageDialog(CadastroProduto.this, "Registro salvo com sucesso !");					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(CadastroProduto.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}	
				clearScreen();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSave.setIcon(new ImageIcon("Icones\\page_save.png"));
		btnSave.setBounds(498, 531, 89, 23);
		contentPane.add(btnSave);

		JButton btExit = new JButton("Sair");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btExit.setIcon(new ImageIcon("Icones\\door_in.png"));
		btExit.setBounds(597, 531, 89, 23);
		contentPane.add(btExit);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 67, 676, 210);
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

		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		txtDescription.setBounds(82, 26, 381, 20);
		panel.add(txtDescription);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);

		JLabel lblValorUnd = new JLabel("Valor Unit\u00E1rio");
		lblValorUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnd.setBounds(565, 103, 81, 14);
		panel.add(lblValorUnd);

		txtValorUnitario = new JTextField();
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBounds(565, 118, 101, 20);
		panel.add(txtValorUnitario);

		JLabel lblMarca = new JLabel("N\u00BA Nota Fiscal");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(473, 11, 193, 14);
		panel.add(lblMarca);

		txtNotaFiscal = new JTextField();
		txtNotaFiscal.setColumns(10);
		txtNotaFiscal.setBounds(473, 26, 193, 20);
		panel.add(txtNotaFiscal);

		JLabel lblQuantidade = new JLabel("Estoque Minimo");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(345, 103, 100, 14);
		panel.add(lblQuantidade);

		txtEstoqueMinimo = new JTextField();
		txtEstoqueMinimo.setColumns(10);
		txtEstoqueMinimo.setBounds(345, 118, 100, 20);
		panel.add(txtEstoqueMinimo);

		JLabel lblQtdMaxima = new JLabel("Estoque M\u00E1ximo");
		lblQtdMaxima.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQtdMaxima.setBounds(455, 103, 100, 14);
		panel.add(lblQtdMaxima);

		txtEstoqueMaximo = new JTextField();
		txtEstoqueMaximo.setColumns(10);
		txtEstoqueMaximo.setBounds(455, 118, 100, 20);
		panel.add(txtEstoqueMaximo);

		txtLocalEstoque = new JTextField();
		txtLocalEstoque.setColumns(10);
		txtLocalEstoque.setBounds(11, 165, 304, 20);
		panel.add(txtLocalEstoque);

		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalizao.setBounds(10, 150, 100, 14);
		panel.add(lblLocalizao);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(10, 72, 148, 20);
		panel.add(txtMarca);

		JLabel lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 100, 14);
		panel.add(lblMarca_1);

		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(168, 72, 295, 20);
		panel.add(txtFabricante);

		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(168, 57, 100, 14);
		panel.add(lblFabricante);

		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(473, 57, 193, 14);
		panel.add(lblUnidadeDeMedida);

		txtUnidadeMedida = new JTextField();
		txtUnidadeMedida.setColumns(10);
		txtUnidadeMedida.setBounds(473, 72, 193, 20);
		panel.add(txtUnidadeMedida);

		cmbFornecedor = new JComboBox<Supplier>();
		cmbFornecedor.setBounds(325, 165, 277, 20);
		panel.add(cmbFornecedor);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(325, 149, 277, 14);
		panel.add(lblFornecedor);

		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(10, 118, 100, 20);
		panel.add(txtCor);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 103, 100, 14);
		panel.add(lblCor);

		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(120, 118, 100, 20);
		panel.add(txtSerie);

		JLabel lblSrie = new JLabel("S\u00E9rie");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(120, 103, 100, 14);
		panel.add(lblSrie);

		JLabel lblReferncia = new JLabel("Refer\u00EAncia");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(235, 103, 100, 14);
		panel.add(lblReferncia);

		txtReferencia = new JTextField();
		txtReferencia.setColumns(10);
		txtReferencia.setBounds(235, 118, 100, 20);
		panel.add(txtReferencia);

		JButton btNewFornec = new JButton("");
		btNewFornec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btNewFornec.setIcon(new ImageIcon("Icones\\arrow_refresh.png"));
		btNewFornec.setToolTipText("Cadastrar Fornecedor");
		btNewFornec.setBounds(638, 157, 28, 28);
		panel.add(btNewFornec);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFornecedor view = new CadastroFornecedor();
				view.setLocationRelativeTo(null);
				view.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("Icones\\add.png"));
		button.setToolTipText("Cadastrar Fornecedor");
		button.setBounds(607, 157, 28, 28);
		panel.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 288, 676, 59);
		contentPane.add(panel_1);

		cbCatego = new JComboBox<Category>();
		cbCatego.setBounds(10, 26, 247, 20);
		panel_1.add(cbCatego);

		cbSubcat = new JComboBox<Subcategory>();
		cbSubcat.setBounds(334, 26, 264, 20);
		panel_1.add(cbSubcat);

		JButton btnNewCatego = new JButton("");
		btnNewCatego.setIcon(new ImageIcon("Icones\\arrow_refresh.png"));
		btnNewCatego.setToolTipText("Cadastar Categoria");
		btnNewCatego.setBounds(296, 18, 28, 28);
		panel_1.add(btnNewCatego);

		JLabel lblSub = new JLabel("Subcategoria");
		lblSub.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSub.setBounds(334, 11, 332, 14);
		panel_1.add(lblSub);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategoria.setBounds(10, 11, 280, 14);
		panel_1.add(lblCategoria);

		JButton btnNewSubcat = new JButton("");
		btnNewSubcat.setIcon(new ImageIcon("Icones\\arrow_refresh.png"));
		btnNewSubcat.setToolTipText("Cadastar Subcategoria");
		btnNewSubcat.setBounds(638, 18, 28, 28);
		panel_1.add(btnNewSubcat);

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("Icones\\add.png"));
		button_1.setToolTipText("Cadastrar Fornecedor");
		button_1.setBounds(262, 18, 28, 28);
		panel_1.add(button_1);

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("Icones\\add.png"));
		button_2.setToolTipText("Cadastrar Fornecedor");
		button_2.setBounds(608, 18, 28, 28);
		panel_1.add(button_2);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 358, 676, 152);
		contentPane.add(panel_2);

		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblObservaes.setBounds(10, 0, 81, 25);
		panel_2.add(lblObservaes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 656, 117);
		panel_2.add(scrollPane);

		txtObservacao = new JTextPane();
		scrollPane.setViewportView(txtObservacao);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearScreen();
			}			
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 531, 89, 23);
		contentPane.add(btnNovo);

		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroProduto.setBounds(10, 11, 676, 45);
		contentPane.add(lblCadastroProduto);
	}
}
