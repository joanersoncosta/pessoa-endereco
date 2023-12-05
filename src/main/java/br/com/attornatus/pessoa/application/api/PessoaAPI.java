package br.com.attornatus.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@ResponseStatus(code = HttpStatus.OK)
	List<PessoaListResponse> getTodasPessoas();
	
	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	PessoaDetalhadoResponse getBuscaPessoaPorId(@PathVariable(value = "idPessoa") UUID idPessoa);

	@DeleteMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaPessoaPorId(@PathVariable(value = "idPessoa") UUID idPessoa);

	@PatchMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchAlteraPessoa(@PathVariable(value = "idPessoa") UUID idPessoa, @RequestBody @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest);
}
