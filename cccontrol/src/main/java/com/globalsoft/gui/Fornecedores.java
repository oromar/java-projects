package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import com.globalsoft.entities.Supplier;
import com.globalsoft.util.Util;

public class Fornecedores extends JFrame {
	private static final long serialVersionUID = -6270253698267523322L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private Supplier fornecedorSelecionado;

	public Supplier getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	private void createTableModel(Supplier[] values) {
		String[] columns = { "Codigo", "Nome", "Telefone 1", "Telefone 2",
				"Fax", "Email" };
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] line = null;
		if (values != null && values.length > 0) {
			for (Supplier sup : values) {
				line = new String[columns.length];
				line[0] = String.valueOf(sup.getId());
				line[1] = String.valueOf(sup.getNome());
				line[2] = String.valueOf(sup.getTel1());
				line[3] = String.valueOf(sup.getTel2());
				line[4] = String.valueOf(sup.getFax());
				line[5] = String.valueOf(sup.getEmail());
				model.addRow(line);
			}
		}
		table.setModel(model);
		table.createDefaultColumnsFromModel();
	}

	/**
	 * Create the frame.
	 */
	public Fornecedores(boolean isSelectFrame) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					createTableModel(Facade.getInstance().findAllSuppliers());
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

		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String cod = (String) table.getValueAt(index, 0);
					if (cod != null && !cod.isEmpty()) {
						Long i = Long.valueOf(cod);
						try {
							Supplier sup = Facade.getInstance().findSupplier(i);
							if (sup != null) {
								CadastroFornecedor view = new CadastroFornecedor(
										sup);
								view.setLocationRelativeTo(Fornecedores.this);
								view.setVisible(true);
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnAtualizar.setIcon(new ImageIcon("Icones\\11425_32x32.png"));
		btnAtualizar.setBounds(76, 11, 56, 48);
		panel.add(btnAtualizar);

		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon("Icones\\1448763830_xfce-system-exit.png"));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(1207, 11, 65, 48);
		panel.add(btnSair);

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

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String cod = (String) table.getValueAt(index, 0);
					if (cod != null && !cod.isEmpty()) {
						Long i = Long.valueOf(cod);
						try {
							Facade.getInstance().removeSupplier(i);
							JOptionPane.showMessageDialog(Fornecedores.this,
									"Registro removido com sucesso");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnExcluir.setBounds(142, 11, 56, 48);
		panel.add(btnExcluir);

		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon("Icones\\8440_32x32.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroFornecedor view = new CadastroFornecedor();
				view.setLocationRelativeTo(Fornecedores.this);
				view.setVisible(true);
			}
		});
		btnNovo.setBounds(10, 11, 56, 48);
		panel.add(btnNovo);

		JLabel lblNovo = new JLabel("Novo");
		lblNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovo.setBounds(10, 56, 56, 25);
		panel.add(lblNovo);

		JLabel label = new JLabel("Procurar.:");
		label.setBounds(691, 27, 65, 25);
		panel.add(label);

		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFornecedores.setBounds(208, 0, 473, 81);
		panel.add(lblFornecedores);

		JButton btnSelecionar = new JButton("");
		btnSelecionar.setIcon(new ImageIcon("Icones\\Yes.png"));
		btnSelecionar.setBounds(208, 11, 56, 48);
		panel.add(btnSelecionar);
		btnSelecionar.setVisible(isSelectFrame);
		JLabel lblSelecionar = new JLabel("Selecionar");
		lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSelecionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecionar.setBounds(208, 61, 56, 14);
		panel.add(lblSelecionar);
		lblSelecionar.setVisible(isSelectFrame);
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String id = (String) table.getValueAt(index, 0);
					try {
						Supplier s = Facade.getInstance().findSupplier(Long.valueOf(id));
						if (s != null) {
							fornecedorSelecionado = s;
							Fornecedores.this.dispose();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String value = textField.getText();
				Supplier sup = null;
				try {
					if (value.isEmpty()) {
						createTableModel(Facade.getInstance()
								.findAllSuppliers());
					} else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
						if (Util.onlyNumbers(value)) {
							Long id = Long.valueOf(value);
							sup = Facade.getInstance().findSupplier(id);
							if (sup != null) {
								createTableModel(new Supplier[] { sup });
							} else {
								JOptionPane.showMessageDialog(
										Fornecedores.this,
										"Registro não encontrado.");
							}
						} else {
							sup = new Supplier();
							sup.setNome(value);
							Collection<Supplier> col = Facade.getInstance()
									.filter(sup);
							if (col != null && !col.isEmpty()) {
								createTableModel(col.toArray((Supplier[]) Array
										.newInstance(Supplier.class, col.size())));
							} else {
								JOptionPane
										.showMessageDialog(Fornecedores.this,
												"Não foram encontrados registros para os parametros passados.");
							}
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(Fornecedores.this,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		textField.setColumns(10);
		textField.setBounds(756, 27, 441, 25);
		panel.add(textField);

		JLabel lblNewLabel = new JLabel(
				"Digite o termo a ser pesquisado e pressione ENTER");
		lblNewLabel.setBounds(756, 11, 441, 14);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1282, 536);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			createTableModel(Facade.getInstance().findAllSuppliers());
		} catch (Exception e1) {
		}
	}
}
