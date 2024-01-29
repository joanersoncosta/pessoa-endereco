package br.com.attornatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoa.domain.Pessoa;

public class DataHelper {
	private static final UUID pessoa1 = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");

	public static Pessoa createPessoa() {
		return Pessoa.builder().idPessoa(pessoa1).nome("pessoa 1").dataNascimento(LocalDate.parse("1998-05-14")).momentoDoDacastro(LocalDateTime.now()).build();
	}

	public static PessoaRequest getPessoaRequest() {
		return new PessoaRequest("pessoa 1", LocalDate.parse("1998-05-14"));
	}
}
