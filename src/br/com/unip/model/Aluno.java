package br.com.unip.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Aluno {
	
	@NotEmpty(message = "Nome invalido")
	@Pattern(regexp = "[A-Z]{1}[aA-zZáÁ-úÚ\\s]{2,50}", message = "Nome invalido")
	private String nome;
	@NotEmpty
	private String matricula;
	@NotEmpty
	@Pattern(regexp = "[99/99/9999]")
	private String dataNascimento;
	@NotEmpty
	private String codCurso;
	@NotEmpty
	private String nomeCurso;
	@NotEmpty
	private String codDisc;
	@NotEmpty
	private String nomeDisc;
	@NotEmpty
	private Double p1;
	@NotEmpty
	private Double p2;
	@NotEmpty
	private Double media;
	@NotEmpty
	private Integer faltas;

	public Aluno(String nome, String matricula, String dataNascimento, String codCurso, String nomeCurso, String codDisc,
			String nomeDisc, Double p1, Double p2, Double media, Integer faltas) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.dataNascimento = dataNascimento;
		this.codCurso = codCurso;
		this.nomeCurso = nomeCurso;
		this.codDisc = codDisc;
		this.nomeDisc = nomeDisc;
		this.p1 = p1;
		this.p2 = p2;
		this.media = media;
		this.faltas = faltas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getCodDisc() {
		return codDisc;
	}

	public void setCodDisc(String codDisc) {
		this.codDisc = codDisc;
	}

	public String getNomeDisc() {
		return nomeDisc;
	}

	public void setNomeDisc(String nomeDisc) {
		this.nomeDisc = nomeDisc;
	}

	public Double getP1() {
		return p1;
	}

	public void setP1(Double p1) {
		this.p1 = p1;
	}

	public Double getP2() {
		return p2;
	}

	public void setP2(Double p2) {
		this.p2 = p2;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", matricula=" + matricula + ", nomeCurso=" + nomeCurso + ", nomeDisc="
				+ nomeDisc + ", p1=" + p1 + ", p2=" + p2 + ", media=" + media + ", faltas=" + faltas + "]";
	}

}
