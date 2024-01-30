package br.com.attornatus.endereco.aplication.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.attornatus.endereco.domain.Endereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa);
	Endereco buscaEnderecoPeloId(UUID idEndereco);
	void deletaEndereco(Endereco endereco);
	void desativaEndereco(UUID idPessoa);
}
