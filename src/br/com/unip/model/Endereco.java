package br.com.unip.model;

public class Endereco {
	
	private String rua;
	private String num;
	private String bairro;
	private String cidade;
	private String estado;
	private String telFixo;
	private String celular;
	
	public Endereco(String rua, String num, String bairro, String cidade, String estado, String telFixo,
			String celular) {
		super();
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telFixo = telFixo;
		this.celular = celular;
	}
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelFixo() {
		return telFixo;
	}
	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	

}
