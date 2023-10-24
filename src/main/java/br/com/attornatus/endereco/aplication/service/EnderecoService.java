package br.com.attornatus.endereco.aplication.service;

import java.util.UUID;

import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import jakarta.validation.Valid;

public interface EnderecoService {
	EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest);
}
