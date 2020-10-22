package br.com.unip.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Curso;

public class CursoSql {

	public void add(Curso curso) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			
			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO Curso (CodCurso,NomeCurso,TipoCurso,CargaHora,CodInstituto) VALUES(" + curso
					+ ")";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}
}
