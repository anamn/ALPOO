package br.com.unip.frames;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class TableAluno extends JFrame {
	
	private String[] colunas = {"Matrícula","Nome","DataNasc.","CodCurso", "NomeCurso", "P1", "P2", "Media", "Faltas"};
	
	

	private DefaultTableModel dataModel;
	private JTable tableAluno;

	
	public TableAluno() {
		setTitle("Consulta Aluno");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(500, 100, 900, 600);
		getContentPane().setLayout(null);
		
		//Criando scrollPane e colocando a tabela nele
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 874, 550);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		tableAluno = new JTable(dataModel);
		scrollPane.setViewportView(tableAluno);
		dataModel = new DefaultTableModel(colunas, 0);
		tableAluno.getTableHeader().setReorderingAllowed(false);//Trava a posição dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
	

}
