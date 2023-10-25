package br.com.attornatus.endereco.aplication.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.endereco.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoPessoaListResponse {
	private UUID idEndereco;
	private String cep;
	private String cidade;
	private String logradouro;
	private String numero;

	public EnderecoPessoaListResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
	}
	
	public static List<EnderecoPessoaListResponse> converte(List<Endereco> enderecosDaPessoa) {
		return enderecosDaPessoa
				.stream()
				.map(EnderecoPessoaListResponse::new)
				.collect(Collectors.toList());
	}
}
