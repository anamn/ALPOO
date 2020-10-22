package br.com.unip.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Disciplina;

public class DisciplinaSql {

	public void add(Disciplina disciplina) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			
			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO Disciplina (CodDisc,NomeDisc,CargaHora,AulasSem) VALUES(" + disciplina
					+ ")";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}
}
