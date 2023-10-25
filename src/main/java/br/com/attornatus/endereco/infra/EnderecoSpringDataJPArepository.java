package br.com.attornatus.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.endereco.domain.Endereco;

public interface EnderecoSpringDataJPArepository extends JpaRepository<Endereco, UUID>{
	List<Endereco>findByIdPessoa(UUID idPessoa);
}
