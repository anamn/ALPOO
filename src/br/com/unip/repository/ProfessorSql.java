package br.com.unip.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

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
			connection.close();
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
			connection.close();
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
	
	public void showData(DefaultTableModel dataModel) {

		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Professor";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String i1 = rs.getString("CpfProf");
				String i2 = rs.getString("NomeProf");
				String rua = rs.getString("EndProf");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				Date date = rs.getDate("DataNasc");
				String i5 = rs.getString("SpecProf");
				String i6 = rs.getString("TituloProf");

				String i3 = rua + " " + bairro + " " + cidade;
				String i4 = "" + date;

				String[] linha = { i1, i2, i3, i4, i5, i6 };
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
