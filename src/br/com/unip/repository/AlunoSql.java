package br.com.unip.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

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
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public boolean delete(String matricula) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			Statement stmt = connection.createStatement();

			String sql = "DELETE FROM aluno WHERE Matricula =" + matricula;

			stmt.executeUpdate(sql);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public void showData(DefaultTableModel dataModel) {

		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Aluno";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int mat = rs.getInt("Matricula");
				String nome = rs.getString("Nome");
				Date dataNasc = rs.getDate("DataNasc");
				int codCurso = rs.getInt("fk_CodCurso");
				String nomeCurso = rs.getString("fk_NomeCurso");
				int p1 = rs.getInt("P1");
				int p2 = rs.getInt("P2");
				int media = rs.getInt("Media");
				int faltas = rs.getInt("Faltas");

				String i1 = "" + mat;
				String i2 = "" + nome;
				String i3 = "" + dataNasc;
				String i4 = "" + codCurso;
				String i5 = "" + nomeCurso;
				String i6 = "" + p1;
				String i7 = "" + p2;
				String i8 = "" + media;
				String i9 = "" + faltas;

				String[] linha = { i1, i2, i3, i4, i5, i6, i7, i8, i9 };
				dataModel.addRow(linha);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
