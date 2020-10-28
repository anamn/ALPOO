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
import br.com.unip.model.Disciplina;

public class DisciplinaSql {

	public boolean add(Disciplina disciplina) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();

			String sql = "INSERT INTO Disciplina (CodDisc,NomeDisc,CargaHora,AulasSem) VALUES(" + disciplina + ")";

			stmt.executeUpdate(sql);
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

			String sql = "DELETE FROM Disciplina WHERE CodDisc= " + codigo + " AND NomeDisc= '" + nome + "'";

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
			String query = "SELECT * FROM Disciplina";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int cod = rs.getInt("CodDisc");
				String i2 = rs.getString("NomeDisc");
				int cgHr = rs.getInt("CargaHora");
				String i4 = rs.getString("AulasSem");

				String i1 = "" + cod;
				String i3 = "" + cgHr;

				String[] linha = { i1, i2, i3, i4 };
				dataModel.addRow(linha);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public Disciplina pesquisa(String codigo, String nome) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Disciplina WHERE CodDisc= " + codigo + " AND NomeDisc= '" + nome + "'";

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			Disciplina curso = new Disciplina();
			while (rs.next()) {
				curso.setCodigo("" + rs.getInt("CodDisc"));
				curso.setNome(rs.getString("NomeDisc"));
				List<String> aulas = new ArrayList<String>();
				if (rs.getString("AulasSem").contains("1"))
					aulas.add("1");
				if (rs.getString("AulasSem").contains("2"))
					aulas.add("2");
				if (rs.getString("AulasSem").contains("3"))
					aulas.add("3");
				if (rs.getString("AulasSem").contains("3"))
					aulas.add("3");
				if (rs.getString("AulasSem").contains("4"))
					aulas.add("4");
				if (rs.getString("AulasSem").contains("5"))
					aulas.add("5");
				if (rs.getString("AulasSem").contains("6"))
					aulas.add("6");
				curso.setAulas(aulas);
				curso.setCargaHoraria("" + rs.getInt("CargaHora"));
			}
			return curso;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public boolean altera(Disciplina disciplina) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();
			String query = "UPDATE Disciplina set AulasSem = '" + disciplina.getAulas() + "', CargaHora= "
					+ disciplina.getCargaHoraria() + " WHERE NomeDisc = '" + disciplina.getNome() + "' AND CodDisc ="
					+ disciplina.getCodigo();

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public List<Disciplina> getCods() {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Disciplina";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			while (rs.next()) {
				List<String> aulas = new ArrayList<String>();
				if (rs.getString("AulasSem").contains("1"))
					aulas.add("1");
				if (rs.getString("AulasSem").contains("2"))
					aulas.add("2");
				if (rs.getString("AulasSem").contains("3"))
					aulas.add("3");
				if (rs.getString("AulasSem").contains("3"))
					aulas.add("3");
				if (rs.getString("AulasSem").contains("4"))
					aulas.add("4");
				if (rs.getString("AulasSem").contains("5"))
					aulas.add("5");
				if (rs.getString("AulasSem").contains("6"))
					aulas.add("6");
				Disciplina disciplina = new Disciplina("" + rs.getInt("CodDisc"), rs.getString("NomeDisc"),
						"" + rs.getInt("CargaHora"), aulas);
				disciplinas.add(disciplina);
			}

			stmt.close();
			connection.close();
			return disciplinas;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}
	}

}
