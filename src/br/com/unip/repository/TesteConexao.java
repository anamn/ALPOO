package br.com.unip.repository;

public class TesteConexao {
	public static void main(String[] args) {
		ConexaoSql conexao= new ConexaoSql();
		conexao.getConexaoMySQL();
		System.out.println(conexao.statusConection());
		conexao.FecharConexao();
		System.out.println(conexao.statusConection());

	}
}