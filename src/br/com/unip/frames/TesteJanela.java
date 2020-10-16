package br.com.unip.frames;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TesteJanela extends JFrame {
	
	String[] Itens = { "Cadastrar", "Alterar", "Excluir"};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public TesteJanela() {
		
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox(Itens);
		comboBox.setBounds(10, 11, 140, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(64, 42, 125, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 73, 125, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(64, 104, 125, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 45, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(10, 76, 46, 14);
		getContentPane().add(lblRa);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setBounds(10, 107, 46, 14);
		getContentPane().add(lblCurso);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(10, 228, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
