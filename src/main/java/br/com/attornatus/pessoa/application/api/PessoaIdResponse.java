package br.com.attornatus.pessoa.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PessoaIdResponse {
	private UUID idPessoa;
}
