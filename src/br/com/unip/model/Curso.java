package br.com.unip.model;

public class Curso {

	private String codCurso;
	private String nomeCurso;
	private String tipoCurso;
	private String codInstituto;
	private String cargaHoraria;

	public Curso(String codCurso, String nomeCurso, String tipoCurso, String codInstituto, String cargaHoraria) {
		super();
		this.codCurso = codCurso;
		this.nomeCurso = nomeCurso;
		this.tipoCurso = tipoCurso;
		this.codInstituto = codInstituto;
		this.cargaHoraria = cargaHoraria;
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

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
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

}
