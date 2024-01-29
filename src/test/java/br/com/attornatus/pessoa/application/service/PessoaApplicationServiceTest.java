package br.com.attornatus.pessoa.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.DataHelper;
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
	void testbuscaListPessoa() {
		
		List<Pessoa> request = DataHelper.getListPessoa();
		
		when(pessoaRepository.buscaTodasPessoas()).thenReturn(request);
		List<PessoaListResponse> response = pessoaApplicationService.buscaTodasPessoas();
		
		verify(pessoaRepository, times(1)).buscaTodasPessoas();
		
//		assertNotNull(response);
//		assertEquals(response, 4);
		assertThat(response).isNotEmpty();
		assertThat(response).hasSize(4);
	}

}
