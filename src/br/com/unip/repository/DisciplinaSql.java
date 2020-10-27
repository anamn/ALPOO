package br.com.unip.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

}
