package com.globalsoft.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Collection;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.globalsoft.business.Facade;
import com.globalsoft.entities.Category;
import com.globalsoft.entities.SubCategory;
import com.globalsoft.util.Util;

public class SubCategoryView extends JFrame {

	private static final long serialVersionUID = 6424241348272750531L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTable table;
	private Category selecionado;
	private JComboBox<Category> cmbCategoria;
	
	private String[] columnNames = {"Nome", "Categoria"};

	public Category getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Category selecionado) {
		this.selecionado = selecionado;
	}
	
	private void createTable(){
		try {
			Util.createTableModel(table, columnNames, Facade.getInstance().findAllSubCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public SubCategoryView(boolean isSelectFrame) {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				createTable();
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
			public void actionPerformed(ActionEvent e) {
				int index = -1;
				index = table.getSelectedRow();
				if (index > -1) {
					String value = String.valueOf(table.getValueAt(index, 0));
					if (value != null && !value.isEmpty()){
						SubCategory sub = new SubCategory();
						sub.setNome(value);
						Optional<SubCategory> opt  = Facade.getInstance().filter(sub).stream().findFirst();
						if (opt.isPresent()) {
							try {
								Facade.getInstance().removeSubCategory(opt.get().getId());
								Util.showDeleteRecordSuccessMessage(SubCategoryView.this);
								createTable();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("Icones\\Delete.png"));
		btnDelete.setBounds(10, 11, 56, 48);
		panel.add(btnDelete);

		JLabel lblDelete = new JLabel("Delete");
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

		JLabel lblCategoria = new JLabel("SubCategoria");
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
		txtNome.setBounds(133, 140, 205, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNomeCategoria = new JLabel("Nome Da SubCategoria");
		lblNomeCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeCategoria.setBounds(12, 131, 123, 34);
		contentPane.add(lblNomeCategoria);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 411, 309);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SubCategory sub = Util.getScreenData(SubCategoryView.this, SubCategory.class);
					if (sub.getId() == null) {
						Facade.getInstance().create(sub);
					} else {
						Facade.getInstance().update(sub);
					}
					Util.showSaveRecordSuccessMessage(SubCategoryView.this);
					Util.clearScreen(SubCategoryView.this);
					createTable();					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdd.setIcon(new ImageIcon("Icones\\add.png"));
		btnAdd.setBounds(348, 131, 73, 29);
		contentPane.add(btnAdd);

		JLabel labelCategoria = new JLabel("Categoria");
		labelCategoria.setBounds(10, 112, 113, 14);
		contentPane.add(labelCategoria);

		cmbCategoria= new JComboBox<Category>();
		cmbCategoria.setBounds(132, 102, 206, 22);
		Category[] categorias;
		try {
			categorias = Facade.getInstance().findAllCategory();
			for (Category c : categorias) {
				cmbCategoria.addItem(c);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		contentPane.add(cmbCategoria);
	}
}