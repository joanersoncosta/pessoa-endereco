package br.com.attornatus.pessoa.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.DataHelper;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
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

}
