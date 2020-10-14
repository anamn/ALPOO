package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.Choice;
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
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaAluno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() {
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_457766442100500");
		panel.setLayout(null);
		
		Label labelNome = new Label("Nome");
		labelNome.setBounds(10, 11, 71, 14);
		panel.add(labelNome);
		
		TextField nome = new TextField();
		nome.setBounds(10, 25, 146, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		Label labelMatr = new Label("Matricula");
		labelMatr.setBounds(166, 11, 71, 14);
		panel.add(labelMatr);
		
		TextField matricula = new TextField();
		matricula.setBounds(166, 25, 125, 20);
		panel.add(matricula);
		matricula.setColumns(10);
		
		Label labelData = new Label("Data de nascimento");
		labelData.setBounds(301, 11, 119, 14);
		panel.add(labelData);
		
		TextField dataNasc = new TextField();
		dataNasc.setBounds(301, 25, 112, 20);
		panel.add(dataNasc);
		dataNasc.setColumns(10);
		
		Label labelCod = new Label("Codigo Curso");
		labelCod.setBounds(10, 56, 93, 14);
		panel.add(labelCod);
		
		Choice codigoCurso = new Choice();
		codigoCurso.setBounds(10, 72, 102, 20);
		panel.add(codigoCurso);
		
		Label labelNomeCur = new Label("Nome Curso");
		labelNomeCur.setBounds(138, 56, 93, 14);
		panel.add(labelNomeCur);
		
		Choice nomeCurso = new Choice();
		nomeCurso.setBounds(138, 72, 128, 20);
		panel.add(nomeCurso);
		
		Label labelCodDisc = new Label("Codigo Disciplina");
		labelCodDisc.setBounds(10, 98, 112, 22);
		panel.add(labelCodDisc);
		
		List codDisciplina = new List();
		codDisciplina.setBounds(10, 120, 102, 88);
		panel.add(codDisciplina);
		
		Label labelNomeDis = new Label("NomeDisciplina");
		labelNomeDis.setBounds(138, 98, 62, 22);
		panel.add(labelNomeDis);
		
		List nomeDisc = new List();
		nomeDisc.setBounds(138, 120, 128, 88);
		panel.add(nomeDisc);
		
		Label labelNP1 = new Label("NP1");
		labelNP1.setBounds(291, 83, 62, 14);
		panel.add(labelNP1);
		
		TextField np1 = new TextField();
		np1.setBounds(291, 98, 53, 22);
		panel.add(np1);
		
		Label labelNP2 = new Label("NP2");
		labelNP2.setBounds(359, 83, 62, 14);
		panel.add(labelNP2);
		
		TextField np2 = new TextField();
		np2.setBounds(360, 98, 53, 22);
		panel.add(np2);
		
		Label labelMedia = new Label("Media");
		labelMedia.setBounds(291, 131, 62, 20);
		panel.add(labelMedia);
		
		TextField media = new TextField();
		media.setBounds(291, 151, 53, 22);
		panel.add(media);
		
		Label labelFaltas = new Label("Faltas");
		labelFaltas.setBounds(362, 129, 62, 22);
		panel.add(labelFaltas);
		
		TextField faltas = new TextField();
		faltas.setBounds(360, 151, 53, 22);
		panel.add(faltas);
		
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
