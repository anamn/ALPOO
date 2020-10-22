package br.com.unip.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Professor;

public class ProfessorSql {
	
	public boolean add(Professor professor) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO Professor (CpfProf,NomeProf,EndProf,bairro,cidade,estado,TelProf,celular,DataNasc,SpecProf,TituloProf) VALUES("
					+ professor + ")";

			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public boolean delete(String cpf) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			Statement stmt = connection.createStatement();

			String sql = "DELETE FROM Professor WHERE CpfProf = '" + cpf + "'";

			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}
	
	public boolean altera(Professor professor) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();

			String sql = "";

			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

}
