package br.com.attornatus.endereco.aplication.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa);
	Endereco buscaEnderecoPeloId(UUID idEndereco);
	void deletaEndereco(Endereco endereco);
	Endereco desativaEndereco(EnderecoPessoaDetalhadoResponse buscaEndereco);
}
