package br.com.unip.repository.test;

import br.com.unip.model.Curso;
import br.com.unip.repository.CursoSql;

public class TestCurso {
	
	public static void main(String[] args) {
		
		Curso curso= new Curso("45456", "SS");
		curso.setCodInstituto("8564");
		curso.setCargaHoraria("4");
		curso.setTipoCurso("Bacharel");
		
		CursoSql sql= new CursoSql();
		sql.add(curso);
		//sql.delete("45456", "SS");

	}
}
