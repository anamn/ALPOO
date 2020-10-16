package br.com.unip.model;

import java.util.Date;

public class Professor {

	private String indentProf;
	private String nomeProf;
	private String especProf;
	private Date dataNasc;
	private String tituloProf;
	private Endereco endereco;

	public Professor(String indentProf, String nomeProf, String especProf, Date dataNasc, String tituloProf,
			Endereco endereco) {
		super();
		this.indentProf = indentProf;
		this.nomeProf = nomeProf;
		this.especProf = especProf;
		this.dataNasc = dataNasc;
		this.tituloProf = tituloProf;
		this.endereco = endereco;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public String getEspecProf() {
		return especProf;
	}

	public String getIndentProf() {
		return indentProf;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public String getTituloProf() {
		return tituloProf;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setEspecProf(String especProf) {
		this.especProf = especProf;
	}

	public void setIndentProf(String indentProf) {
		this.indentProf = indentProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public void setTituloProf(String tituloProf) {
		this.tituloProf = tituloProf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
