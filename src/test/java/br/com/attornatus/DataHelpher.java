package br.com.attornatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.domain.Pessoa;

public class DataHelpher {
	private static final UUID pessoa1 = UUID.fromString("b893162g-31a2-4db9-c88b-70dd91zh16t3");

	public static Pessoa createUsuario() {
		return Pessoa.builder().idPessoa(pessoa1).nomeCompleto("pessoa request").dataNascimento(LocalDate.parse("1998-05-14")).build();
	}

	public static Endereco createEndereco() {
		return 	Endereco.builder().cep("147258369").cidade("Itabuna").logradouro("Rua Castro Alves").numero("123").build();

	}

	public static EnderecoRequest getEnderecoRequest() {
		EnderecoRequest enderecoRequest = new EnderecoRequest("159753286", "Itabuna", "Rua Castro Alves", "123");
		return enderecoRequest;
	}

	public static List<Endereco> createListTarefa() {
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
}
