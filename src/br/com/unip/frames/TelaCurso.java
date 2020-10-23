package br.com.unip.frames;

import java.awt.CardLayout;
import java.awt.EventQueue;
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
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import br.com.unip.exception.CaracteresException;
import br.com.unip.exception.SqlException;
import br.com.unip.model.Aluno;
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;
import br.com.unip.repository.AlunoSql;
import br.com.unip.repository.CursoSql;

@SuppressWarnings("serial")
public class TelaCurso extends JFrame {

	private JPanel contentPane;
	private String[] itens = { "Aluno", "Professor", "Curso", "Disciplina" };
	private TelaInicial tela;
	private int x = 0;

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

		TextField codInst = new TextField();
		codInst.setBounds(289, 79, 112, 22);
		panel.add(codInst);

		Label labelTipo = new Label("Tipo Cuso");
		labelTipo.setBounds(236, 116, 62, 22);
		panel.add(labelTipo);

		JRadioButton outro = new JRadioButton("Outro");
		JRadioButton gestao = new JRadioButton("Gest\u00E3o");
		JRadioButton bacharel = new JRadioButton("Bacharel");
		do {
			bacharel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					gestao.setSelected(false);
					outro.setSelected(false);
				}
			});
		} while (x > 0);
		bacharel.setBounds(236, 144, 109, 23);
		panel.add(bacharel);

		gestao.setBounds(236, 170, 109, 23);
		gestao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bacharel.setSelected(false);
				outro.setSelected(false);
			}
		});
		panel.add(gestao);

		TextField outrosText = new TextField();
		outro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bacharel.setSelected(false);
				gestao.setSelected(false);
				outrosText.setBounds(300, 196, 100, 23);
				panel.add(outrosText);
			}
		});
		outro.setBounds(236, 196, 62, 23);
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
		do {
			btn_cadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						String resposta;
						if (bacharel.isSelected()) {
							resposta = "Bacharel";
						} else if (gestao.isSelected()) {
							resposta = "Gestão";
						} else if (outro.isSelected()) {
							if (outrosText.getText() != null)
								resposta = outrosText.getText();
							else
								throw new CaracteresException("Favor especificar tipo");
						} else {
							throw new CaracteresException("Selecionar um Tipo");
						}
						Curso curso = new Curso(codigo.getText(), "", resposta, codInst.getText(), cargaHor.getText());
						CursoSql sql = new CursoSql();
						if (sql.add(curso)) {
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
		btn_cadastrar.setBounds(215, 251, 99, 23);
		panel.add(btn_cadastrar);

		JComboBox comboBox = new JComboBox(itens);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = comboBox.getSelectedItem().toString();
				switch (action) {
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
