package br.com.attornatus.pessoa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	PessoaResponse postPessoa(@RequestBody PessoaRequest pessoaRequest);


}
