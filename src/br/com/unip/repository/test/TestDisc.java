package br.com.unip.repository.test;

import br.com.unip.model.Disciplina;
import br.com.unip.repository.DisciplinaSql;

public class TestDisc {
	public static void main(String[] args) {

		Disciplina disciplina = new Disciplina("12548", "ALPOO");
		//disciplina.setAulas("2");
		disciplina.setCargaHoraria("52");
		
		DisciplinaSql sql= new DisciplinaSql();
		sql.add(disciplina);
		//sql.delete("12548", "ALPOO");
	}
}
