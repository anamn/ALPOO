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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("Tela inicial");
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
		sairButton.setBounds(325, 217, 89, 23);
		panel.add(sairButton);
		
		Checkbox checkAluno = new Checkbox("Aluno");
		checkAluno.setBounds(134, 125, 95, 22);
		panel.add(checkAluno);
		
		Checkbox checkProf = new Checkbox("Professor");
		checkProf.setBounds(21, 125, 95, 22);
		panel.add(checkProf);
		
		Checkbox checkDisc = new Checkbox("Disciplina");
		checkDisc.setBounds(134, 84, 95, 22);
		panel.add(checkDisc);
		
		Checkbox checkCurso = new Checkbox("Curso");
		checkCurso.setBounds(21, 84, 95, 22);
		panel.add(checkCurso);
		
		Label label = new Label("Deseja:");
		label.setBounds(21, 39, 62, 22);
		panel.add(label);
		
		Choice choice = new Choice();
		choice.setBounds(84, 39, 131, 20);
		choice.add("Cadastrar");
		choice.add("Alterar");
		choice.add("Deletar");
		choice.add("Mostrar");
		panel.add(choice);
		
		JButton confButton = new JButton("Confirma");
		confButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkAluno.getState()) {
					checkProf.getState();
					System.out.println("aaa");
				}
				if(checkProf.getState()) {
					System.out.println("bbb");
					
				}
				if(checkDisc.getState()) {
					System.out.println("cc");
					
				}
				if(checkCurso.getState()) {
					System.out.println("ddd");
					
				}
			}
		});
		
		confButton.setBounds(228, 217, 89, 23);
		panel.add(confButton);
	}
}

