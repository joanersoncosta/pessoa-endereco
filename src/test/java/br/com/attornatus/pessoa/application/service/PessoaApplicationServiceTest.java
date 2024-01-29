package br.com.attornatus.pessoa.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import br.com.attornatus.DataHelper;
import br.com.attornatus.handler.APIException;
import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;

@ExtendWith(MockitoExtension.class)
class PessoaApplicationServiceTest {
	@InjectMocks
	private PessoaApplicationService pessoaApplicationService;
	@Mock
	private PessoaRepository pessoaRepository;

	@Test
	void testCriaPessoa() {
		PessoaRequest request = DataHelper.getPessoaRequest();
		
		when(pessoaRepository.salva(any())).thenReturn(new Pessoa(request));
		PessoaIdResponse response = pessoaApplicationService.criaPessoa(request);
		
		assertNotNull(response);
		assertEquals(PessoaIdResponse.class, response.getClass());
	}
	
	@Test
	void testBuscaListPessoa() {
		
		List<Pessoa> request = DataHelper.getListPessoa();
		
		when(pessoaRepository.buscaTodasPessoas()).thenReturn(request);
		List<PessoaListResponse> response = pessoaApplicationService.buscaTodasPessoas();
		
		verify(pessoaRepository, times(1)).buscaTodasPessoas();
		
//		assertNotNull(response);
//		assertEquals(response, 4);
		assertThat(response).isNotEmpty();
		assertThat(response).hasSize(4);
	}
	
	@Test
	void testBuscaListPessoa_retornaListaVazia() {
		
		when(pessoaRepository.buscaTodasPessoas()).thenReturn(Collections.emptyList());
		List<PessoaListResponse> response = pessoaApplicationService.buscaTodasPessoas();
		
		verify(pessoaRepository, times(1)).buscaTodasPessoas();
		
		assertThat(response).isEmpty();
	}
	
	@Test
	void testBuscaPessoaPorId() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = pessoa.getIdPessoa();
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		
		PessoaDetalhadoResponse response = pessoaApplicationService.buscaPessoaPorId(idPessoa);
		
		verify(pessoaRepository, times(1)).buscaPessoaPorId(idPessoa);
		
		assertNotNull(response);
		assertEquals(response.getIdPessoa(), pessoa.getIdPessoa());
		assertEquals(PessoaDetalhadoResponse.class, response.getClass());
	}
	
	@Test
	void testBuscaPessoaPorId_retornaErro() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = UUID.randomUUID();
		when(pessoaRepository.buscaPessoaPorId(idPessoa)).thenReturn(pessoa);

		APIException ex = assertThrows(APIException.class,
				() -> pessoaApplicationService.buscaPessoaPorId(idPessoa));

		assertEquals(ex.getMessage(), "Pessoa não encontrada!");
		assertEquals(ex.getStatusException(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	void testDeletaPessoaPorId() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = pessoa.getIdPessoa();
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
	
		pessoaApplicationService.deletaPessoaPorId(idPessoa);
		
		verify(pessoaRepository, times(1)).deletaPessoa(pessoa);
	}
	
	@Test
	void testEditaPessoaPorId() {
		PessoaAlteracaoRequest request = DataHelper.editaPessoaRequest();
		Pessoa pessoa = mock(Pessoa.class);
		UUID idPessoa = pessoa.getIdPessoa();
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
	
		pessoaApplicationService.patchAlteraPessoa(idPessoa, request);
		
		verify(pessoa).altera(request);
		verify(pessoaRepository, times(1)).salva(pessoa);
	}
}
