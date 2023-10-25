package br.com.attornatus.endereco.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Indexed;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
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
	private boolean principal;
	
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

	public void altera(EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		this.cep = enderecoAlteracaoRequest.getCep();
		this.cidade = enderecoAlteracaoRequest.getCidade();
		this.logradouro = enderecoAlteracaoRequest.getLogradouro();
		this.numero = enderecoAlteracaoRequest.getNumero();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();
	}

	public void desativaEnderecoPrincipal() {
		this.principal = false;
	}

	public void definirEnderecoPrincipal() {
		this.principal = true;
	}
}
