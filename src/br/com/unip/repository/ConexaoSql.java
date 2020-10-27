package br.com.unip.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.unip.exception.SqlException;

public class ConexaoSql {
	
	public static Connection connection;

	public static String status = "Não conectou...";


	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		connection = null; // atributo do tipo Connection

		try {

			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.cj.jdbc.Driver";

			// Configurando a nossa conexão com um banco de dados//

			String serverName = "localhost"; // caminho do servidor do BD

			String mydatabase = "Faculdade?useTimezone=true&serverTimezone=UTC"; // nome do seu banco de dados

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root"; // nome de um usuário de seu BD

			String password = "8186"; // sua senha de acesso

			connection = DriverManager.getConnection(url, username, password);
			Class.forName(driverName);
			// Testa sua conexão//

			if (connection != null) {

				status = ("STATUS--->Conectado com sucesso!");

			} else {

				status = ("STATUS--->Não foi possivel realizar conexão");

			}

			return connection;

		} catch (ClassNotFoundException e) { // Driver não encontrado

			throw new SqlException("O driver especificado nao foi encontrado.");


		} catch (SQLException e) {

			// Não conseguindo se conectar ao banco

			throw new SqlException("Nao foi possivel conectar ao Banco de Dados." + e);

		}

	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {

		return status;

	}

	// Método que fecha sua conexão//

	public static boolean FecharConexao() {

		try {

			ConexaoSql.getConexaoMySQL().close();
			status= "STATUS--->Conexão fechada!";
			return true;

		} catch (SQLException e) {

			return false;

		}

	}

	// Método que reinicia sua conexão//

	public static java.sql.Connection ReiniciarConexao() {

		FecharConexao();

		return ConexaoSql.getConexaoMySQL();

	}
}
