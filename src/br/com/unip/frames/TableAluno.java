package br.com.unip.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.unip.repository.AlunoSql;
import br.com.unip.repository.CursoSql;

public class TableAluno extends JFrame {

	private String[] colunas = { "Matrícula", "Nome", "Data Nascimento", "Codigo Curso", "Nome Curso", "P1", "P2", "Media",
			"Faltas" };
	private String selectedMat;
	private int selectedRow;

	private static AlunoSql alunoSql = new AlunoSql();
	public static TelaAluno teAluno = new TelaAluno();
	private TelaInicial tela;
	private DefaultTableModel dataModel;
	private JTable tableAluno;

	public TableAluno() {
		setTitle("Consulta Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 900, 620);
		getContentPane().setLayout(null);

		// Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela = new TelaInicial();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		sairButton.setBounds(770, 527, 89, 23);
		getContentPane().add(sairButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 874, 509);
		getContentPane().add(scrollPane);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teAluno.setVisible(true);
				teAluno.cadastro();
				setVisible(false);
			}
		});
		menuBar.add(mnItn_cad);

		JMenuItem mnItn_alterar = new JMenuItem("Alterar");
		menuBar.add(mnItn_alterar);
		mnItn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlunoSql alunoSql= new AlunoSql();
				teAluno.preenche(alunoSql.pesquisa(selectedMat));
				teAluno.alterar();
				refresh();
				teAluno.setVisible(true);
				setVisible(false);
			}
		});

		JMenuItem mnItn_excluir = new JMenuItem("Excluir");
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alunoSql.delete(selectedMat);
				refresh();
			}
		});
		menuBar.add(mnItn_excluir);

		// Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		alunoSql.showData(dataModel);
		tableAluno = new JTable(dataModel);
		tableAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableAluno.getSelectedRow();
				selectedMat = (String) tableAluno.getValueAt(selectedRow, 0);
				System.out.println(selectedMat);
			}
		});
		scrollPane.setViewportView(tableAluno);

		dataModel = new DefaultTableModel(colunas, 0);
		tableAluno.getTableHeader().setReorderingAllowed(false); // Trava a posição dos headers da tabela

		// mostrando o frame
		setVisible(false);
	}

	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableAluno.getModel();
		dataModel.setRowCount(0);
		alunoSql.showData(dataModel);
	}
}
