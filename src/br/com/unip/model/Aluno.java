
package br.com.unip.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.unip.exception.CaracteresException;

public class Aluno {

	private String nome;
	private String matricula;
	private LocalDate dataNascimento;
	private Curso curso;
	private Disciplina disciplina;
	private Double p1;
	private Double p2;
	private Double media;
	private Integer faltas;

	public Aluno(String nome, String matricula, String dataNascimento, Curso curso, Disciplina disciplina) {
		super();
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setDataNascimento(dataNascimento);
		this.curso = curso;
		this.setDisciplina(disciplina);
	}

	public Aluno() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.matches("[^\\d]+") && nome.length() <= 40 && nome.length() > 1) {
			this.nome = nome;
		} else {
			throw new CaracteresException("Nome invalido");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		if (matricula.length() == 5 && matricula.matches("[\\d]+")) {
			this.matricula = matricula;
		} else {
			throw new CaracteresException("Matricula invalida");
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("uuuu-MM-dd"));
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Double getP1() {
		return p1;
	}

	public void setP1(Double p1) {
		if (0 <= p1 && p1 <= 10) {
			this.p1 = p1;
		}else {
			throw new CaracteresException("Nota P1 invalida");
		}
	}

	public Double getP2() {
		return p2;
	}

	public void setP2(Double p2) {
		if (0 <=  p2 && p2 <=  10)
			this.p2 = p2;
		else {
			throw new CaracteresException("Nota P2 invalida");
		}
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		if (0 <=  media && media <=  10)
			this.media = media;
		else {
				throw new CaracteresException("Media invalida");
			}
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
		return "'" + nome + "'," + matricula + ",'" + dataNascimento + "'," + curso.getCodigo() + ",'" + curso.getNome()
				+ "'," + disciplina.getCodigo() + ",'" + disciplina.getNome() + "'," + getP1() + "," + getP2() + ","
				+ getMedia() + "," + faltas;
	}

}
