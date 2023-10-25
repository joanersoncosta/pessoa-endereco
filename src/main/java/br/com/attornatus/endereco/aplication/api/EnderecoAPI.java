package br.com.attornatus.endereco.aplication.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
public interface EnderecoAPI {
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	EnderecoIdResponse postEndereco(@PathVariable UUID idPessoa, @RequestBody @Valid EnderecoRequest EnderecoRequest);
}