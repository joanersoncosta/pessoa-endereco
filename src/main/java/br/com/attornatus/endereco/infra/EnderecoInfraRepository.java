package br.com.attornatus.endereco.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
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
		try {
			enderecoSpringDataJPArepository.save(endereco);
		}catch(DataIntegrityViolationException e) {
			APIException.build(HttpStatus.BAD_REQUEST, "Cep já cadastrado para este Endereco!", e);
		}
		log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
		return endereco;
	}

	@Override
	public List<Endereco> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		var enderecos = enderecoSpringDataJPArepository.findAllByIdPessoa(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecosDaPessoaComId");
		return enderecos;
	}

	@Override
	public Endereco buscaEnderecoPeloId(UUID idEndereco) {
		log.info("[inicia] EnderecoInfraRepository - buscaEnderecoPeloId");
		var endereco = enderecoSpringDataJPArepository.findById(idEndereco)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Endereco não encontrado para o idEndereco!"));
		log.info("[finaliza] EnderecoInfraRepository - buscaEnderecoPeloId");
		return endereco;
	}

	@Override
	public void deletaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - deletaEndereco");
		enderecoSpringDataJPArepository.delete(endereco);
		log.info("[finaliza] EnderecoInfraRepository - deletaEndereco");
	}

	@Override
	public void desativaEndereco(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - desativaEndereco");
		List<Endereco> enderecosDaPessoa = buscaEnderecosDaPessoaComId(idPessoa);
		enderecosDaPessoa.stream().filter(Endereco::isPrincipal)
		.forEach(n -> {
			if (n.isPrincipal() == true)
				n.desativaEnderecoPrincipal();
				salvaEndereco(n);
		});
		log.info("[finaliza] EnderecoInfraRepository - desativaEndereco");
	}

}
