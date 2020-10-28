package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;

public class CursoSql {

	public boolean add(Curso curso) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();

			String query = "INSERT INTO Curso (CodCurso,NomeCurso,TipoCurso,CargaHora,CodInstituto) VALUES(" + curso
					+ ")";

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public boolean delete(String codigo, String nome) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			Statement stmt = connection.createStatement();

			String query = "DELETE FROM Curso WHERE CodCurso= " + codigo + " AND NomeCurso= '" + nome + "'";

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

	public void showdata(DefaultTableModel dataModel) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Curso";

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt("CodCurso");
				String i2 = rs.getString("NomeCurso");
				String i3 = rs.getString("TipoCurso");
				int cgHr = rs.getInt("CargaHora");
				int codIns = rs.getInt("CodInstituto");

				String i1 = "" + cod;
				String i4 = "" + cgHr;
				String i5 = "" + codIns;
				String[] linha = { i1, i2, i3, i4, i5 };
				dataModel.addRow(linha);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public Curso pesquisa(String codigo, String nome) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Curso WHERE CodCurso= " + codigo + " AND NomeCurso= '" + nome + "'";

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			Curso curso = new Curso();
			while (rs.next()) {
				curso.setCodigo("" + rs.getInt("CodCurso"));
				curso.setNome(rs.getString("NomeCurso"));
				curso.setTipoCurso(rs.getString("TipoCurso"));
				curso.setCargaHoraria("" + rs.getInt("CargaHora"));
				curso.setCodInstituto("" + rs.getInt("CodInstituto"));
			}
			return curso;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public boolean altera(Curso curso) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();
			String query = "UPDATE Curso set TipoCurso = '" + curso.getTipo() + "', CargaHora= "
					+ curso.getCargaHoraria() + ", CodInstituto= " + curso.getCodInstituto() + " WHERE NomeCurso = '"
					+ curso.getNome() + "' AND CodCurso =" + curso.getCodigo();

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public List<Curso> getCods() {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Curso";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			List<Curso> cursos = new ArrayList<Curso>();
			while (rs.next()) {
				Curso curso = new Curso("" + rs.getInt("CodCurso"), rs.getString("NomeCurso"),
						rs.getString("TipoCurso"), "" + rs.getInt("CodInstituto"), "" + rs.getInt("CargaHora"));
				cursos.add(curso);
			}

			stmt.close();
			connection.close();
			return cursos;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}
}
