package br.com.attornatus.endereco.aplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
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

import br.com.attornatus.DataHelper;
import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaListResponse;
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

	@Test
	void testListEnderecoDaPessoa() {
		Pessoa pessoa = DataHelper.createPessoa();
		Endereco endereco = DataHelper.getEndereco();
		UUID idPessoa = pessoa.getIdPessoa();
		List<Endereco> request = DataHelper.getListEnderecos();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecosDaPessoaComId(any())).thenReturn(request);

		List<EnderecoPessoaListResponse> response = enderecoApplicationService.buscaEnderecosDaPessoaComId(idPessoa);

		assertThat(response).isNotEmpty();
		assertThat(response).hasSize(4);
		assertThat(response.get(0).getIdEndereco()).isEqualTo(endereco.getIdEndereco());
	}
	
	@Test
	void testListEnderecoDaPessoa_retornaListaVazia() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = pessoa.getIdPessoa();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecosDaPessoaComId(any())).thenReturn(Collections.emptyList());

		List<EnderecoPessoaListResponse> response = enderecoApplicationService.buscaEnderecosDaPessoaComId(idPessoa);

		assertThat(response).isEmpty();
	}
	
	@Test
	void testbuscaEnderecoDaPessoaComId() {
		Pessoa pessoa = DataHelper.createPessoa();
		Endereco endereco = DataHelper.getEndereco();
		UUID idEndereco = endereco.getIdEndereco();
		UUID idPessoa = pessoa.getIdPessoa();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecoPeloId(any())).thenReturn(endereco);

		EnderecoPessoaDetalhadoResponse response = enderecoApplicationService.buscaEnderecoDaPessoaComId(idPessoa, idEndereco);

		assertNotNull(response);
		assertEquals(response.getIdEndereco(), endereco.getIdEndereco());
		assertEquals(EnderecoPessoaDetalhadoResponse.class, response.getClass());
	}
	
	@Test
	void testDeletaEnderecoDaPessoaComId() {
		Pessoa pessoa = DataHelper.createPessoa();
		Endereco endereco = DataHelper.getEndereco();
		UUID idEndereco = endereco.getIdEndereco();
		UUID idPessoa = pessoa.getIdPessoa();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecoPeloId(any())).thenReturn(endereco);

		enderecoApplicationService.deletaEnderecoDaPessoaComId(idPessoa, idEndereco);
	
		verify(enderecoRepository, times(1)).deletaEndereco(endereco);
	}
	
	@Test
	void testEditaEnderecoDaPessoaComId() {
		Pessoa pessoa = DataHelper.createPessoa();
		Endereco endereco = mock(Endereco.class);
		EnderecoAlteracaoRequest request = DataHelper.getEditaEnderecoRequest();
		UUID idPessoa = pessoa.getIdPessoa();
		UUID idEndereco = endereco.getIdEndereco();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecoPeloId(any())).thenReturn(endereco);

		enderecoApplicationService.alteraEnderecoDaPessoaComId(idPessoa, idEndereco, request);
		verify(endereco).altera(request);
		verify(enderecoRepository, times(1)).salvaEndereco(endereco);
	}
	
	@Test
	void testDefinirEnderecoPrincipal() {
		Pessoa pessoa = DataHelper.createPessoa();
		Endereco endereco = mock(Endereco.class);
		UUID idPessoa = pessoa.getIdPessoa();
		UUID idEndereco = endereco.getIdEndereco();
		
		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecoPeloId(any())).thenReturn(endereco);
		doNothing().when(endereco).definirEnderecoPrincipal();
		
		Endereco retornoEnderecoPrincipal = DataHelper.getEnderecoPrincipal();

		enderecoApplicationService.definirEnderecoPrincipal(idPessoa, idEndereco);
		
		verify(endereco).pertencePessoa(pessoa);
		verify(enderecoRepository, times(1)).desativaEndereco(idPessoa);
		verify(endereco).definirEnderecoPrincipal();
		verify(enderecoRepository, times(1)).salvaEndereco(endereco);
	
		assertEquals(true, retornoEnderecoPrincipal.isPrincipal());
	}
	
	@Test
	void testObtemEnderecoPrincipal() {
		Pessoa pessoa = DataHelper.createPessoa();
		UUID idPessoa = pessoa.getIdPessoa();
		List<Endereco> enderecoList = DataHelper.getListEnderecosPrincipal();

		when(pessoaRepository.buscaPessoaPorId(any())).thenReturn(pessoa);
		when(enderecoRepository.buscaEnderecosDaPessoaComId(any())).thenReturn(enderecoList);
		
		EnderecoPessoaDetalhadoResponse response = enderecoApplicationService.obterEnderecoPrincipal(idPessoa);
		
		verify(enderecoRepository, times(1)).buscaEnderecosDaPessoaComId(idPessoa);

		assertNotNull(response);
		assertEquals(true, response.isPrincipal());
	}
}
