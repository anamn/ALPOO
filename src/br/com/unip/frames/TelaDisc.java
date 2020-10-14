package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Label;
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
public class TelaDisc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDisc frame = new TelaDisc();
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
	public TelaDisc() {
		setTitle("Disciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_459451167535200");
		panel.setLayout(null);
		
		Label labelCod = new Label("C\u00F3digo");
		labelCod.setBounds(10, 31, 71, 14);
		panel.add(labelCod);
		
		TextField codigo = new TextField();
		codigo.setBounds(10, 51, 146, 20);
		panel.add(codigo);
		codigo.setColumns(10);
		
		Label labelDisci = new Label("Disciplina");
		labelDisci.setBounds(236, 31, 71, 14);
		panel.add(labelDisci);
		
		TextField disciplina = new TextField();
		disciplina.setBounds(236, 51, 152, 20);
		panel.add(disciplina);
		disciplina.setColumns(10);
		
		Label labelCarga = new Label("Carga Hor\u00E1ria");
		labelCarga.setBounds(235, 101, 119, 14);
		panel.add(labelCarga);
		
		TextField cargaHor = new TextField();
		cargaHor.setBounds(236, 121, 146, 20);
		panel.add(cargaHor);
		cargaHor.setColumns(10);
		
		
		Label labelAula = new Label("Aulas na Semana");
		labelAula.setBounds(10, 90, 109, 22);
		panel.add(labelAula);
		
		JRadioButton segunda = new JRadioButton("Segunda");
		segunda.setBounds(10, 118, 89, 23);
		panel.add(segunda);
		
		JRadioButton terca = new JRadioButton("Ter\u00E7a");
		terca.setBounds(10, 144, 89, 23);
		panel.add(terca);
		
		JRadioButton quarta = new JRadioButton("Quarta");
		quarta.setBounds(10, 171, 89, 23);
		panel.add(quarta);
		
		JRadioButton quinta = new JRadioButton("Quinta");
		quinta.setBounds(99, 118, 109, 23);
		panel.add(quinta);
		
		JRadioButton sexta = new JRadioButton("Sexta");
		sexta.setBounds(99, 144, 109, 23);
		panel.add(sexta);
		
		JRadioButton sabado = new JRadioButton("S\u00E1bado");
		sabado.setBounds(99, 171, 109, 23);
		panel.add(sabado);
		
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
