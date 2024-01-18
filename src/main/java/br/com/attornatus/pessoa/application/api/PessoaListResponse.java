package br.com.attornatus.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaListResponse {
	private UUID idPessoa;
	private String nome;
	private LocalDate dataNascimento;
	
	public PessoaListResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
	}
	
	public static List<PessoaListResponse> converteListaPessoas(List<Pessoa> pessoas){
		return pessoas.stream().map(PessoaListResponse::new).collect(Collectors.toList());
	}
}
