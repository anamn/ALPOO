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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaCurso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCurso frame = new TelaCurso();
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
	public TelaCurso() {
		setTitle("Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_462299886657200");
		panel.setLayout(null);
		
		Label labelCod = new Label("C\u00F3digo Curso");
		labelCod.setBounds(10, 23, 91, 22);
		panel.add(labelCod);
		
		TextField codigo = new TextField();
		codigo.setBounds(10, 45, 101, 22);
		panel.add(codigo);
		
		Label labelNome = new Label("Nome do Curso");
		labelNome.setBounds(10, 82, 101, 22);
		panel.add(labelNome);
		
		List nome = new List();
		nome.setBounds(10, 110, 189, 120);
		panel.add(nome);
		
		Label labelCarga = new Label("Carga Hor\u00E1ria");
		labelCarga.setBounds(153, 23, 91, 22);
		panel.add(labelCarga);
		
		TextField cargaHor = new TextField();
		cargaHor.setBounds(153, 45, 91, 22);
		panel.add(cargaHor);
		
		Label labelCogInst = new Label("Codigo Instituto");
		labelCogInst.setBounds(289, 23, 112, 22);
		panel.add(labelCogInst);
		
		TextField textField = new TextField();
		textField.setBounds(289, 45, 112, 22);
		panel.add(textField);
		
		Label labelTipo = new Label("Tipo Cuso");
		labelTipo.setBounds(236, 82, 62, 22);
		panel.add(labelTipo);
		
		JRadioButton bacharel = new JRadioButton("Bacharel");
		bacharel.setBounds(236, 110, 109, 23);
		panel.add(bacharel);
		
		JRadioButton gestao = new JRadioButton("Gest\u00E3o");
		gestao.setBounds(236, 136, 109, 23);
		panel.add(gestao);
		
		JRadioButton outro = new JRadioButton("Outro");
		outro.setBounds(236, 162, 109, 23);
		panel.add(outro);
		
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sairButton.setBounds(325, 217, 89, 23);
		panel.add(sairButton);
		
		JButton btnNewButton = new JButton("Confirma");
		btnNewButton.setBounds(229, 217, 89, 23);
		panel.add(btnNewButton);
	}
}
