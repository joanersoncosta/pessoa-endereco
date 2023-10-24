package br.com.attornatus.pessoa.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.pessoa.domain.Pessoa;

public interface PessoaSpringDataJpaRepository extends JpaRepository<Pessoa, UUID>{

	Optional<Pessoa> findByIdPessoa(UUID idPessoa);

}
