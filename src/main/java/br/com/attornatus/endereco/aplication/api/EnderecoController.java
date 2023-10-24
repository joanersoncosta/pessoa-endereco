package br.com.attornatus.endereco.aplication.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class EnderecoController implements EnderecoAPI {

	@Override
	public EnderecoIdResponse postEndereco(UUID idPessoa, @Valid EnderecoRequest EnderecoRequest) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", idPessoa);
		log.info("[finaliza] EnderecoController - postEndereco");
		return null;
	}

}
