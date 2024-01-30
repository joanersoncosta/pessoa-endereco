package br.com.attornatus.endereco.aplication.api;

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
@RequestMapping("/v1/pessoa/{idPessoa}/endereco")
public interface EnderecoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoIdResponse postEndereco(@PathVariable UUID idPessoa, @RequestBody @Valid EnderecoRequest enderecoRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<EnderecoPessoaListResponse> getEnderecoDaPessoaComId(@PathVariable(value = "idPessoa") UUID idPessoa);

	@GetMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.OK)
	EnderecoPessoaDetalhadoResponse getBuscaEnderecoPorId(@PathVariable(value = "idPessoa") UUID idPessoa, @PathVariable(value = "idEndereco") UUID idEndereco);

	@DeleteMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaPessoaPorId(@PathVariable(value = "idPessoa") UUID idPessoa, @PathVariable(value = "idEndereco") UUID idEndereco);

	@PatchMapping(value = "/{idEndereco}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void patchEndereco(@PathVariable UUID idPessoa, @PathVariable(value = "idEndereco") UUID idEndereco, @RequestBody @Valid EnderecoAlteracaoRequest enderecoAlteracaoRequest);
	
	@PatchMapping(value = "/{idEndereco}/principal")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void definirEnderecoPrincipal(@PathVariable(value = "idPessoa") UUID idPessoa, @PathVariable(value = "idEndereco") UUID idEndereco);

	@GetMapping(value = "/principal")
	@ResponseStatus(code = HttpStatus.OK)
	EnderecoPessoaDetalhadoResponse obterEnderecoPrincipal(@PathVariable(value = "idPessoa") UUID idPessoa);
}
