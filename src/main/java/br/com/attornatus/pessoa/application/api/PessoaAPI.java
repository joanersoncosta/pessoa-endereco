package br.com.attornatus.pessoa.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	PessoaIdResponse postPessoa(@RequestBody @Valid PessoaRequest pessoaRequest);

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<PessoaListResponse> getTodasPessoas();

}
