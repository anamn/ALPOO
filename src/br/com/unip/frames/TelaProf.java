package br.com.unip.frames;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class TelaProf extends JFrame {

	private JPanel contentPane;
	private String[] itens = {"Aluno", "Professor", "Curso", "Disciplina"};
	private TelaInicial tela;

	public TelaProf() {
		setLocationRelativeTo(null);
		setResizable(false);
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Telas
		Panel panel = new Panel();
		contentPane.add(panel, "name_108138278340100");
		panel.setLayout(null);
		
		JButton sairButton = new JButton("Voltar");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				tela = new TelaInicial();
				tela.setVisible(true);

			}
		});
		sairButton.setBounds(327, 251, 89, 23);
		panel.add(sairButton);
		
		TextField nome = new TextField();
		nome.setBounds(12, 59, 146, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		Label labelNome = new Label("Nome");
		labelNome.setBounds(12, 45, 71, 14);
		panel.add(labelNome);
		
		Label labelIdent = new Label("Identificador");
		labelIdent.setBounds(168, 45, 71, 14);
		panel.add(labelIdent);
		
		TextField dataNasc = new TextField();
		dataNasc.setBounds(303, 59, 112, 20);
		panel.add(dataNasc);
		dataNasc.setColumns(10);
		
		TextField identificador = new TextField();
		identificador.setBounds(168, 59, 125, 20);
		panel.add(identificador);
		identificador.setColumns(10);
		
		Label labelData = new Label("Data de nascimento");
		labelData.setBounds(303, 45, 119, 14);
		panel.add(labelData);
		
		TextField endereco = new TextField();
		endereco.setBounds(12, 106, 146, 20);
		panel.add(endereco);
		endereco.setColumns(10);
		
		Label labelEnd = new Label("Endere\u00E7o");
		labelEnd.setBounds(12, 90, 93, 14);
		panel.add(labelEnd);
		
		TextField bairroProf = new TextField();
		bairroProf.setBounds(177, 106, 71, 20);
		panel.add(bairroProf);
		bairroProf.setColumns(10);
		
		Label labelBairro = new Label("Bairro");
		labelBairro.setBounds(177, 90, 46, 14);
		panel.add(labelBairro);
		
		TextField cidade = new TextField();
		cidade.setBounds(268, 106, 71, 20);
		panel.add(cidade);
		cidade.setColumns(10);
		
		Label labelCidade = new Label("Cidade");
		labelCidade.setBounds(268, 90, 46, 14);
		panel.add(labelCidade);
		
		TextField estado = new TextField();
		estado.setBounds(357, 106, 59, 20);
		panel.add(estado);
		estado.setColumns(10);
		
		Label labelEstado = new Label("Estado");
		labelEstado.setBounds(359, 90, 46, 14);
		panel.add(labelEstado);
		
		TextField telefone = new TextField();
		telefone.setBounds(12, 150, 93, 20);
		panel.add(telefone);
		telefone.setColumns(10);
		
		Label labelTel = new Label("Telefone ");
		labelTel.setBounds(12, 137, 71, 14);
		panel.add(labelTel);
		
		TextField celular = new TextField();
		celular.setBounds(121, 150, 86, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		Label labelCel = new Label("Celular");
		labelCel.setBounds(121, 137, 59, 14);
		panel.add(labelCel);
		
		Label labelEspe = new Label("Especialidade");
		labelEspe.setBounds(231, 137, 83, 14);
		panel.add(labelEspe);
		
		Checkbox digito = new Checkbox("Digito");
		digito.setBounds(230, 150, 95, 22);
		panel.add(digito);
		
		Checkbox matematica = new Checkbox("Matem\u00E1tica");
		matematica.setBounds(331, 150, 95, 22);
		panel.add(matematica);
		
		Checkbox informatica = new Checkbox("Inform\u00E1tica");
		informatica.setBounds(231, 169, 95, 22);
		panel.add(informatica);
		
		Checkbox medicina = new Checkbox("Medicina");
		medicina.setBounds(331, 169, 95, 22);
		panel.add(medicina);
		
		Label labelTitulo = new Label("Titulo");
		labelTitulo.setBounds(12, 176, 62, 22);
		panel.add(labelTitulo);
		
		Checkbox bacharel = new Checkbox("Bacharel");
		bacharel.setBounds(10, 192, 95, 22);
		panel.add(bacharel);
		
		Checkbox mestrado = new Checkbox("Mestrado");
		mestrado.setBounds(10, 215, 95, 22);
		panel.add(mestrado);
		
		Checkbox doutorado = new Checkbox("Doutorado");
		doutorado.setBounds(112, 192, 95, 22);
		panel.add(doutorado);
		
		Checkbox especLS = new Checkbox("Especialista Lato Sensu");
		especLS.setBounds(112, 215, 146, 22);
		panel.add(especLS);
		
		Checkbox outros = new Checkbox("Outros");
		outros.setBounds(331, 192, 95, 22);
		panel.add(outros);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_cadastrar.setBounds(217, 251, 99, 23);
		panel.add(btn_cadastrar);
		
		JComboBox comboBox = new JComboBox(itens);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String action = comboBox.getSelectedItem().toString();
				switch(action) {
				case "Aluno":
					setVisible(false);
					TelaInicial.aluno.setVisible(true);
					break;
				case "Curso":
					setVisible(false);
					TelaInicial.curso.setVisible(true);
					break;
				case "Disciplina":
					setVisible(false);
					TelaInicial.disc.setVisible(true);
				}
				
			}
		});
		comboBox.setBounds(10, 11, 146, 20);
		comboBox.setSelectedIndex(1);
		panel.add(comboBox);
		
		setVisible(false);
	}
}
