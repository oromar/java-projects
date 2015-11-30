package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
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

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField Tfcod;
	private JTextField TfDesc;
	private JTextField tfValUnid;
	private JTextField TfNotaFiscal;
	private JTextField tfEstoqMin;
	private JTextField tfEstoqMax;
	private JTextField tfLoca;
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
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 712, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsalve = new JButton("Salvar");
		btsalve.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btsalve.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\page_save.png"));
		btsalve.setBounds(498, 531, 89, 23);
		contentPane.add(btsalve);
		
		JButton btExit = new JButton("Sair");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btExit.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\door_in.png"));
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
		
		Tfcod = new JTextField();
		Tfcod.setEditable(false);
		Tfcod.setBounds(10, 26, 67, 20);
		panel.add(Tfcod);
		Tfcod.setColumns(10);
		
		TfDesc = new JTextField();
		TfDesc.setColumns(10);
		TfDesc.setBounds(82, 26, 381, 20);
		panel.add(TfDesc);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);
		
		JLabel lblValorUnd = new JLabel("Valor Unit\u00E1rio");
		lblValorUnd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorUnd.setBounds(565, 103, 81, 14);
		panel.add(lblValorUnd);
		
		tfValUnid = new JTextField();
		tfValUnid.setColumns(10);
		tfValUnid.setBounds(565, 118, 101, 20);
		panel.add(tfValUnid);
		
		JLabel lblMarca = new JLabel("N\u00BA Nota Fiscal");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(473, 11, 193, 14);
		panel.add(lblMarca);
		
		TfNotaFiscal = new JTextField();
		TfNotaFiscal.setColumns(10);
		TfNotaFiscal.setBounds(473, 26, 193, 20);
		panel.add(TfNotaFiscal);
		
		JLabel lblQuantidade = new JLabel("Estoque Minimo");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQuantidade.setBounds(345, 103, 100, 14);
		panel.add(lblQuantidade);
		
		tfEstoqMin = new JTextField();
		tfEstoqMin.setColumns(10);
		tfEstoqMin.setBounds(345, 118, 100, 20);
		panel.add(tfEstoqMin);
		
		JLabel lblQtdMaxima = new JLabel("Estoque M\u00E1ximo");
		lblQtdMaxima.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblQtdMaxima.setBounds(455, 103, 100, 14);
		panel.add(lblQtdMaxima);
		
		tfEstoqMax = new JTextField();
		tfEstoqMax.setColumns(10);
		tfEstoqMax.setBounds(455, 118, 100, 20);
		panel.add(tfEstoqMax);
		
		tfLoca = new JTextField();
		tfLoca.setColumns(10);
		tfLoca.setBounds(11, 165, 304, 20);
		panel.add(tfLoca);
		
		JLabel lblLocalizao = new JLabel("Localiza\u00E7\u00E3o");
		lblLocalizao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalizao.setBounds(10, 150, 100, 14);
		panel.add(lblLocalizao);
		
		TfMarca = new JTextField();
		TfMarca.setColumns(10);
		TfMarca.setBounds(10, 72, 148, 20);
		panel.add(TfMarca);
		
		JLabel lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca_1.setBounds(10, 57, 100, 14);
		panel.add(lblMarca_1);
		
		TfFabricante = new JTextField();
		TfFabricante.setColumns(10);
		TfFabricante.setBounds(168, 72, 295, 20);
		panel.add(TfFabricante);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFabricante.setBounds(168, 57, 100, 14);
		panel.add(lblFabricante);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		lblUnidadeDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUnidadeDeMedida.setBounds(473, 57, 193, 14);
		panel.add(lblUnidadeDeMedida);
		
		TfUnidMedida = new JTextField();
		TfUnidMedida.setColumns(10);
		TfUnidMedida.setBounds(473, 72, 193, 20);
		panel.add(TfUnidMedida);
		
		JComboBox cbFornece = new JComboBox();
		cbFornece.setBounds(325, 165, 277, 20);
		panel.add(cbFornece);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFornecedor.setBounds(325, 149, 277, 14);
		panel.add(lblFornecedor);
		
		tfCor = new JTextField();
		tfCor.setColumns(10);
		tfCor.setBounds(10, 118, 100, 20);
		panel.add(tfCor);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCor.setBounds(10, 103, 100, 14);
		panel.add(lblCor);
		
		tfSerie = new JTextField();
		tfSerie.setColumns(10);
		tfSerie.setBounds(120, 118, 100, 20);
		panel.add(tfSerie);
		
		JLabel lblSrie = new JLabel("S\u00E9rie");
		lblSrie.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSrie.setBounds(120, 103, 100, 14);
		panel.add(lblSrie);
		
		JLabel lblReferncia = new JLabel("Refer\u00EAncia");
		lblReferncia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReferncia.setBounds(235, 103, 100, 14);
		panel.add(lblReferncia);
		
		tfReferencia = new JTextField();
		tfReferencia.setColumns(10);
		tfReferencia.setBounds(235, 118, 100, 20);
		panel.add(tfReferencia);
		
		JButton btNewFornec = new JButton("");
		btNewFornec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btNewFornec.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\arrow_refresh.png"));
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
		button.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\add.png"));
		button.setToolTipText("Cadastrar Fornecedor");
		button.setBounds(607, 157, 28, 28);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 288, 676, 59);
		contentPane.add(panel_1);
		
		JComboBox cbCatego = new JComboBox();
		cbCatego.setBounds(10, 26, 247, 20);
		panel_1.add(cbCatego);
		
		JComboBox cbSubcat = new JComboBox();
		cbSubcat.setBounds(334, 26, 264, 20);
		panel_1.add(cbSubcat);
		
		JButton btnNewCatego = new JButton("");
		btnNewCatego.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\arrow_refresh.png"));
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
		btnNewSubcat.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\arrow_refresh.png"));
		btnNewSubcat.setToolTipText("Cadastar Subcategoria");
		btnNewSubcat.setBounds(638, 18, 28, 28);
		panel_1.add(btnNewSubcat);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\add.png"));
		button_1.setToolTipText("Cadastrar Fornecedor");
		button_1.setBounds(262, 18, 28, 28);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\add.png"));
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
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNovo.setIcon(new ImageIcon("C:\\Users\\Elias Jobs\\java-projects\\cccontrol\\Icones\\page_white_horizontal.png"));
		btnNovo.setBounds(10, 531, 89, 23);
		contentPane.add(btnNovo);
		
		JLabel lblCadastroProduto = new JLabel("Cadastro Produto");
		lblCadastroProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroProduto.setBounds(10, 11, 676, 45);
		contentPane.add(lblCadastroProduto);
	}
}
