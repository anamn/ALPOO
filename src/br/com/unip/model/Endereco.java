package br.com.unip.model;

import br.com.unip.exception.CaracteresException;

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
		if (rua.matches("[^\\d]+") && rua.length() <= 40 && rua.length() > 5) {
			this.rua = rua;
		} else {
			throw new CaracteresException(
					"Rua deve ter apenas letras e ter no minimo cinco digitos e no maximo quarenta");
		}
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		if (num.length() > 1 && num.matches("[\\d]+")) {
			this.num = num;
		} else {
			throw new CaracteresException("O numero deve conter apenas numeros");
		}
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		if (bairro.matches("[^\\d]+") && bairro.length() <= 40 && bairro.length() > 5) {
			this.bairro = bairro;
		} else {
			throw new CaracteresException(
					"Bairro deve ter apenas letras e ter no minimo cinco digitos e no maximo quarenta");
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if (cidade.matches("[^\\d]+") && cidade.length() <= 40 && cidade.length() > 1) {
			this.cidade = cidade;
		} else {
			throw new CaracteresException("Cidade deve ter apenas letras e ter no maximo quarenta digitos");
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		if (estado.matches("[^\\d]+") && cidade.length() <= 40 && estado.length() > 1) {
			this.estado = estado;
		} else {
			throw new CaracteresException("Cidade deve ter apenas letras e ter no maximo quarenta digitos");
		}
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		if (telFixo.matches("[\\d]+") && telFixo.length() == 10) 
		this.telFixo = telFixo;
		 else {
				throw new CaracteresException("Telefone deve conter ddd");
			}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		if (celular.matches("[\\d]+") && celular.length() == 11) 
			this.celular = celular;
			 else {
					throw new CaracteresException("Celular deve conter ddd");
				}
	}

	@Override
	public String toString() {
		return "'" + rua + ", n" + num + "','" + bairro + "','" + cidade + "','"
				+ estado + "','" + telFixo + "','" + celular + "'";
	}

}