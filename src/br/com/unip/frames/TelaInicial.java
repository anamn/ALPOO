package br.com.unip.frames;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame {

	private JPanel contentPane;
	public static TelaAluno aluno = new TelaAluno();
	public static TelaCurso curso = new TelaCurso();
	public static TelaDisc disc = new TelaDisc();
	public static TelaProf prof = new TelaProf();
	public static TableAluno tbAluno = new TableAluno();
	public static TableCurso tbCurso = new TableCurso();
	public static TableDisc tbDisc = new TableDisc();
	public static TableProf tbProf = new TableProf();

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaInicial.class.getResource("/javax/swing/plaf/basic/icons/image-delayed.png")));
		setTitle("Tela de Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		//Telas
		Panel panel = new Panel();
		panel.setBounds(0, 0, 444, 251);
		contentPane.add(panel);
		panel.setLayout(null);
	
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sairButton.setBounds(332, 197, 89, 23);
		panel.add(sairButton);
		
		JButton btn_aluno = new JButton("Aluno");
		btn_aluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbAluno.setVisible(true);
				setVisible(false);
			}
		});
		btn_aluno.setBounds(157, 21, 89, 23);
		panel.add(btn_aluno);
		
		JButton btn_disc = new JButton("Disciplina");
		btn_disc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbDisc.setVisible(true);
				setVisible(false);
			}
		});
		btn_disc.setBounds(157, 114, 89, 23);
		panel.add(btn_disc);
		
		JButton btn_curso = new JButton("Curso");
		btn_curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbCurso.setVisible(true);
				setVisible(false);
			}
		});
		btn_curso.setBounds(157, 159, 89, 23);
		panel.add(btn_curso);
		
		JButton btn_prof = new JButton("Professor");
		btn_prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tbProf.setVisible(true);
				setVisible(false);
			}
		});
		btn_prof.setBounds(153, 64, 97, 23);
		panel.add(btn_prof);

//		mn_consultar.add(new JSeparator());
//		
//		JMenuItem mnItn_cursoProf = new JMenuItem("Cursos/Professores");
//		mn_consultar.add(mnItn_cursoProf);
//		
//		JMenuItem mnItn_cursoDisc = new JMenuItem("Cursos/Disciplinas");
//		mn_consultar.add(mnItn_cursoDisc);
//		
//		JMenuItem mnItn_profDisc = new JMenuItem("Professores/Disciplinas");
//		mn_consultar.add(mnItn_profDisc);
//		
//		JMenuItem mnItn_alunoDisc = new JMenuItem("Aluno/Disciplina");
//		mn_consultar.add(mnItn_alunoDisc);
		


		setVisible(true);
	}
}

