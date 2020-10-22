package br.com.unip.repository.test;

import br.com.unip.model.Aluno;
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;
import br.com.unip.repository.AlunoSql;

public class TestAluno {
	public static void main(String[] args) {

		Aluno aluno = new Aluno("Ana", "1234567890", "13/12/2000", new Curso("52642", "CC"),
				new Disciplina("12548", "ALPOO"));
		aluno.setP1(9.0);
		aluno.setP2(9.0);
		aluno.setMedia(9.0);
		aluno.setFaltas(1);

		AlunoSql aluninho= new AlunoSql();
		aluninho.add(aluno);
	}
}
