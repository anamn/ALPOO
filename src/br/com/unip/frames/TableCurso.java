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

import br.com.unip.repository.CursoSql;

public class TableCurso extends JFrame {
	
	private String[] colunas = {"Codigo","Nome","Tipo","Carga Horária", "Codigo Instituto"};
	private int selectedRow;
	//Variaveis pra fazer o controle de exclusão de cursos
	private String selectedCurso;
	private String codCurso;
	
	private static CursoSql cursoSql = new CursoSql();
	public static TelaCurso teCurso= new TelaCurso();
	private TelaInicial tela;
	
	private DefaultTableModel dataModel;
	private JTable tableCurso;
	
	public TableCurso() {
		setTitle("Consulta Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 600, 430);
		getContentPane().setLayout(null);
		
		//Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela = new TelaInicial();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		sairButton.setBounds(484, 343, 89, 23);
		getContentPane().add(sairButton);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 327);
		getContentPane().add(scrollPane);
		
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teCurso.setVisible(true);
				teCurso.cadastro();
				setVisible(false);
			}
		});
		menuBar.add(mnItn_cad);
		
		JMenuItem mnItn_alterar = new JMenuItem("Alterar");
		menuBar.add(mnItn_alterar);
		mnItn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CursoSql cursosql= new CursoSql();
				teCurso.preenche(cursosql.pesquisa(codCurso, selectedCurso));
				teCurso.alterar();
				refresh();
				teCurso.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem btnDeletar = new JMenuItem("Excluir");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cursoSql.delete(codCurso, selectedCurso);
				refresh();
			}
		});
		menuBar.add(btnDeletar);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		cursoSql.showdata(dataModel);
		tableCurso = new JTable(dataModel);
		
		
		tableCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableCurso.getSelectedRow();
				selectedCurso = (String) tableCurso.getValueAt(selectedRow, 1);
				codCurso = (String) tableCurso.getValueAt(selectedRow, 0);
			}
		});
		scrollPane.setViewportView(tableCurso);
		

		dataModel = new DefaultTableModel(colunas, 0);
		tableCurso.getTableHeader().setReorderingAllowed(false); //Trava a posição dos headers da tabela
		
		

		//mostrando o frame
		setVisible(false);
	}
	

	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableCurso.getModel();
		dataModel.setRowCount(0);
		cursoSql.showdata(dataModel);
	}
	

}
