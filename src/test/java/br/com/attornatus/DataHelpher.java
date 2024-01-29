package br.com.attornatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaIdResponse;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.domain.Pessoa;

public class DataHelpher {
	private static final UUID ID_PESSOA = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
	private static final UUID ID_PESSOA_INEXISTENTE = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
	private static final UUID ID_PESSOA_INVALIDO = UUID.fromString("Ola mundo");
	private static final UUID ID_ENDERECO = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
	private static final UUID ID_ENDERECO_INVALIDO = UUID.fromString("Ola mundo");
	private static final UUID ID_ENDERECO_INEXISTENTE = UUID.fromString("06fb5521-9d5a-461a-82fb-e67e3bedc6eb");

	public static Pessoa createPessoa() {
		return Pessoa.builder().idPessoa(ID_PESSOA).nome("pessoa 1").dataNascimento(LocalDate.parse("1998-05-14"))
				.build();
	}
	
	public static Pessoa novaPessoa(PessoaRequest pessoaRequest) {
		return 	Pessoa.builder().idPessoa(ID_PESSOA).nome(pessoaRequest.getNome()).dataNascimento(pessoaRequest.getDataNascimento())
				.build();
	}

	public static PessoaRequest createPessoaRequest() {
		return new PessoaRequest("pessoa request", LocalDate.parse("1998-05-14"));
	}

	public static List<Pessoa> createListPessoas() {
		return List.of(createPessoa(),
				Pessoa.builder().idPessoa(ID_PESSOA).nome("Pessoa 2").dataNascimento(LocalDate.parse("2002-02-22"))
						.build(),
				Pessoa.builder().idPessoa(ID_PESSOA).nome("Pessoa 3").dataNascimento(LocalDate.parse("2003-03-03"))
						.build(),
				Pessoa.builder().idPessoa(ID_PESSOA).nome("Pessoa 4").dataNascimento(LocalDate.parse("2004-04-14"))
						.build());
	}

	public static Endereco createEndereco() {
		return Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA).cep("147258369").cidade("Itabuna")
				.logradouro("Rua Castro Alves").numero("123").principal(false).build();

	}

	public static EnderecoRequest getEnderecoRequest() {
		EnderecoRequest enderecoRequest = new EnderecoRequest("147468369", "Itabuna", "Rua Castro Alves", "113");
		return enderecoRequest;
	}

	public static List<Endereco> createListEnderecos() {
		return List.of(
				Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA).cep("147258369").cidade("Cidade 1")
						.logradouro("Rua Castro Alves").numero("123").principal(false).build(),
				Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA).cep("147258368").cidade("Cidade 2")
						.logradouro("Rua Castro Alves").numero("124").principal(false).build(),
				Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA).cep("147258367").cidade("Cidade 3")
						.logradouro("Rua Castro Alves").numero("125").principal(false).build(),
				Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA).cep("147258366").cidade("Cidade 4")
						.logradouro("Rua Castro Alves").numero("126").principal(false).build());
	}

	public EnderecoAlteracaoRequest createEditaEnderecoRequest() {
		EnderecoAlteracaoRequest request = new EnderecoAlteracaoRequest("00000000", "Cidade atualizada", "Rua alterada",
				"111");
		;
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
		return PessoaIdResponse.builder().idPessoa(ID_PESSOA).build();
	}
}
