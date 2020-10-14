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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaProf extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProf frame = new TelaProf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProf() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Telas
		Panel panel = new Panel();
		contentPane.add(panel, "name_108138278340100");
		panel.setLayout(null);
		
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sairButton.setBounds(325, 217, 89, 23);
		panel.add(sairButton);
		
		TextField nome = new TextField();
		nome.setBounds(10, 25, 146, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		Label labelNome = new Label("Nome");
		labelNome.setBounds(10, 11, 71, 14);
		panel.add(labelNome);
		
		Label labelIdent = new Label("Identificador");
		labelIdent.setBounds(166, 11, 71, 14);
		panel.add(labelIdent);
		
		TextField dataNasc = new TextField();
		dataNasc.setBounds(301, 25, 112, 20);
		panel.add(dataNasc);
		dataNasc.setColumns(10);
		
		TextField identificador = new TextField();
		identificador.setBounds(166, 25, 125, 20);
		panel.add(identificador);
		identificador.setColumns(10);
		
		Label labelData = new Label("Data de nascimento");
		labelData.setBounds(301, 11, 119, 14);
		panel.add(labelData);
		
		TextField endereco = new TextField();
		endereco.setBounds(10, 72, 146, 20);
		panel.add(endereco);
		endereco.setColumns(10);
		
		Label labelEnd = new Label("Endere\u00E7o");
		labelEnd.setBounds(10, 56, 93, 14);
		panel.add(labelEnd);
		
		TextField bairroProf = new TextField();
		bairroProf.setBounds(175, 72, 71, 20);
		panel.add(bairroProf);
		bairroProf.setColumns(10);
		
		Label labelBairro = new Label("Bairro");
		labelBairro.setBounds(175, 56, 46, 14);
		panel.add(labelBairro);
		
		TextField cidade = new TextField();
		cidade.setBounds(266, 72, 71, 20);
		panel.add(cidade);
		cidade.setColumns(10);
		
		Label labelCidade = new Label("Cidade");
		labelCidade.setBounds(266, 56, 46, 14);
		panel.add(labelCidade);
		
		TextField estado = new TextField();
		estado.setBounds(355, 72, 59, 20);
		panel.add(estado);
		estado.setColumns(10);
		
		Label labelEstado = new Label("Estado");
		labelEstado.setBounds(357, 56, 46, 14);
		panel.add(labelEstado);
		
		TextField telefone = new TextField();
		telefone.setBounds(10, 116, 93, 20);
		panel.add(telefone);
		telefone.setColumns(10);
		
		Label labelTel = new Label("Telefone ");
		labelTel.setBounds(10, 103, 71, 14);
		panel.add(labelTel);
		
		TextField celular = new TextField();
		celular.setBounds(119, 116, 86, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		Label labelCel = new Label("Celular");
		labelCel.setBounds(119, 103, 59, 14);
		panel.add(labelCel);
		
		Label labelEspe = new Label("Especialidade");
		labelEspe.setBounds(229, 103, 83, 14);
		panel.add(labelEspe);
		
		Checkbox digito = new Checkbox("Digito");
		digito.setBounds(228, 116, 95, 22);
		panel.add(digito);
		
		Checkbox matematica = new Checkbox("Matem\u00E1tica");
		matematica.setBounds(329, 116, 95, 22);
		panel.add(matematica);
		
		Checkbox informatica = new Checkbox("Inform\u00E1tica");
		informatica.setBounds(229, 135, 95, 22);
		panel.add(informatica);
		
		Checkbox medicina = new Checkbox("Medicina");
		medicina.setBounds(329, 135, 95, 22);
		panel.add(medicina);
		
		Label labelTitulo = new Label("Titulo");
		labelTitulo.setBounds(10, 142, 62, 22);
		panel.add(labelTitulo);
		
		Checkbox bacharel = new Checkbox("Bacharel");
		bacharel.setBounds(8, 158, 95, 22);
		panel.add(bacharel);
		
		Checkbox mestrado = new Checkbox("Mestrado");
		mestrado.setBounds(8, 181, 95, 22);
		panel.add(mestrado);
		
		Checkbox doutorado = new Checkbox("Doutorado");
		doutorado.setBounds(110, 158, 95, 22);
		panel.add(doutorado);
		
		Checkbox especLS = new Checkbox("Especialista Lato Sensu");
		especLS.setBounds(110, 181, 146, 22);
		panel.add(especLS);
		
		Checkbox outros = new Checkbox("Outros");
		outros.setBounds(329, 158, 95, 22);
		panel.add(outros);
		
		JButton btnNewButton = new JButton("Confirma");
		btnNewButton.setBounds(229, 217, 89, 23);
		panel.add(btnNewButton);
	}
}
