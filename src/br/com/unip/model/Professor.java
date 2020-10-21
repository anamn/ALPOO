package br.com.unip.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.unip.exception.CaracteresException;

public class Professor {

	private String indent;
	private String nome;
	private String espec;
	private LocalDate dataNasc;
	private String titulo;
	private Endereco endereco;

	public Professor(String indent, String nome, String espec, String dataNasc, String titulo, Endereco endereco) {
		super();
		this.setIndent(indent);
		this.setNome(nome);
		this.setEspec(espec);
		this.setDataNasc(dataNasc);
		this.setTitulo(titulo);
		this.endereco = endereco;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public String getEspec() {
		return espec;
	}

	public String getIndent() {
		return indent;
	}

	public String getNome() {
		return nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/uuuu"));
	}

	public void setEspec(String espec) {
		this.espec = espec;
	}

	public void setIndent(String indent) {
		this.indent = indent;
	}

	public void setNome(String nome) {
		if (nome.matches("[^\\d]+") && nome.length() <= 50 && nome.length() > 1) {
			this.nome = nome;
		} else {
			throw new CaracteresException("Nome invalido");
		}
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}