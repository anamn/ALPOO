package br.com.unip.model;

import br.com.unip.exception.CaracteresException;

public class Endereco {

	private String endereco;
	private String bairro;
	private String cidade;
	private String estado;
	private String telFixo;
	private String celular;

	public Endereco(String endereco, String bairro, String cidade, String estado, String telFixo,
			String celular) {
		super();
		this.setEndereco(endereco);;
		this.setBairro(bairro);;
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setTelFixo(telFixo);
		this.setCelular(celular);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco.length() <= 40 && endereco.length() > 5) {
			this.endereco = endereco;
		} else {
			throw new CaracteresException(
					"Endereco Invalido");
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
					"Bairro Invalido");
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if (cidade.matches("[^\\d]+") && cidade.length() <= 40 && cidade.length() > 1) {
			this.cidade = cidade;
		} else {
			throw new CaracteresException("Cidade invalida");
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		if (estado.matches("[^\\d]+") && estado.length() <= 40 && estado.length() > 1) {
			this.estado = estado;
		} else {
			throw new CaracteresException("Estado invalido");
		}
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		if (telFixo.matches("[\\d]+") && telFixo.length() == 10) 
		this.telFixo = telFixo;
		 else {
				throw new CaracteresException("Telefone Invalido");
			}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		if (celular.matches("[\\d]+") && celular.length() == 11) 
			this.celular = celular;
			 else {
					throw new CaracteresException("Celular Invalido");
				}
	}

	@Override
	public String toString() {
		return "'" + endereco + "','" + bairro + "','" + cidade + "','"
				+ estado + "','" + telFixo + "','" + celular + "'";
	}

}