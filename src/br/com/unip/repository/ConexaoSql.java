package br.com.unip.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSql {

	public static String status = "Não conectou...";

	public ConexaoSql() {

	}

	// Método de Conexão//

	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection

		try {

			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.cj.jdbc.Driver";

			// Configurando a nossa conexão com um banco de dados//

			String serverName = "localhost"; // caminho do servidor do BD

			String mydatabase = "faculdade?useTimezone=true&serverTimezone=UTC"; // nome do seu banco de dados

			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

			String username = "root"; // nome de um usuário de seu BD

			String password = "ana123"; // sua senha de acesso

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

			System.out.println("O driver expecificado nao foi encontrado.");

			return null;

		} catch (SQLException e) {

			// Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados." + e);

			return null;

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
