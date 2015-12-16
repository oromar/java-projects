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
import java.util.Optional;

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
import com.globalsoft.entities.Requester;
import com.globalsoft.util.Util;

public class Solicitantes extends JFrame {

	private static final long serialVersionUID = -3486102969406784851L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	private void createTableModel(Requester[] values){
		String[] columns = {"Matrícula", "Nome"};
		DefaultTableModel model = new DefaultTableModel(columns, 0){
			private static final long serialVersionUID = 8997062589770807215L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}};
			String[] line = null;
			if (values != null && values.length > 0) {
				for (Requester r : values){
					line = new String[columns.length];
					line[0] = String.valueOf(r.getMatricula());
					line[1] = String.valueOf(r.getNome());
					model.addRow(line);				
				}
			}
			table.setModel(model);
			table.createDefaultColumnsFromModel();
	}

	/**
	 * Create the frame.
	 */
	public Solicitantes() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				try {
					createTableModel(Facade.getInstance().findAllRequesters());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
					String matricula = String.valueOf(table.getValueAt(index, 0));
					Requester req = new Requester();
					req.setMatricula(matricula);
					Optional<Requester> optReq = Facade.getInstance().filter(req).stream().findFirst();
					if (optReq.isPresent()){
						CadastroSolicitante view = new CadastroSolicitante(optReq.get());
						view.setLocationRelativeTo(Solicitantes.this);
						view.setVisible(true);
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
					String matricula = String.valueOf(table.getValueAt(index, 0));
					Requester req = new Requester();
					req.setMatricula(matricula);
					Optional<Requester> optReq = Facade.getInstance().filter(req).stream().findFirst();
					if (optReq.isPresent()){
						if (JOptionPane.showConfirmDialog(Solicitantes.this, "Tem certeza", "Confirma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
							try {
								Facade.getInstance().removeRequester(optReq.get().getId());
								JOptionPane.showMessageDialog(Solicitantes.this, "Removido com sucesso.");
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					}					
				}
			}
		});
		button_1.setIcon(new ImageIcon("Icones\\Delete.png"));
		button_1.setBounds(142, 11, 56, 48);
		panel.add(button_1);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					String value = textField.getText(); 
					if (value.isEmpty()) {
						createTableModel(Facade.getInstance().findAllRequesters());
					} else if (e.getKeyChar() == KeyEvent.VK_ENTER) {
						Requester r = new Requester();
						if (Util.onlyNumbers(value)) {
							r.setMatricula(value);							 
						} else {
							r.setNome(value);
						}
						Collection<Requester> col = Facade.getInstance().filter(r);
						if (col != null && !col.isEmpty()) {
							createTableModel(col.toArray((Requester[])Array.newInstance(Requester.class, col.size())));
						} else {
							JOptionPane.showMessageDialog(Solicitantes.this, "Não foram encontrados registros para os parâmetros informados.");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		textField.setBounds(770, 27, 427, 25);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblProcurar = new JLabel("Procurar.:");
		lblProcurar.setBounds(705, 27, 65, 25);
		panel.add(lblProcurar);

		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("Icones\\8440_32x32.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroSolicitante view = new CadastroSolicitante();
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

		JLabel lblProdutos = new JLabel("Solicitante");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutos.setBounds(222, 0, 473, 81);
		panel.add(lblProdutos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 99, 1282, 536);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
