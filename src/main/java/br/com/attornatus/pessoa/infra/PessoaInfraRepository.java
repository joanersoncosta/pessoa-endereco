package br.com.attornatus.pessoa.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.handler.APIException;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PessoaInfraRepository implements PessoaRepository {
	private final PessoaSpringDataJpaRepository pessoaSpringDataJpaRepository;
	
	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		pessoaSpringDataJpaRepository.save(pessoa);
		log.info("[finaliza] PessoaInfraRepository - salva");
		return pessoa;
	}

	@Override
	public List<Pessoa> buscaTodasPessoas() {
		log.info("[inicia] PessoaInfraRepository - buscaTodasPessoas");
		List<Pessoa> findAll = pessoaSpringDataJpaRepository.findAll();
		log.info("[finaliza] PessoaInfraRepository - buscaTodasPessoas");
		return findAll;
	}

	@Override
	public Pessoa buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaInfraRepository - buscaPessoaPorId");
			Pessoa pessoa = pessoaSpringDataJpaRepository.findByIdPessoa(idPessoa)
					.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
		log.info("[finaliza] PessoaInfraRepository - buscaPessoaPorId");
		return pessoa;
	}
}
