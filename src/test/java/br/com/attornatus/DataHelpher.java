package br.com.attornatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaDetalhadoResponse;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.domain.Pessoa;

public class DataHelpher {
	private static final UUID pessoa1 = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");

	public static Pessoa createPessoa() {
		return Pessoa.builder().idPessoa(pessoa1).nomeCompleto("pessoa request").dataNascimento(LocalDate.parse("1998-05-14")).build();
	}

	public static PessoaRequest createPessoaRequest() {
		return new PessoaRequest("pessoa request", LocalDate.parse("1998-05-14"));
	}
	
	public static List<Pessoa> createListPessoas() {
		return List.of(
				Pessoa.builder().idPessoa(pessoa1).nomeCompleto("Pessoa 1").dataNascimento(LocalDate.parse("2001-11-11")).build(),
				Pessoa.builder().idPessoa(pessoa1).nomeCompleto("Pessoa 2").dataNascimento(LocalDate.parse("2002-02-22")).build(),
				Pessoa.builder().idPessoa(pessoa1).nomeCompleto("Pessoa 3").dataNascimento(LocalDate.parse("2003-03-03")).build(),
				Pessoa.builder().idPessoa(pessoa1).nomeCompleto("Pessoa 4").dataNascimento(LocalDate.parse("2004-04-14")).build());
	}
	
	public static Endereco createEndereco() {
		return 	Endereco.builder().idEndereco(pessoa1).cep("147258369").cidade("Itabuna").logradouro("Rua Castro Alves").numero("123").build();

	}

	public static EnderecoRequest getEnderecoRequest() {
		EnderecoRequest enderecoRequest = new EnderecoRequest("159753286", "Itabuna", "Rua Castro Alves", "123");
		return enderecoRequest;
	}

	public static List<Endereco> createListEnderecos() {
		return List.of(
			Endereco.builder().cep("147258369").cidade("Cidade 1").logradouro("Rua 1").numero("11").build(),
			Endereco.builder().cep("247258349").cidade("Cidade 2").logradouro("Rua 2").numero("22").build(),
			Endereco.builder().cep("347252369").cidade("Cidade 3").logradouro("Rua 3").numero("33").build(),
			Endereco.builder().cep("447258369").cidade("Cidade 4").logradouro("Rua 4").numero("44").build());
	}

	public EnderecoAlteracaoRequest createEditaEnderecoRequest() {
		EnderecoAlteracaoRequest request = new EnderecoAlteracaoRequest("00000000", "Cidade atualizada", "Rua alterada", "111");;
		return request;
	}

	public static PessoaAlteracaoRequest createEditaPessoaRequest() {
		PessoaAlteracaoRequest request = new PessoaAlteracaoRequest("Teste Alteracao", LocalDate.parse("2000-05-12"));
		return request;
	}
	
	public static PessoaRequest pessoaRequest() {
		PessoaRequest request = new PessoaRequest("Teste Alteracao", LocalDate.parse("2000-05-12"));
		return request;
	}

	public static PessoaIdResponse createPessoaIdResponse() {
		return PessoaIdResponse.builder().idPessoa(pessoa1).build();
	}
}
