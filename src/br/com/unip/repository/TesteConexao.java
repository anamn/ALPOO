package br.com.unip.repository;

public class TesteConexao {
	public static void main(String[] args) {
		ConexaoSql.getConexaoMySQL();
		System.out.println(ConexaoSql.statusConection());
		ConexaoSql.FecharConexao();
		System.out.println(ConexaoSql.statusConection());

	}
}