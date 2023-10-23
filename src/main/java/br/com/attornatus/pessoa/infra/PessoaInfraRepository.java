package br.com.attornatus.pessoa.infra;

import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class PessoaInfraRepository implements PessoaRepository {

	@Override
	public Pessoa salva(Pessoa pessoa) {
		log.info("[inicia] PessoaInfraRepository - salva");
		log.info("[finaliza] PessoaInfraRepository - salva");

		return pessoa;
	}
	

}
