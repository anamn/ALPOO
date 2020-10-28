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
import br.com.unip.repository.DisciplinaSql;

public class TableDisc extends JFrame {
	
	private String[] colunas = {"Codigo","Nome","Carga Horária","Aulas Semanais"};
	
	private int selectedRow;
	private String selectedCod, selectedDisc;
	private DisciplinaSql discSql = new DisciplinaSql();
	private TelaInicial tela;
	public static TelaDisc teDisc = new TelaDisc();
	
	private DefaultTableModel dataModel;
	private JTable tableDisc;

	
	public TableDisc() {
		setTitle("Consulta Disciplina");
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
		sairButton.setBounds(483, 339, 89, 23);
		getContentPane().add(sairButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 574, 317);
		getContentPane().add(scrollPane);
		
		//Inicializando DataModel e adicionando à tabela
		dataModel = new DefaultTableModel(colunas, 0);
		discSql.showData(dataModel);
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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mnItn_cad = new JMenuItem("Cadastrar");
		mnItn_cad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teDisc.setVisible(true);
				teDisc.cadastro();
				setVisible(false);			}
		});
		menuBar.add(mnItn_cad);
		
		JMenuItem mnItn_alterar = new JMenuItem("Alterar");
		menuBar.add(mnItn_alterar);
		mnItn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DisciplinaSql disciplinaSql= new DisciplinaSql();
				teDisc.preenche(disciplinaSql.pesquisa(selectedCod, selectedDisc));
				teDisc.alterar();
				refresh();
				teDisc.setVisible(true);
				setVisible(false);
			}
		});
		
		JMenuItem mnItn_excluir = new JMenuItem("Excluir");
		mnItn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				discSql.delete(selectedCod, selectedDisc); 
				refresh();
			}
		});
		menuBar.add(mnItn_excluir);
		dataModel = new DefaultTableModel(colunas, 0);
		tableDisc.getTableHeader().setReorderingAllowed(false); //Trava a posição dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
	
	

	
	public void refresh() {
		DefaultTableModel dataModel = (DefaultTableModel) tableDisc.getModel();
		dataModel.setRowCount(0);
		discSql.showData(dataModel);
	}
	
}
