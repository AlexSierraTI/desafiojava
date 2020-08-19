package br.com.brasilprev.desafiojava.cliente.cadastro.service;

import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Client;
import br.com.brasilprev.desafiojava.cliente.cadastro.exception.BusinessException;

public interface Persistence {

	void saveClient(Client client) throws BusinessException;
}
