package br.com.transportadora.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class Endereco {
	private String cep;
	@NotEmpty(message = "campo de estado obrigatorio")
	private String estado;
	@NotEmpty(message = "campo de cidade obrigatorio")
	private String cidade;
	@NotEmpty(message = "campo de bairro obrigatorio")
	private String bairro;
	@NotEmpty(message = "campo de rua obrigatorio")
	private String rua;
	@NotEmpty(message = "campo de numero obrigatorio")
	private String numero;
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
}
