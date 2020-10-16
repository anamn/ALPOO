package br.com.unip.frames;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	public static TelaAluno aluno = new TelaAluno();
	public static TelaCurso curso = new TelaCurso();
	public static TelaDisc disc = new TelaDisc();
	public static TelaProf prof = new TelaProf();

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("Tela inicial");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Telas
		Panel panel = new Panel();
		contentPane.add(panel, "name_108138293458800");
		panel.setLayout(null);
	
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sairButton.setBounds(335, 228, 89, 23);
		panel.add(sairButton);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aluno.setVisible(true);
				setVisible(false);
				
			}
		});
		btn_cadastrar.setBounds(153, 24, 104, 23);
		panel.add(btn_cadastrar);
		
		JButton btn_alterar = new JButton("Alterar");
		btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_alterar.setBounds(160, 120, 89, 23);
		panel.add(btn_alterar);
		
		JButton btn_exclui = new JButton("Excluir");
		btn_exclui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_exclui.setBounds(160, 170, 89, 23);
		panel.add(btn_exclui);
		
		JButton btn_mostrar = new JButton("Mostrar");
		btn_mostrar.setBounds(160, 70, 89, 23);
		panel.add(btn_mostrar);
		
		setVisible(true);
	}
}

