package br.com.attornatus.pessoa.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.DataHelpher;
import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;

//@ContextConfiguration(classes = {PessoaApplicationService.class })
//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class PessoaApplicationTestes {

	@InjectMocks
	private PessoaApplicationService pessoaApplicationService;

	@Mock
	private PessoaRepository pessoaRepository;

	@Mock
	DataHelpher dataHelpher;

	Pessoa pessoa;
	UUID idPessoa;

	@BeforeEach
	void setup() {
		pessoa = DataHelpher.createPessoa();
		idPessoa = pessoa.getIdPessoa();
        when(pessoaRepository.buscaPessoaPorId(any(UUID.class))).thenReturn(pessoa);
	}

	@Test
	void testCriaPessoa() {
		PessoaRequest pessoaCriada = DataHelpher.createPessoaRequest();
		
		when (pessoaRepository.salva(any())).thenReturn(new Pessoa(pessoaCriada));
		PessoaIdResponse response = pessoaApplicationService.criaPessoa(pessoaCriada);
		
		assertNotNull(response);
        assertEquals(PessoaIdResponse.class, response.getClass());
	}

	@Test
	void testBuscaTodasPessoas() {
		Pessoa pessoa = DataHelpher.createPessoa();
    	
    	when (pessoaRepository.buscaPessoaPorId(idPessoa)).thenReturn(pessoa);
		pessoaApplicationService.buscaTodasPessoas();
		verify(pessoaRepository, times(1)).buscaTodasPessoas();

	}

	@Test
	void testBuscaPessoaPorId() {
		when(pessoaRepository.buscaPessoaPorId(idPessoa)).thenReturn(pessoa);
		pessoaApplicationService.buscaPessoaPorId(idPessoa);
		verify(pessoaRepository, times(1)).buscaPessoaPorId(idPessoa);	
	}

	@Test
	void testDeletaPessoaPorId() {
		Pessoa pessoaMock = DataHelpher.createPessoa();
		when (pessoaRepository.buscaPessoaPorId(idPessoa)).thenReturn(pessoaMock);
		pessoaApplicationService.deletaPessoaPorId(idPessoa);
		verify(pessoaRepository, times(1)).deletaPessoa(pessoaMock);	
	}

	@Test
	void testPatchAlteraPessoa() {
		Pessoa pessoaMock = DataHelpher.createPessoa();
		when (pessoaRepository.buscaPessoaPorId(idPessoa)).thenReturn(pessoa);
		PessoaAlteracaoRequest request = DataHelpher.createEditaPessoaRequest();
		pessoaMock.altera(request);
		pessoaApplicationService.patchAlteraPessoa(pessoaMock.getIdPessoa(), request);
		verify(pessoaRepository, times(1)).buscaPessoaPorId(pessoaMock.getIdPessoa());	
	}
	
}
