package br.com.attornatus.endereco.aplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.DataHelper;
import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.aplication.repository.EnderecoRepository;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;

@ExtendWith(MockitoExtension.class)
class EnderecoApplicationServiceTest {

	@InjectMocks
	private EnderecoApplicationService enderecoApplicationService;
	@Mock
	private PessoaRepository pessoaRepository;
	@Mock
	private EnderecoRepository enderecoRepository;
	
	@Test
	void testCriaEndereco() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = pessoa.getIdPessoa();
		EnderecoRequest request = DataHelper.getEnderecoRequest();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.salvaEndereco(any())).thenReturn(new Endereco(request));

		EnderecoIdResponse response = enderecoApplicationService.criaEndereco(idPessoa, request);

		assertNotNull(response);
		assertEquals(EnderecoIdResponse.class, response.getClass());
	}

}
