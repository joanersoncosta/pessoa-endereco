package br.com.attornatus.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.endereco.aplication.repository.EnderecoRepository;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {

	private final EnderecoSpringDataJPArepository enderecoSpringDataJPArepository;
	
	@Override
	public Endereco salvaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - salvaEndereco");
		enderecoSpringDataJPArepository.save(endereco);
		log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
		return endereco;
	}

	@Override
	public List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		var enderecos = enderecoSpringDataJPArepository.findByIdPessoa(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		return enderecos;
	}

	@Override
	public Endereco buscaEnderecoPeloId(UUID idEndereco) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecoPeloId");
		var endereco = enderecoSpringDataJPArepository.findById(idEndereco)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereco não encontrado para o idEndereco = " + idEndereco));
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoPeloId");
		return endereco;
	}

	@Override
	public void deletaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - deletaEndereco");
		enderecoSpringDataJPArepository.delete(endereco);
		log.info("[finaliza] EnderecoInfraRepository - deletaEndereco");
	}
}
