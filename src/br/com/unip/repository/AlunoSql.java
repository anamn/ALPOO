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
import br.com.unip.model.Curso;
import br.com.unip.model.Disciplina;

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

	public Aluno pesquisa(String matricula) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {
			String query = "SELECT * FROM Aluno WHERE Matricula= " + matricula;

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			Aluno aluno = new Aluno();
			while (rs.next()) {
				aluno.setMatricula("" + rs.getInt("Matricula"));
				aluno.setNome(rs.getString("Nome"));
				aluno.setDataNascimento(rs.getString("DataNasc"));
				aluno.setDisciplina(new Disciplina("" + rs.getInt("fk_CodDisc"), rs.getString("fk_NomeDisc")));
				aluno.setCurso(new Curso("" + rs.getInt("fk_CodCurso"), rs.getString("fk_NomeCurso")));
				aluno.setP1(rs.getDouble("P1"));
				aluno.setP2(rs.getDouble("P2"));
				aluno.setMedia(rs.getDouble("Media"));
				aluno.setFaltas(rs.getInt("Faltas"));
			}
			return aluno;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}

	public boolean altera(Aluno aluno) {
		Connection connection = ConexaoSql.getConexaoMySQL();
		try {

			Statement stmt = connection.createStatement();
			String query = "UPDATE Aluno set fk_CodDisc = " + aluno.getDisciplina().getCodigo() + ", fk_NomeDisc= '"
					+ aluno.getDisciplina().getNome() + "', fk_CodCurso= " + aluno.getCurso().getCodigo()
					+ ", fk_NomeCurso= '" + aluno.getCurso().getNome() + "', P1= " + aluno.getP1() + ", P2= "
					+ aluno.getP2() + ", Media= " + aluno.getMedia() + ", Faltas= " + aluno.getFaltas()
					+ " WHERE Matricula = " + aluno.getMatricula();

			stmt.executeUpdate(query);
			connection.close();
			return true;
		} catch (SQLException e) {
			throw new SqlException(e.getMessage());
		}

	}
	
	
}
