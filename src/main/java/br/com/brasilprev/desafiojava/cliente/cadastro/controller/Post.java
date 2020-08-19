package br.com.brasilprev.desafiojava.cliente.cadastro.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Client;
import br.com.brasilprev.desafiojava.cliente.cadastro.dto.ResponseData;
import br.com.brasilprev.desafiojava.cliente.cadastro.exception.BusinessException;
import br.com.brasilprev.desafiojava.cliente.cadastro.service.Persistence;
import br.com.brasilprev.desafiojava.cliente.cadastro.util.ResponseUtil;

@RestController
public class Post {

	Logger logger = LogManager.getLogger(Post.class);

	@Autowired
	private Persistence service;
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ResponseEntity<ResponseData> cadastro(@RequestBody(required = true) Client clientIn) {
		try{
			logger.info(clientIn);
			service.saveClient(clientIn);
			return ResponseUtil.envelopeDataOk(clientIn);
		} catch (BusinessException ex) {
			logger.error(ex);
			return ResponseUtil.envelopeDataError(ex.getError());
		} 
	}
	
	
}
