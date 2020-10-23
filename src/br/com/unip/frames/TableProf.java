package br.com.unip.frames;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TableProf extends JFrame {
	
	private String[] colunas = {"IdentProf","NomeProf","EndProf","DataNasc", "EspecProf", "TituloProf"};
	
	

	private DefaultTableModel dataModel;
	private JTable tableProf;

	
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
		tableProf = new JTable(dataModel);
		scrollPane.setViewportView(tableProf);
		
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
				//Escreve aqui o que o botão escluir vai fazer 
			}
		});
		mn_opcoes.add(mnItn_excluir);
		
		dataModel = new DefaultTableModel(colunas, 0);
		tableProf.getTableHeader().setReorderingAllowed(false); //Trava a posição dos headers da tabela
		
		//mostrando o frame
		setVisible(false);
	}
}
