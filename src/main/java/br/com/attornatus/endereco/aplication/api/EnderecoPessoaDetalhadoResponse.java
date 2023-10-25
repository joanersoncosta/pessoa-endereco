package br.com.attornatus.endereco.aplication.api;

import java.util.UUID;

import br.com.attornatus.endereco.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoPessoaDetalhadoResponse {
	private UUID idEndereco;
	private String cep;
	private String cidade;
	private String logradouro;
	private String numero;

	public EnderecoPessoaDetalhadoResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
	}
}
