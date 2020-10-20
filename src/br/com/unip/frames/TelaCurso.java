package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaCurso extends JFrame {

	private JPanel contentPane;
	private String[] itens = {"Aluno", "Professor", "Curso", "Disciplina"};
	private TelaInicial tela;

	public TelaCurso() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_462299886657200");
		panel.setLayout(null);
		
		Label labelCod = new Label("C\u00F3digo Curso");
		labelCod.setBounds(10, 57, 91, 22);
		panel.add(labelCod);
		
		TextField codigo = new TextField();
		codigo.setBounds(10, 79, 101, 22);
		panel.add(codigo);
		
		Label labelNome = new Label("Nome do Curso");
		labelNome.setBounds(10, 116, 101, 22);
		panel.add(labelNome);
		
		List nome = new List();
		nome.setBounds(10, 144, 189, 120);
		panel.add(nome);
		
		Label labelCarga = new Label("Carga Hor\u00E1ria");
		labelCarga.setBounds(153, 57, 91, 22);
		panel.add(labelCarga);
		
		TextField cargaHor = new TextField();
		cargaHor.setBounds(153, 79, 91, 22);
		panel.add(cargaHor);
		
		Label labelCogInst = new Label("Codigo Instituto");
		labelCogInst.setBounds(289, 57, 112, 22);
		panel.add(labelCogInst);
		
		TextField textField = new TextField();
		textField.setBounds(289, 79, 112, 22);
		panel.add(textField);
		
		Label labelTipo = new Label("Tipo Cuso");
		labelTipo.setBounds(236, 116, 62, 22);
		panel.add(labelTipo);
		
		JRadioButton bacharel = new JRadioButton("Bacharel");
		bacharel.setBounds(236, 144, 109, 23);
		panel.add(bacharel);
		
		JRadioButton gestao = new JRadioButton("Gest\u00E3o");
		gestao.setBounds(236, 170, 109, 23);
		panel.add(gestao);
		
		JRadioButton outro = new JRadioButton("Outro");
		outro.setBounds(236, 196, 109, 23);
		panel.add(outro);
		
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				tela = new TelaInicial();
				tela.setVisible(true);
			}
		});
		sairButton.setBounds(325, 251, 89, 23);
		panel.add(sairButton);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.setBounds(215, 251, 99, 23);
		panel.add(btn_cadastrar);
		
		JComboBox comboBox = new JComboBox(itens);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = comboBox.getSelectedItem().toString();
				switch(action) {
				case "Professor":
					setVisible(false);
					TelaInicial.prof.setVisible(true);
					break;
				case "Aluno":
					setVisible(false);
					TelaInicial.aluno.setVisible(true);
					break;
				case "Disciplina":
					setVisible(false);
					TelaInicial.disc.setVisible(true);
				}
				
			}
		});
		comboBox.setBounds(10, 11, 146, 20);
		comboBox.setSelectedIndex(2);
		panel.add(comboBox);
		
		setVisible(false);
	}
}
