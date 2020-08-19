package br.com.brasilprev.desafiojava.cliente.cadastro.exception;

import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Error;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public final static String ERROR_INVALID_INPUT = "Cliente de entrada invalido!";
	public final static String ERROR_EXISTS = "Cliente ja existe!";
	public final static String ERROR_NOT_FOUND = "Cliente nao existe!";
	public final static String ERROR_INVALID_NOME = "Nome do cliente invalido!";
	public final static String ERROR_INVALID_CPF = "CPF do cliente invalido!";
	public final static String ERROR_INVALID_ENDERECO = "Endereco do cliente invalido!";

	public BusinessException(String message) {
		this.error = new Error();
		this.error.setMensagem(message);
	}
	
	private Error error;

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "BusinessException [error=" + error + "]";
	}
	
}
