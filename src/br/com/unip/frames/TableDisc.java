package br.com.unip.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.unip.repository.ConexaoSql;
import br.com.unip.repository.DisciplinaSql;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableDisc extends JFrame {
	
	private String[] colunas = {"CodDisc","NomeDisc","CargaHor�ria","AulasSemana"};
	private String query = "SELECT * FROM Disciplina";
	
	private int selectedRow;
	private String selectedCod, selectedDisc;
	private DisciplinaSql discSql = new DisciplinaSql();
	

	private DefaultTableModel dataModel;
	private JTable tableDisc;
	
	
	
	public void showData(DefaultTableModel dataModel) {

		ConexaoSql.getConexaoMySQL();
		try {
			PreparedStatement stmt = ConexaoSql.connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int cod = rs.getInt("CodDisc");
				String i2 = rs.getString("NomeDisc");
				int cgHr = rs.getInt("CargaHora");
				String i4 = rs.getString("AulasSem");
				
				String i1 = "" + cod;
				String i3 = "" + cgHr;
				
				
				String[] linha = {i1, i2, i3, i4};
				dataModel.addRow(linha);
			}
			stmt.close();
			ConexaoSql.connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public TableDisc() {
		setTitle("Consulta Disciplina");
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
		sairButton.setBounds(483, 339, 89, 23);
		getContentPane().add(sairButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 574, 317);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando � tabela
		dataModel = new DefaultTableModel(colunas, 0);
		this.showData(dataModel);
		tableDisc = new JTable(dataModel);
		tableDisc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedRow = tableDisc.getSelectedRow();
				selectedCod = (String) tableDisc.getValueAt(selectedRow, 0);
				selectedDisc = (String) tableDisc.getValueAt(selectedRow, 1);
			}
		});
		scrollPane.setViewportView(tableDisc);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				discSql.delete(selectedCod, selectedDisc);
				refresh();
			}
		});
		btnExcluir.setBounds(384, 339, 89, 23);
		getContentPane().add(btnExcluir);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mn_opcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mn_opcoes);
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Escreve aqui o que o bot�o Cadastrar vai fazer 
			}
		});
		mn_opcoes.add(mnItn_cad);
		
		JMenuItem mnItn_excluir = new JMenuItem("Excluir");
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				discSql.delete(selectedCod, selectedDisc); 
				refresh();
			}
		});
		mn_opcoes.add(mnItn_excluir);
		dataModel = new DefaultTableModel(colunas, 0);
		tableDisc.getTableHeader().setReorderingAllowed(false); //Trava a posi��o dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
	
	

	
	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableDisc.getModel();
		dataModel.setRowCount(0);
		showData(dataModel);
	}
	
}
