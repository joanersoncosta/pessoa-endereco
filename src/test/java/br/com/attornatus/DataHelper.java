package br.com.attornatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.domain.Pessoa;

public class DataHelper {
	private static final UUID ID_PESSOA1 = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
	private static final UUID ID_ENDERECO = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");
	
	public static Pessoa createPessoa() {
		return Pessoa.builder().idPessoa(ID_PESSOA1).nome("pessoa 1").dataNascimento(LocalDate.parse("1998-05-14")).momentoDoDacastro(LocalDateTime.now()).build();
	}

	public static PessoaRequest getPessoaRequest() {
		return new PessoaRequest("pessoa 1", LocalDate.parse("1998-05-14"));
	}
	
	public static List<Pessoa> getListPessoa() {
		return List.of(
				Pessoa.builder().idPessoa(UUID.randomUUID()).nome("Pessoa 1").dataNascimento(LocalDate.parse("1998-05-14")).momentoDoDacastro(LocalDateTime.now()).dataHoraDaultimaAlteracao(null).build(),
				Pessoa.builder().idPessoa(UUID.randomUUID()).nome("Pessoa 2").dataNascimento(LocalDate.parse("2002-02-22")).momentoDoDacastro(LocalDateTime.now()).dataHoraDaultimaAlteracao(null).build(),
				Pessoa.builder().idPessoa(UUID.randomUUID()).nome("Pessoa 3").dataNascimento(LocalDate.parse("2003-03-03")).momentoDoDacastro(LocalDateTime.now()).dataHoraDaultimaAlteracao(null).build(),
				Pessoa.builder().idPessoa(UUID.randomUUID()).nome("Pessoa 4").dataNascimento(LocalDate.parse("2004-04-15")).momentoDoDacastro(LocalDateTime.now()).dataHoraDaultimaAlteracao(null).build());
	}

	public static PessoaAlteracaoRequest editaPessoaRequest() {
		return new PessoaAlteracaoRequest("pessoa 1", LocalDate.parse("1998-05-14"));
	}
	
	public static Endereco getEndereco() {
		return Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA1).cep("147258369").cidade("Cidade 1")
				.logradouro("Rua 1").numero("121").principal(false).build();
	}

	public static EnderecoRequest getEnderecoRequest() {
		EnderecoRequest enderecoRequest = new EnderecoRequest("147468369", "Cidade 1", "Rua 1", "121");
		return enderecoRequest;
	}

	public static List<Endereco> getListEnderecos() {
		return List.of(
				Endereco.builder().idEndereco(ID_ENDERECO).idPessoa(ID_PESSOA1).cep("147258369").cidade("Cidade 1")
						.logradouro("Rua 1").numero("121").principal(false).build(),
				Endereco.builder().idEndereco(UUID.randomUUID()).idPessoa(ID_PESSOA1).cep("147258368").cidade("Cidade 2")
						.logradouro("Rua 2").numero("122").principal(false).build(),
				Endereco.builder().idEndereco(UUID.randomUUID()).idPessoa(ID_PESSOA1).cep("147258367").cidade("Cidade 3")
						.logradouro("Rua 3").numero("123").principal(false).build(),
				Endereco.builder().idEndereco(UUID.randomUUID()).idPessoa(ID_PESSOA1).cep("147258366").cidade("Cidade 4")
						.logradouro("Rua 4").numero("124").principal(false).build());
	}
}
