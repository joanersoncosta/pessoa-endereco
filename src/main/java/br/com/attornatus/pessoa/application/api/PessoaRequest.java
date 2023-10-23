package br.com.attornatus.pessoa.application.api;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PessoaRequest {
	
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
}
