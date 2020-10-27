package br.com.unip.model;

import java.util.List;

import br.com.unip.exception.CaracteresException;

public class Disciplina {

	private String codigo;
	private String nome;
	private String cargaHoraria;
	private List<String> aulas;

	public Disciplina(String codigo, String nomeDisciplina) {
		super();
		this.setCodigo(codigo);
		this.setNome(nomeDisciplina);
	}

	public Disciplina(String codigo, String nome, String cargaHoraria, List<String> aulas) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCargaHoraria(cargaHoraria);
		this.setAulas(aulas);
	}

	public Disciplina() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo.length() == 5 && codigo.matches("[\\d]+")) {
			this.codigo = codigo;
		} else {
			throw new CaracteresException("O codigo deve conter apenas numeros e ter 5 digitos");
		}
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

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		if (codigo.matches("[\\d]+") && !codigo.isEmpty()) {
			this.cargaHoraria = cargaHoraria;
		} else {
			throw new CaracteresException("Deve conter apenas numeros");
		}
	}

	public List<String> getAulas() {
		return aulas;
	}

	public void setAulas(List<String> aulas) {
		this.aulas = aulas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigo + ",'" + nome + "'," + cargaHoraria + ",'" + aulas + "'";
	}

}