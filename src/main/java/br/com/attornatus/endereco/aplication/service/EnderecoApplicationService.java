package br.com.attornatus.endereco.aplication.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class EnderecoApplicationService implements EnderecoService {


	@Override
	public EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		return null;
	}

}

