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
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;
import br.com.unip.repository.DisciplinaSql;

@SuppressWarnings("serial")
public class TelaDisc extends JFrame {

	private JPanel contentPane;
	private String[] itens = { "Aluno", "Professor", "Curso", "Disciplina" };
	private TableDisc tela;
	private int x = 0;
	private Panel panel = new Panel();
	private JButton btn_cadastrar = new JButton("Cadastrar");
	private JButton btn_alterar = new JButton("Alterar");
	private TextField codigo = new TextField();
	private TextField nome = new TextField();
	private TextField cargaHor = new TextField();
	private JRadioButton segunda = new JRadioButton("Segunda");
	private JRadioButton terca = new JRadioButton("Ter\u00E7a");
	private JRadioButton quarta = new JRadioButton("Quarta");
	private JRadioButton quinta = new JRadioButton("Quinta");
	private JRadioButton sexta = new JRadioButton("Sexta");
	private JRadioButton sabado = new JRadioButton("S\u00E1bado");
	


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

		contentPane.add(panel, "name_459451167535200");
		panel.setLayout(null);

		Label labelCod = new Label("C\u00F3digo");
		labelCod.setBounds(6, 57, 71, 14);
		panel.add(labelCod);

		codigo.setBounds(6, 77, 146, 20);
		panel.add(codigo);
		codigo.setColumns(10);

		Label labelDisci = new Label("Disciplina");
		labelDisci.setBounds(232, 57, 71, 14);
		panel.add(labelDisci);

		nome.setBounds(232, 77, 152, 20);
		panel.add(nome);
		nome.setColumns(10);

		Label labelCarga = new Label("Carga Hor\u00E1ria");
		labelCarga.setBounds(231, 127, 119, 14);
		panel.add(labelCarga);

		cargaHor.setBounds(232, 147, 146, 20);
		panel.add(cargaHor);
		cargaHor.setColumns(10);

		Label labelAula = new Label("Aulas na Semana");
		labelAula.setBounds(6, 116, 109, 22);
		panel.add(labelAula);

		segunda.setBounds(6, 144, 89, 23);
		panel.add(segunda);

		terca.setBounds(6, 170, 89, 23);
		panel.add(terca);

		quarta.setBounds(6, 197, 89, 23);
		panel.add(quarta);

		quinta.setBounds(95, 144, 109, 23);
		panel.add(quinta);

		sexta.setBounds(95, 170, 109, 23);
		panel.add(sexta);

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

		do {
			btn_cadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						List<String> aulas = new ArrayList<String>();
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
						Disciplina disciplina = new Disciplina(codigo.getText(), nome.getText(), cargaHor.getText(),
								aulas);
						DisciplinaSql sql = new DisciplinaSql();
						if (sql.add(disciplina)) {
							Message message = new Message("Cadastrado com sucesso");
							message.setVisible(true);
							clearCampos();
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

		do {
			btn_alterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						List<String> aulas = new ArrayList<String>();
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
						Disciplina disciplina = new Disciplina(codigo.getText(), nome.getText(), cargaHor.getText(),
								aulas);
						DisciplinaSql sql = new DisciplinaSql();
						if (sql.altera(disciplina)) {
							Message message = new Message("Alterado com sucesso");
							message.setVisible(true);
							clearCampos();
						}
					} catch (CaracteresException | SqlException | DateTimeParseException ex) {
						Message message = new Message(ex.getMessage());
						message.setVisible(true);
						x++;
					}
				}
			});
		} while (x > 0);
		btn_alterar.setBounds(210, 243, 99, 23);
		
		JComboBox comboBox = new JComboBox(itens);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = comboBox.getSelectedItem().toString();
				switch (action) {
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

	public void cadastro() {
		panel.add(btn_cadastrar);
	}

	public void preenche(Disciplina disciplina) {
		codigo.setText(disciplina.getCodigo());
		cargaHor.setText(disciplina.getCargaHoraria());
		nome.setText(disciplina.getNome());
		if (!disciplina.getAulas().isEmpty()) {
			if (disciplina.getAulas().contains("1")) {
				segunda.setSelected(true);
			}
			if (disciplina.getAulas().contains("2")) {
				terca.setSelected(true);
			}
			if (disciplina.getAulas().contains("3")) {
				quarta.setSelected(true);
			}
			if (disciplina.getAulas().contains("4")) {
				quinta.setSelected(true);
			}
			if (disciplina.getAulas().contains("5")) {
				sexta.setSelected(true);
			}
			if (disciplina.getAulas().contains("6")) {
				sabado.setSelected(true);
			}
		}
	}

	public void alterar() {
		panel.add(btn_alterar);
	}
	
	public void clearCampos() {
		codigo.setText("");
		nome.setText("");
		cargaHor.setText("");
		segunda.setSelected(false);
		terca.setSelected(false);
		quarta.setSelected(false);
		quinta.setSelected(false);
		sexta.setSelected(false);
		sabado.setSelected(false);
	}
}
