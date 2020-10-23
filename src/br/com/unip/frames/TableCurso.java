package br.com.unip.frames;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class TableCurso extends JFrame {
	
	private String[] colunas = {"CodCurso","NomeCurso","TipoCurso","CargaHorária", "CodInstituto"};
	
	

	private DefaultTableModel dataModel;
	private JTable tableProf;

	
	public TableCurso() {
		setTitle("Consulta Curso");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(600, 100, 600, 400);
		getContentPane().setLayout(null);
		
		//Criando scrollPane e colocando a tabela nele
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 350);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf = new JTable(dataModel);
		scrollPane.setViewportView(tableProf);
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf.getTableHeader().setReorderingAllowed(false); //Trava a posição dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
	
}
