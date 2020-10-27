package br.com.unip.model;

import br.com.unip.exception.CaracteresException;

public class Curso {

	private String codigo;
	private String nome;
	private String tipo;
	private String codInstituto;
	private String cargaHoraria;

	public Curso(String codigo, String nome) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	public Curso() {
		super();
	}

	public Curso(String codigo, String nome, String tipo, String codInstituto, String cargaHoraria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.codInstituto = codInstituto;
		this.cargaHoraria = cargaHoraria;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipoCurso(String tipo) {
		if (tipo.matches("[^\\d]+") && tipo.length() <= 20 && tipo.length() > 1) {
			this.tipo = tipo;
		} else {
			throw new CaracteresException("Nome invalido");
		}
	}

	public String getCodInstituto() {
		return codInstituto;
	}

	public void setCodInstituto(String codInstituto) {
		this.codInstituto = codInstituto;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return codigo + ",'" + nome + "','" + tipo + "'," + cargaHoraria + "," + codInstituto;
	}

}