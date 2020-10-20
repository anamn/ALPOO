package br.com.unip.frames;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class TableProf extends JFrame {
	
	private String[] colunas = {"IdentProf","NomeProf","EndProf","DataNasc", "EspecProf", "TituloProf"};
	
	

	private DefaultTableModel dataModel;
	private JTable tableProf;

	
	public TableProf() {
		setTitle("Consulta Professor");
		setResizable(false);
		setBounds(600, 100, 900, 600);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Criando scrollPane e colocando a tabela nele
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 874, 550);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando � tabela
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf = new JTable(dataModel);
		scrollPane.setViewportView(tableProf);
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf.getTableHeader().setReorderingAllowed(false); //Trava a posi��o dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}

}
