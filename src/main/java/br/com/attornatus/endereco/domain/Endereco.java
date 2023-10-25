package br.com.attornatus.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "idEndereco", updatable = false, unique = true, nullable = false)
	private UUID idEndereco;
	@NotNull
	@Column(columnDefinition = "uuid", name = "idPessoa", nullable = false)
	private UUID idPessoa;
	@NotBlank
	@Column(unique = true)
	private String cep;
	@NotBlank
	private String cidade;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String numero;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Endereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		this.idPessoa = idPessoa;
		this.cep = enderecoRequest.getCep();
		this.cidade = enderecoRequest.getCidade();
		this.logradouro = enderecoRequest.getLogradouro();
		this.numero = enderecoRequest.getNumero();
		this.momentoDoDacastro = LocalDateTime.now();
	}
}
