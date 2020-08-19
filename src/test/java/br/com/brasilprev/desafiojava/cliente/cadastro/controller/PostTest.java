package br.com.brasilprev.desafiojava.cliente.cadastro.controller;

import br.com.brasilprev.desafiojava.cliente.cadastro.AbstractTest;
import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Client;
import br.com.brasilprev.desafiojava.cliente.cadastro.dto.Error;
import br.com.brasilprev.desafiojava.cliente.cadastro.dto.ResponseData;
import br.com.brasilprev.desafiojava.cliente.cadastro.exception.BusinessException;
import br.com.brasilprev.desafiojava.cliente.cadastro.util.ResponseUtil;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class PostTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void cadastroOk() throws Exception {
		String uri = "/cadastro";
		
		Client clienteIn = new Client();
		clienteIn.setNome("Teste");
		clienteIn.setCpf("55555555555");
		clienteIn.setEndereco("Endereco teste");
		
		String inputJson = super.mapToJson(clienteIn);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	    assertEquals(200, status);
	    
	    String content = mvcResult.getResponse().getContentAsString();
		ResponseData retorno = super.mapFromJson(content, ResponseData.class);
		
		assertNotNull(retorno);
		assertNotNull(retorno.getMensagem());
		assertEquals(retorno.getMensagem(), ResponseUtil.PROCESS_OK);
	}
	
	@Test
	public void cadastroErroEntrada() throws Exception {
		String uri = "/cadastro";
		
		String inputJson = "";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	    assertEquals(400, status);
	}
	
	@Test
	public void cadastroErroNome() throws Exception {
		String uri = "/cadastro";
		
		Client clienteIn = new Client();
		clienteIn.setNome(null);
		clienteIn.setCpf("55555555555");
		clienteIn.setEndereco("Endereco teste");
		
		String inputJson = super.mapToJson(clienteIn);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	    assertEquals(400, status);
	    
	    String content = mvcResult.getResponse().getContentAsString();
		ResponseData retorno = super.mapFromJson(content, ResponseData.class);
		
		assertNotNull(retorno);
		assertNotNull(retorno.getMensagem());
		
		Error objError = super.mapFromObject(retorno.getData(), Error.class);
		assertEquals(objError.getMensagem(), BusinessException.ERROR_INVALID_NOME);
		assertEquals(retorno.getMensagem(), ResponseUtil.PROCESS_ERROR);
	}
	
	@Test
	public void cadastroErroCpf() throws Exception {
		String uri = "/cadastro";
		
		Client clienteIn = new Client();
		clienteIn.setNome("Teste");
		clienteIn.setCpf(null);
		clienteIn.setEndereco("Endereco teste");
		
		String inputJson = super.mapToJson(clienteIn);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	    assertEquals(400, status);
	    
	    String content = mvcResult.getResponse().getContentAsString();
		ResponseData retorno = super.mapFromJson(content, ResponseData.class);
		
		assertNotNull(retorno);
		assertNotNull(retorno.getMensagem());
		
		Error objError = super.mapFromObject(retorno.getData(), Error.class);
		assertEquals(objError.getMensagem(), BusinessException.ERROR_INVALID_CPF);
		assertEquals(retorno.getMensagem(), ResponseUtil.PROCESS_ERROR);
	}
	
	@Test
	public void cadastroErroEndereco() throws Exception {
		String uri = "/cadastro";
		
		Client clienteIn = new Client();
		clienteIn.setNome("Teste");
		clienteIn.setCpf("55555555555");
		clienteIn.setEndereco(null);
		
		String inputJson = super.mapToJson(clienteIn);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
	    assertEquals(400, status);
	    
	    String content = mvcResult.getResponse().getContentAsString();
		ResponseData retorno = super.mapFromJson(content, ResponseData.class);
		
		assertNotNull(retorno);
		assertNotNull(retorno.getMensagem());
		
		Error objError = super.mapFromObject(retorno.getData(), Error.class);
		assertEquals(objError.getMensagem(), BusinessException.ERROR_INVALID_ENDERECO);
		assertEquals(retorno.getMensagem(), ResponseUtil.PROCESS_ERROR);
	}
}
