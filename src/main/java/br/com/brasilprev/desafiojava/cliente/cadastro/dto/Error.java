package br.com.brasilprev.desafiojava.cliente.cadastro.dto;

public class Error {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "Error [mensagem=" + mensagem + "]";
	}

}
