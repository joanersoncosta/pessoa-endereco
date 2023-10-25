package br.com.attornatus.endereco.infra;

import org.springframework.stereotype.Repository;

import br.com.attornatus.endereco.aplication.repository.EnderecoRepository;
import br.com.attornatus.endereco.domain.Endereco;
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

}
