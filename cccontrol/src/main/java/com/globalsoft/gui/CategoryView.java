package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
import com.globalsoft.entities.Category;
import com.globalsoft.util.Util;

public class CategoryView extends JFrame {

	private static final long serialVersionUID = -3568920335692136733L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTable table;
	private Category selecionado;

	public Category getSelecionado() {
		return selecionado;
	}

	private void createTableModel(Category[] values) {
		String[] columns = { "Categoria" };
		DefaultTableModel model = new DefaultTableModel(columns, 0) {
			private static final long serialVersionUID = 8997062589770807215L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] line = null;
		if (values != null && values.length > 0) {
			for (Category c : values) {
				line = new String[columns.length];
				line[0] = String.valueOf(c.getNome());
				model.addRow(line);
			}
		}
		table.setModel(model);
		table.createDefaultColumnsFromModel();
	}

	public CategoryView(boolean isSelectFrame) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					createTableModel(Facade.getInstance().findAllCategory());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			public void windowLostFocus(WindowEvent e) {
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 542);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 411, 80);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = -1;
				index = table.getSelectedRow();
				try {
					if (index > -1) {
						String value = String.valueOf(table.getValueAt(index, 0));
						Category cat = new Category();
						cat.setNome(value);
						Optional<Category> opt = Facade.getInstance().filter(cat).stream().findFirst();
						if (opt.isPresent()) {
							Facade.getInstance().removeCategory(opt.get().getId());
							JOptionPane.showMessageDialog(CategoryView.this, "Registro removido com sucesso!");
							createTableModel(Facade.getInstance().findAllCategory());
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(CategoryView.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnDelete.setBounds(10, 11, 56, 48);
		panel.add(btnDelete);

		JLabel lblDelete = new JLabel("Excluir");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDelete.setBounds(10, 55, 56, 25);
		panel.add(lblDelete);

		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon("Icones\\1448763830_xfce-system-exit.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBounds(345, 11, 56, 48);
		panel.add(btnExit);

		JLabel lblExit = new JLabel("Sair");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblExit.setBounds(345, 55, 56, 25);
		panel.add(lblExit);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategoria.setBounds(142, 11, 193, 58);
		panel.add(lblCategoria);

		if (isSelectFrame) {

			JButton btnSelect = new JButton("");
			btnSelect.setIcon(new ImageIcon("Icones\\Yes.png"));
			btnSelect.setBounds(76, 11, 56, 48);
			panel.add(btnSelect);

			JLabel lblSelecionar = new JLabel("Selecionar");
			lblSelecionar.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			lblSelecionar.setBounds(76, 55, 56, 25);
			panel.add(lblSelecionar);
		}

		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setBounds(125, 111, 211, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNomeCategoria = new JLabel("Nome Da Categoria");
		lblNomeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeCategoria.setBounds(20, 102, 113, 34);
		contentPane.add(lblNomeCategoria);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 411, 343);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category cat = Util.getScreenData(CategoryView.this, Category.class);
				try {
					if (cat.getId() == null) {
						Facade.getInstance().create(cat);
					} else {
						Facade.getInstance().update(cat);
					}
					JOptionPane.showMessageDialog(CategoryView.this, "Registro salvo com sucesso.");
					Util.clearScreen(CategoryView.this);
					createTableModel(Facade.getInstance().findAllCategory());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(CategoryView.this, e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setIcon(new ImageIcon("Icones\\add.png"));
		btnAdd.setBounds(346, 102, 73, 29);
		contentPane.add(btnAdd);
	}
}
