package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.unip.exception.CaracteresException;
import br.com.unip.exception.SqlException;
import br.com.unip.model.Aluno;
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;
import br.com.unip.repository.AlunoSql;
import br.com.unip.repository.CursoSql;
import br.com.unip.repository.DisciplinaSql;

@SuppressWarnings("serial")
public class TelaAluno extends JFrame {

	private JPanel contentPane;
	private String[] itens = { "Aluno", "Professor", "Curso", "Disciplina" };
	private TableAluno tela;
	private int x = 0;
	private Panel panel = new Panel();
	private JButton btn_cadastrar = new JButton("Cadastrar");
	private JButton btn_alterar = new JButton("Alterar");
	private TextField nome = new TextField();
	private TextField matricula = new TextField();
	private TextField dataNasc = new TextField();
	private Choice nomeCurso = new Choice();
	public List codDisciplina = new List();
	private List nomeDisc = new List();
	private TextField np1 = new TextField();
	private TextField np2 = new TextField();
	private TextField media = new TextField();
	private TextField faltas = new TextField();

	private DisciplinaSql disciplinaSql = new DisciplinaSql();
	private java.util.List<Disciplina> disciplinas = disciplinaSql.getCods();

	private CursoSql cursoSql = new CursoSql();
	private java.util.List<Curso> cursos = cursoSql.getCods();

	public TelaAluno() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		contentPane.add(panel, "name_457766442100500");
		panel.setLayout(null);

		Label labelNome = new Label("Nome");
		labelNome.setBounds(10, 59, 71, 14);
		panel.add(labelNome);

		nome.setBounds(10, 73, 146, 20);
		panel.add(nome);
		nome.setColumns(10);

		Label labelMatr = new Label("Matricula");
		labelMatr.setBounds(166, 59, 71, 14);
		panel.add(labelMatr);

		matricula.setBounds(166, 73, 125, 20);
		panel.add(matricula);
		matricula.setColumns(10);

		Label labelData = new Label("Data de nascimento");
		labelData.setBounds(301, 59, 119, 14);
		panel.add(labelData);

		dataNasc.setBounds(301, 73, 112, 20);
		panel.add(dataNasc);
		dataNasc.setColumns(10);

		Label labelNomeCur = new Label("Nome Curso");
		labelNomeCur.setBounds(10, 104, 93, 14);
		panel.add(labelNomeCur);

		nomeCurso.setBounds(10, 120, 250, 20);
		panel.add(nomeCurso);
		for (Curso curso : cursos) {
			nomeCurso.add(curso.getNome());
		}

		Label labelNomeDis = new Label("NomeDisciplina");
		labelNomeDis.setBounds(10, 146, 112, 22);
		panel.add(labelNomeDis);

		nomeDisc.setBounds(10, 168, 250, 88);
		panel.add(nomeDisc);
		for (Disciplina disciplina : disciplinas) {
			nomeDisc.add(disciplina.getNome());
		}

		Label labelNP1 = new Label("NP1");
		labelNP1.setBounds(291, 131, 62, 14);
		panel.add(labelNP1);

		np1.setBounds(291, 146, 53, 22);
		panel.add(np1);

		Label labelNP2 = new Label("NP2");
		labelNP2.setBounds(359, 131, 62, 14);
		panel.add(labelNP2);

		np2.setBounds(360, 146, 53, 22);
		panel.add(np2);

		Label labelMedia = new Label("Media");
		labelMedia.setBounds(291, 179, 62, 20);
		panel.add(labelMedia);

		media.setBounds(291, 199, 53, 22);
		panel.add(media);

		Label labelFaltas = new Label("Faltas");
		labelFaltas.setBounds(362, 177, 62, 22);
		panel.add(labelFaltas);

		faltas.setBounds(360, 199, 53, 22);
		panel.add(faltas);

		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				tela = new TableAluno();
				tela.setVisible(true);
			}
		});
		sairButton.setBounds(325, 265, 89, 23);
		panel.add(sairButton);

		do {
			btn_cadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Aluno aluno = new Aluno(nome.getText(), matricula.getText(), dataNasc.getText(), cursoSelect(),
								discSelect());
						System.out.println(aluno);
						AlunoSql sql = new AlunoSql();
						System.out.println(aluno);
						if (sql.add(aluno)) {
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
		btn_cadastrar.setBounds(219, 265, 99, 23);

		do {
			btn_alterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Aluno aluno = new Aluno(nome.getText(), matricula.getText(), dataNasc.getText(), cursoSelect(),
								discSelect());
						AlunoSql sql = new AlunoSql();
						if (sql.altera(aluno)) {
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
		btn_alterar.setBounds(219, 265, 99, 23);

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
				case "Disciplina":
					setVisible(false);
					TelaInicial.disc.setVisible(true);
				}

			}
		});
		comboBox.setBounds(10, 11, 146, 20);
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);

		setVisible(false);
	}

	public void cadastro() {
		panel.add(btn_cadastrar);
	}

	public void preenche(Aluno aluno) {
		nome.setText(aluno.getNome());
		matricula.setText(aluno.getMatricula());
		dataNasc.setText("" + aluno.getDataNascimento());
		// codigoCurso.
		// nomeCurso
		// codDisciplina
		// nomeDisc
		np1.setText("" + aluno.getP1());
		np2.setText("" + aluno.getP2());
		media.setText("" + aluno.getMedia());
		faltas.setText("" + aluno.getFaltas());
	}

	public void alterar() {
		panel.add(btn_alterar);
	}

	public void clearCampos() {
		nome.setText("");
		matricula.setText("");
		dataNasc.setText("");
		np1.setText("");
		np2.setText("");
		media.setText("");
		faltas.setText("");

	}

	public Disciplina discSelect() {
		Disciplina disciplina1 = null;
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nomeDisc.getSelectedItem())) {
				disciplina1= disciplina;
			}
		}
		return disciplina1;
	}

	public Curso cursoSelect() {
		Curso curso1 = null;
		for (Curso curso : cursos) {
			if (curso.getNome().equals(nomeCurso.getSelectedItem())) {
				curso1 = curso;
			}
		}
		return curso1;
	}

}
