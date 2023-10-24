package br.com.attornatus.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadoResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;

	public PessoaDetalhadoResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
	}

}
