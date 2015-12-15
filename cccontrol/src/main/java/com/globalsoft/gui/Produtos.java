package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.lang.reflect.Array;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.Product;
import com.globalsoft.util.Util;

public class Produtos extends JFrame {

	private static final long serialVersionUID = 1948328249961547185L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPesquisar;

	/**
	 * Create the frame.
	 */
	public Produtos() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					createTableOfProducts(Facade.getInstance().findAllProducts());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1318, 706);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmNovoProduto = new JMenuItem("Novo Produto");
		mntmNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroProduto tela = new CadastroProduto();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
			}
		});
		mnArquivo.add(mntmNovoProduto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 1282, 81);
		contentPane.add(panel);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String id = (String) table.getValueAt(index, 0);
					try {
						Product p = Facade.getInstance().findProduct(Long.valueOf(id));
						if (p != null) {
							CadastroProduto cadastro = new CadastroProduto(p);
							cadastro.setVisible(true);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button.setIcon(new ImageIcon("Icones\\11425_32x32.png"));
		button.setBounds(76, 11, 56, 48);
		panel.add(button);

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("Icones\\1448763830_xfce-system-exit.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_2.setBounds(1207, 11, 65, 48);
		panel.add(button_2);

		JLabel lblAtualizar = new JLabel("Atualizar");
		lblAtualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAtualizar.setBounds(76, 56, 56, 25);
		panel.add(lblAtualizar);

		JLabel label_2 = new JLabel("Sair");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(1207, 56, 65, 25);
		panel.add(label_2);

		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExcluir.setBounds(142, 56, 56, 25);
		panel.add(lblExcluir);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String id = (String) table.getValueAt(index, 0);
					try {
						if (JOptionPane.showConfirmDialog(Produtos.this, "Tem certeza ?") == JOptionPane.YES_OPTION) {
							Facade.getInstance().removeProduct(Long.valueOf(id));
							JOptionPane.showMessageDialog(Produtos.this, "Produto removido com sucesso.");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		button_1.setIcon(new ImageIcon("Icones\\Delete.png"));
		button_1.setBounds(142, 11, 56, 48);
		panel.add(button_1);

		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("Icones\\8440_32x32.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroProduto view = new CadastroProduto();
				view.setLocationRelativeTo(null);
				view.setVisible(true);

			}
		});
		button_3.setBounds(10, 11, 56, 48);
		panel.add(button_3);

		JLabel lblNovo = new JLabel("Novo");
		lblNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovo.setBounds(10, 56, 56, 25);
		panel.add(lblNovo);

		JLabel label = new JLabel("Procurar.:");
		label.setBounds(691, 27, 65, 25);
		panel.add(label);

		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProdutos.setBounds(208, 0, 473, 81);
		panel.add(lblProdutos);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPesquisar.getText().isEmpty()) {
					try {
						createTableOfProducts(Facade.getInstance().findAllProducts());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					String value = txtPesquisar.getText();
					if (Util.onlyNumbers(value)) {
						Long i = Long.valueOf(value);
						try {
							Product p = Facade.getInstance().findProduct(i);
							if (p != null) {
								Product[] array = { p };
								createTableOfProducts(array);
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} else {
						Product product = new Product();
						product.setNome(value);
						Collection<Product> collection = Facade.getInstance().filter(product);
						createTableOfProducts(
								collection.toArray((Product[]) Array.newInstance(Product.class, collection.size())));
					}

				}
			}
		});
		txtPesquisar.setColumns(10);
		txtPesquisar.setBounds(756, 27, 441, 25);
		panel.add(txtPesquisar);
		
		JLabel lblDigiteAPesquisa = new JLabel("Digite o termo a ser pesquisado e pressione ENTER");
		lblDigiteAPesquisa.setBounds(756, 11, 280, 14);
		panel.add(lblDigiteAPesquisa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

			}
		});
		scrollPane.setBounds(20, 99, 1282, 536);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		try {
			createTableOfProducts(Facade.getInstance().findAllProducts());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(Produtos.this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void createTableOfProducts(Product[] products) {
		String[] columnNames = { "Código", "Descricao", "Estoque" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (products != null && products.length > 0) {
			String[] line = null;
			for (Product p : products) {
				line = new String[3];
				line[0] = String.valueOf(p.getId());
				line[1] = p.getNome();
				line[2] = p.getEmEstoque();
				model.addRow(line);
			}
		}
		table.setModel(model);
		table.createDefaultColumnsFromModel();
	}
}
