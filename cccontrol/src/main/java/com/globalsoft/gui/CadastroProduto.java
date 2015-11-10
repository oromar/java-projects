package com.globalsoft.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class CadastroProduto extends JFrame {

	private static final long serialVersionUID = -5862683290614642467L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 594);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(367, 521, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(466, 521, 89, 23);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 676, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("Cod.");
		lblCod.setBounds(10, 11, 67, 14);
		panel.add(lblCod);
		
		textField = new JTextField();
		textField.setBounds(10, 26, 67, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 26, 304, 20);
		panel.add(textField_1);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(82, 11, 304, 14);
		panel.add(lblDescrio);
		
		JLabel lblValorUnd = new JLabel("Valor UND.");
		lblValorUnd.setBounds(396, 11, 81, 14);
		panel.add(lblValorUnd);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(396, 26, 67, 20);
		panel.add(textField_2);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(473, 11, 193, 14);
		panel.add(lblMarca);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(473, 26, 193, 20);
		panel.add(textField_3);
		
		JLabel lblQuantidade = new JLabel("Qtd. Minima");
		lblQuantidade.setBounds(10, 57, 100, 14);
		panel.add(lblQuantidade);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 72, 100, 20);
		panel.add(textField_4);
		
		JLabel lblQtdMaxima = new JLabel("Qtd. Maxima");
		lblQtdMaxima.setBounds(120, 57, 100, 14);
		panel.add(lblQtdMaxima);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 72, 100, 20);
		panel.add(textField_5);
	}
}
