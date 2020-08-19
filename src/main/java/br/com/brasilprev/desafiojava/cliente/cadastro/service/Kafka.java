package br.com.brasilprev.desafiojava.cliente.cadastro.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.desafiojava.cliente.cadastro.data.Database;
import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Client;
import br.com.brasilprev.desafiojava.cliente.cadastro.exception.BusinessException;

@Service
public class Kafka implements Persistence {
		
	Logger logger = LogManager.getLogger(Kafka.class);
	
	@Autowired
	private Database database;
	
	@Override
	public void saveClient(Client client) throws BusinessException {
		validateSave(client);
	}
	
	public void validateSave(Client client) throws BusinessException {
		if (client == null) {
			throw new BusinessException(BusinessException.ERROR_INVALID_INPUT);
		}
		if (client.getNome() == null) {
			throw new BusinessException(BusinessException.ERROR_INVALID_NOME);
		}
		if (client.getCpf() == null) {
			throw new BusinessException(BusinessException.ERROR_INVALID_CPF);
		}
		if (client.getEndereco() == null) {
			throw new BusinessException(BusinessException.ERROR_INVALID_ENDERECO);
		}
		if (database.exists(client)) {
			throw new BusinessException(BusinessException.ERROR_EXISTS);
		}
	}
	
}
