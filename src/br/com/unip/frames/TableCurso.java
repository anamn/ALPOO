package br.com.unip.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import br.com.unip.repository.ConexaoSql;
import br.com.unip.repository.CursoSql;

public class TableCurso extends JFrame {
	
	private String[] colunas = {"CodCurso","NomeCurso","TipoCurso","CargaHorária", "CodInstituto"};
	private String query = "SELECT * FROM Curso";
	private int selectedRow;
	//Variaveis pra fazer o controle de exclusão de cursos
	private String selectedCurso;
	private String codCurso;
	
	private static CursoSql cursoSql = new CursoSql();
	

	private DefaultTableModel dataModel;
	private JTable tableCurso;
	
	
	public void showData(DefaultTableModel dataModel) {

		ConexaoSql.getConexaoMySQL();
		try {
			PreparedStatement stmt = ConexaoSql.connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cod = rs.getInt("CodCurso");
				String i2 = rs.getString("NomeCurso");
				String i3 = rs.getString("TipoCurso");
				int cgHr = rs.getInt("CargaHora");
				int codIns = rs.getInt("CodInstituto");
				
				String i1 = "" + cod;
				String i4 = "" +  cgHr;
				String i5 = "" + codIns;
				String[] linha = {i1, i2, i3, i4, i5};
				dataModel.addRow(linha);
			}
			stmt.close();
			ConexaoSql.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public TableCurso() {
		setTitle("Consulta Curso");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);
		setBounds(600, 100, 600, 430);
		getContentPane().setLayout(null);
		
		//Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		sairButton.setBounds(484, 343, 89, 23);
		getContentPane().add(sairButton);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cursoSql.delete(codCurso, selectedCurso);
				refresh();
			}
		});
		btnDeletar.setBounds(385, 343, 89, 23);
		getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 574, 327);
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
		mn_opcoes.add(mnItn_excluir);
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 cursoSql.delete(codCurso, selectedCurso);
				 refresh();
			}
		});
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		this.showData(dataModel);
		tableCurso = new JTable(dataModel);
		
		
		tableCurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableCurso.getSelectedRow();
				selectedCurso = (String) tableCurso.getValueAt(selectedRow, 1);
				codCurso = (String) tableCurso.getValueAt(selectedRow, 0);
				
				System.out.println(codCurso + " " + selectedCurso);
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
		showData(dataModel);
	}
	

}
