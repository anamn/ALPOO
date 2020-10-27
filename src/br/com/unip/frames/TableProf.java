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
import br.com.unip.repository.ProfessorSql;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableProf extends JFrame {
	
	private String[] colunas = {"IdentProf","NomeProf","EndProf","DataNasc", "EspecProf", "TituloProf"};
	private String query = "SELECT * FROM Professor";

	private DefaultTableModel dataModel;
	private JTable tableProf;
	
	private int selectedRow;
	private String selectedCpf;
	private ProfessorSql profSql = new ProfessorSql();
	
	
	public void showData(DefaultTableModel dataModel) {

		ConexaoSql.getConexaoMySQL();
		try {
			PreparedStatement stmt = ConexaoSql.connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String i1 = rs.getString("CpfProf");
				String i2 = rs.getString("NomeProf");
				String rua = rs.getString("EndProf");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				Date date = rs.getDate("DataNasc");
				String i5 = rs.getString("SpecProf");
				String i6 = rs.getString("TituloProf");
				
				String i3 = rua + " " + bairro + " " + cidade;
				String i4 = "" + date;
				
				String[] linha = {i1, i2, i3, i4, i5, i6};
				dataModel.addRow(linha);
			}
			stmt.close();
			ConexaoSql.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
	public TableProf() {
		setTitle("Consulta Professor");
		setResizable(false);
		setBounds(600, 100, 900, 620);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		//Criando scrollPane e colocando a tabela nele
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		sairButton.setBounds(770, 531, 89, 23);
		getContentPane().add(sairButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 874, 513);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		this.showData(dataModel);
		tableProf = new JTable(dataModel);
		tableProf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableProf.getSelectedRow();
				selectedCpf = (String) tableProf.getValueAt(selectedRow, 0);
			}
		});
		scrollPane.setViewportView(tableProf);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profSql.delete(selectedCpf);
				refresh();
			}
		});
		btnExcluir.setBounds(671, 531, 89, 23);
		getContentPane().add(btnExcluir);
		
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
				profSql.delete(selectedCpf);
				refresh();
			}
		});
		mn_opcoes.add(mnItn_excluir);
		
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf.getTableHeader().setReorderingAllowed(false); //Trava a posição dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
	
	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableProf.getModel();
		dataModel.setRowCount(0);
		showData(dataModel);
	}
	
	


}
