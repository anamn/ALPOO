package br.com.unip.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.unip.exception.SqlException;
import br.com.unip.model.Curso;
import br.com.unip.model.Endereco;
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

	public Professor pesquisa(String cpf) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Professor WHERE CpfProf= '" + cpf + "'";

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			Professor professor = new Professor();
			while (rs.next()) {
				professor.setCpf(rs.getString("CpfProf"));
				professor.setNome(rs.getString("NomeProf"));
				professor.setEndereco(
						new Endereco(rs.getString("EndProf"), rs.getString("bairro"), rs.getString("cidade"),
								rs.getString("estado"), rs.getString("TelProf"), rs.getString("celular")));
				professor.setDataNasc(rs.getString("DataNasc"));
				List<String> titulo = new ArrayList<String>();
				if (rs.getString("TituloProf").contains("Bacharel"))
					titulo.add("Bacharel");
				if (rs.getString("TituloProf").contains("Mestrado"))
					titulo.add("Mestrado");
				if (rs.getString("TituloProf").contains("Doutorado"))
					titulo.add("Doutorado");
				if (rs.getString("TituloProf").contains("Especialista Lato Sensu"))
					titulo.add("Especialista Lato Sensu");
				List<String> esp = new ArrayList<String>();
				if (rs.getString("SpecProf").contains("Digito"))
					esp.add("Digito");
				if (rs.getString("SpecProf").contains("Matemática"))
					esp.add("Matemática");
				if (rs.getString("SpecProf").contains("Informática"))
					esp.add("Informática");
				if (rs.getString("SpecProf").contains("Medicina"))
					esp.add("Medicina");
				if (!rs.getString("SpecProf").isEmpty())
					esp.add("Outros");
				professor.setTitulo(titulo);
				professor.setEspec(esp);
			}
			return professor;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public boolean altera(Professor professor) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();
			String query = "UPDATE Professor set EndProf = '" + professor.getEndereco().getEndereco() + "', bairro= '"
					+ professor.getEndereco().getBairro() + "', cidade= '" + professor.getEndereco().getCidade()
					+ "', estado= '" + professor.getEndereco().getEstado() + "', celular= '"
					+ professor.getEndereco().getCelular() + "', TelProf= '" + professor.getEndereco().getTelFixo()
					+ "', SpecProf= '" + professor.getEspec()+ "', TituloProf= '"
					+ professor.getTitulo() + "' WHERE CpfProf = '" + professor.getCpf() + "'";

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

}
