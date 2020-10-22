package br.com.unip.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Aluno;

public class AlunoSql {

	public boolean add(Aluno aluno) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO aluno (Nome,Matricula,DataNasc,fk_CodCurso,fk_NomeCurso,fk_CodDisc,fk_NomeDisc,P1,P2,Media,Faltas) VALUES("
					+ aluno + ")";

			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public boolean delete(String matricula) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			Statement stmt = connection.createStatement();

			String sql = "DELETE FROM aluno WHERE Matricula ="+matricula;

			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

}
