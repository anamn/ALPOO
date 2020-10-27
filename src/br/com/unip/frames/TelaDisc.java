package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.com.unip.exception.CaracteresException;
import br.com.unip.exception.SqlException;
import br.com.unip.model.Disciplina;
import br.com.unip.repository.DisciplinaSql;

@SuppressWarnings("serial")
public class TelaDisc extends JFrame {

	private JPanel contentPane;
	private String[] itens = {"Aluno", "Professor", "Curso", "Disciplina"};
	private TableDisc tela;
	private int x = 0;
	
	public TelaDisc() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Disciplina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Panel panel = new Panel();
		contentPane.add(panel, "name_459451167535200");
		panel.setLayout(null);
		
		Label labelCod = new Label("C\u00F3digo");
		labelCod.setBounds(6, 57, 71, 14);
		panel.add(labelCod);
		
		TextField codigo = new TextField();
		codigo.setBounds(6, 77, 146, 20);
		panel.add(codigo);
		codigo.setColumns(10);
		
		Label labelDisci = new Label("Disciplina");
		labelDisci.setBounds(232, 57, 71, 14);
		panel.add(labelDisci);
		
		TextField nome = new TextField();
		nome.setBounds(232, 77, 152, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		Label labelCarga = new Label("Carga Hor\u00E1ria");
		labelCarga.setBounds(231, 127, 119, 14);
		panel.add(labelCarga);
		
		TextField cargaHor = new TextField();
		cargaHor.setBounds(232, 147, 146, 20);
		panel.add(cargaHor);
		cargaHor.setColumns(10);
		
		
		Label labelAula = new Label("Aulas na Semana");
		labelAula.setBounds(6, 116, 109, 22);
		panel.add(labelAula);
		
		JRadioButton segunda = new JRadioButton("Segunda");
		segunda.setBounds(6, 144, 89, 23);
		panel.add(segunda);
		
		JRadioButton terca = new JRadioButton("Ter\u00E7a");
		terca.setBounds(6, 170, 89, 23);
		panel.add(terca);
		
		JRadioButton quarta = new JRadioButton("Quarta");
		quarta.setBounds(6, 197, 89, 23);
		panel.add(quarta);
		
		JRadioButton quinta = new JRadioButton("Quinta");
		quinta.setBounds(95, 144, 109, 23);
		panel.add(quinta);
		
		JRadioButton sexta = new JRadioButton("Sexta");
		sexta.setBounds(95, 170, 109, 23);
		panel.add(sexta);
		
		JRadioButton sabado = new JRadioButton("S\u00E1bado");
		sabado.setBounds(95, 197, 109, 23);
		panel.add(sabado);
		
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				tela = new TableDisc();
				tela.setVisible(true);

			}
		});
		sairButton.setBounds(321, 243, 89, 23);
		panel.add(sairButton);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		do {
			btn_cadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						List<String> aulas= new ArrayList<String>();
						if (segunda.isSelected()) {
							aulas.add("1");
						}
						if (terca.isSelected()) {
							aulas.add("2");
						}
						if (quarta.isSelected()) {
							aulas.add("3");
						}
						if (quinta.isSelected()) {
							aulas.add("4");
						}
						if (sexta.isSelected()) {
							aulas.add("5");
						}
						if (sabado.isSelected()) {
							aulas.add("6");
						}
						if (aulas.isEmpty()) {
							throw new CaracteresException("Selecionar um dia");
						}
						Disciplina disciplina= new Disciplina(codigo.getText(),nome.getText(), cargaHor.getText(), aulas);
						DisciplinaSql sql= new DisciplinaSql();
						if (sql.add(disciplina)) {
							Message message = new Message("Cadastrado com sucesso");
							message.setVisible(true);
						}
					} catch (CaracteresException | SqlException | DateTimeParseException ex) {
						Message message = new Message(ex.getMessage());
						message.setVisible(true);
						x++;
					}
				}
			});
		} while (x > 0);
		btn_cadastrar.setBounds(210, 243, 99, 23);
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
				case "Curso":
					setVisible(false);
					TelaInicial.curso.setVisible(true);
					break;
				case "Aluno":
					setVisible(false);
					TelaInicial.aluno.setVisible(true);
				}
				
			}
		});
		comboBox.setBounds(6, 31, 146, 20);
		comboBox.setSelectedIndex(3);
		panel.add(comboBox);
		
		setVisible(false);
	}
}
