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

public class TableAluno extends JFrame {
	
	private String[] colunas = {"Matrícula","Nome","DataNasc","CodCurso", "NomeCurso", "P1", "P2", "Media", "Faltas"};
	private String query = "SELECT * FROM Aluno";
	
	private DefaultTableModel dataModel;
	private JTable tableAluno;

	
	public TableAluno() {
		setTitle("Consulta Aluno");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(500, 100, 900, 620);
		getContentPane().setLayout(null);
		
		//Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		JMenu mn_opcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mn_opcoes);
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Escreve aqui o que o botão Cadastrar vai fazer 
			}
		});
		mn_opcoes.add(mnItn_cad);
		
		JMenuItem mnItn_excluir = new JMenuItem("Excluir");
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Escreve aqui o que o botão Excluir vai fazer
			}
		});
		mn_opcoes.add(mnItn_excluir);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		this.showData(dataModel);
		tableAluno = new JTable(dataModel);
		scrollPane.setViewportView(tableAluno);
		dataModel = new DefaultTableModel(colunas, 0);
		tableAluno.getTableHeader().setReorderingAllowed(false);              //Trava a posição dos headers da tabela
		

		
		//mostrando o frame
		setVisible(false);
	}
	
	public void showData(DefaultTableModel dataModel) {

		ConexaoSql.getConexaoMySQL();
		try {
			PreparedStatement stmt = ConexaoSql.connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int mat = rs.getInt("Matricula");
				String nome = rs.getString("Nome");
				Date dataNasc = rs.getDate("DataNasc");
				int codCurso = rs.getInt("fk_CodCurso");
				String nomeCurso = rs.getString("fk_NomeCurso");
				int p1 = rs.getInt("P1");
				int p2 = rs.getInt("P2");
				int media = rs.getInt("Media");
				int faltas = rs.getInt("Faltas");
				
				String i1 = "" + mat;
				String i2 = "" + nome;
				String i3 = "" + dataNasc;
				String i4 = "" + codCurso;
				String i5 = "" + nomeCurso;
				String i6 = "" + p1;
				String i7 = "" + p2;
				String i8 = "" + media;
				String i9 = "" + faltas;

				String[] linha = {i1, i2, i3, i4, i5, i6, i7, i8, i9};
				dataModel.addRow(linha);
			}
			stmt.close();
			ConexaoSql.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
