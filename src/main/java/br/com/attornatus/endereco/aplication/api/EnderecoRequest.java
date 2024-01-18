package br.com.attornatus.endereco.aplication.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class EnderecoRequest {
	@NotBlank
    @Size(message = "Campo cep do endereco não pode estar vazio", max = 9, min = 9)
	private String cep;
	@NotBlank
	private String cidade;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;
}
