package br.com.brasilprev.desafiojava.cliente.cadastro.dto;

public class ResponseData {

	private Object data;
	
	private String mensagem;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "ResponseData [data=" + data + ", mensagem=" + mensagem + "]";
	}

}
