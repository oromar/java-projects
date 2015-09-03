package com.globalsoft.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 90, 275, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(10, 146, 275, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio*");
		lblUsurio.setBounds(10, 65, 275, 14);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha *");
		lblSenha.setBounds(10, 121, 275, 14);
		contentPane.add(lblSenha);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(175, 230, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnEsqueceuSuaSenha = new JButton("Esqueceu Sua Senha ?");
		btnEsqueceuSuaSenha.setBounds(10, 196, 275, 23);
		contentPane.add(btnEsqueceuSuaSenha);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(10, 230, 109, 23);
		contentPane.add(btnSair);
		
		JLabel lblBemVindo = new JLabel("Bem - Vindo");
		lblBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setBounds(10, 11, 275, 43);
		contentPane.add(lblBemVindo);
	}
}
