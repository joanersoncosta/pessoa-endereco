package br.com.attornatus.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {

	@Id
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;
	
	public Pessoa(@NotBlank String nomeCompleto, @NotNull LocalDate dataNascimento) {
		this.idPessoa = UUID.randomUUID();
		this.nomeCompleto = nomeCompleto;
		this.dataNascimento = dataNascimento;
		this.momentoDoDacastro = LocalDateTime.now();
	}
	
}
