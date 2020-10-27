package br.com.unip.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.unip.exception.CaracteresException;
import br.com.unip.validador.Cpf;

public class Professor {

	private String cpf;
	private String nome;
	private List<String> espec;
	private LocalDate dataNasc;
	private List<String> titulo;
	private Endereco endereco;

	public Professor(String cpf, String nome, List<String> espec, String dataNasc, List<String> titulo, Endereco endereco) {
		super();
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEspec(espec);
		this.setDataNasc(dataNasc);
		this.setTitulo(titulo);
		this.endereco = endereco;
	}

	public Professor() {
		super();
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public List<String> getEspec() {
		return espec;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getTitulo() {
		return titulo;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
	}
	
	public void setEspec(List<String> espec) {
		this.espec = espec;
	}

	public void setCpf(String cpf) {
		if (Cpf.isValid(cpf)) {
			this.cpf = cpf;
		} else {
			throw new CaracteresException("CPF invalido");
		}
	}

	public void setNome(String nome) {
		if (nome.matches("[^\\d]+") && nome.length() <= 40) {
			this.nome = nome;
		} else {
			throw new CaracteresException("Nome invalido");
		}
	}

	public void setTitulo(List<String> titulo) {
		this.titulo = titulo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "'" + cpf + "','" + nome + "'," + endereco + ",'" + dataNasc + "','" + espec + "','" + titulo + "'";
	}
}