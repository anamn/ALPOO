package br.com.unip.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.unip.repository.ConexaoSql;
import br.com.unip.repository.DisciplinaSql;
import br.com.unip.repository.ProfessorSql;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableProf extends JFrame {

	private String[] colunas = { "Identidade", "Nome", "Endereco", "Data Nascimento", "Especialização", "Titulo" };

	private DefaultTableModel dataModel;
	private JTable tableProf;
	public static TelaProf teProf = new TelaProf();
	private TelaInicial tela;

	private int selectedRow;
	private String selectedCpf;
	private ProfessorSql profSql = new ProfessorSql();

	public TableProf() {
		setTitle("Consulta Professor");
		setResizable(false);
		setBounds(100, 100, 900, 620);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		// Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela = new TelaInicial();
				tela.setVisible(true);
				setVisible(false);

			}
		});
		sairButton.setBounds(770, 531, 89, 23);
		getContentPane().add(sairButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 874, 513);
		getContentPane().add(scrollPane);

		// Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		profSql.showData(dataModel);
		tableProf = new JTable(dataModel);
		tableProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableProf.getSelectedRow();
				selectedCpf = (String) tableProf.getValueAt(selectedRow, 0);
			}
		});
		scrollPane.setViewportView(tableProf);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teProf.setVisible(true);
				teProf.cadastro();
				setVisible(false);
			}
		});
		menuBar.add(mnItn_cad);

		JMenuItem mnItn_alterar = new JMenuItem("Alterar");
		menuBar.add(mnItn_alterar);
		mnItn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProfessorSql professorSql= new ProfessorSql();
				teProf.preenche(professorSql.pesquisa(selectedCpf));
				teProf.alterar();
				refresh();
				teProf.setVisible(true);
				setVisible(false);
			}
		});

		JMenuItem mnItn_excluir = new JMenuItem("Excluir");
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				profSql.delete(selectedCpf);
				refresh();
			}
		});
		menuBar.add(mnItn_excluir);

		dataModel = new DefaultTableModel(colunas, 0);
		tableProf.getTableHeader().setReorderingAllowed(false); // Trava a posição dos headers da tabela

		// mostrando o frame
		setVisible(false);
	}

	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableProf.getModel();
		dataModel.setRowCount(0);
		profSql.showData(dataModel);
	}

}
