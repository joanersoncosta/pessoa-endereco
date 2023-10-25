package br.com.attornatus.endereco.aplication.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaListResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import jakarta.validation.Valid;

public interface EnderecoService {
	EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
	List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa);
	EnderecoPessoaDetalhadoResponse buscaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco);
	void deletaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco);
}
