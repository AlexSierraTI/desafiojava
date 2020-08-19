package br.com.brasilprev.desafiojava.cliente.cadastro.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.brasilprev.desafiojava.cliente.cadastro.dto.ResponseData;

public class ResponseUtil {

	public static final String PROCESS_OK = "Processamento OK";
	public static final String PROCESS_ERROR = "Processamento com ERRO";
	
	public static ResponseEntity<ResponseData> envelopeDataOk(Object entrada) {
		return Response(entrada, PROCESS_OK, HttpStatus.OK);
	}
	
	public static ResponseEntity<ResponseData> envelopeDataError(Object entrada) {
		return Response(entrada, PROCESS_ERROR, HttpStatus.BAD_REQUEST);
	}
	
	private static ResponseEntity<ResponseData> Response(Object entrada, String msg, HttpStatus status) {
		ResponseData data = new ResponseData();
		data.setData(entrada);
		data.setMensagem(msg);
		
		ResponseEntity<ResponseData> retorno = new ResponseEntity<ResponseData>(data, status);
		return retorno;
	}
}
