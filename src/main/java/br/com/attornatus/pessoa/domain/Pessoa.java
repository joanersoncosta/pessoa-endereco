package br.com.attornatus.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoa.application.api.PessoaRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idPessoa", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nome;
	@NotNull
	private LocalDate dataNascimento;
	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Pessoa(PessoaRequest pessoaRequest) {
		this.nome = pessoaRequest.getNome();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.momentoDoDacastro = LocalDateTime.now();	
	}

	public void altera(PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nome = pessoaAlteracaoRequest.getNome();
		this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();	
	}
}
