package br.com.attornatus.endereco.aplication.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EnderecoAlteracaoRequest {
	@NotBlank
	private String cep;
	@NotBlank
	private String cidade;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
}
