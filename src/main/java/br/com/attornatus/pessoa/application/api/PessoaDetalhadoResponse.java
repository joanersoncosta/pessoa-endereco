package br.com.attornatus.pessoa.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadoResponse {
	private UUID idPessoa;
	private String nome;
	private LocalDate dataNascimento;
	private LocalDateTime momentoDoDacastro;

	public PessoaDetalhadoResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.momentoDoDacastro = LocalDateTime.now();
	}
}
