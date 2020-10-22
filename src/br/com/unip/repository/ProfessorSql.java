package br.com.unip.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Professor;

public class ProfessorSql {
	public void add(Professor professor) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			System.out.println(professor);
			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO Professor (IdentProf,NomeProf,EndProf,bairro,cidade,estado,TelProf,celular,DataNasc,SpecProf,TituloProf) VALUES("
					+ professor +")";

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}
}
