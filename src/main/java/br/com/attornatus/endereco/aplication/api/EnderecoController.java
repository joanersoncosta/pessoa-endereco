package br.com.attornatus.endereco.aplication.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.endereco.aplication.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoIdResponse postEndereco(UUID idPessoa, @Valid EnderecoRequest EnderecoRequest) {
		log.info("[inicia] EnderecoController - postEndereco");
		log.info("[idPessoa] {}", idPessoa);
		EnderecoIdResponse enderecoIdResponse = enderecoService.criaEndereco(idPessoa, EnderecoRequest);
		log.info("[finaliza] EnderecoController - postEndereco");
		return enderecoIdResponse;
	}

	@Override
	public List<EnderecoPessoaListResponse> getEnderecoDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoController - getEnderecoDaPessoaComId");
		log.info("[idPessoa] {}", idPessoa);
		List<EnderecoPessoaListResponse> enderecosDaPessoa = enderecoService.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
		return enderecosDaPessoa;
	}

	@Override
	public EnderecoPessoaDetalhadoResponse getBuscaEnderecoPorId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - getEnderecoDaPessoaComId");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		EnderecoPessoaDetalhadoResponse enderecosDaPessoa = enderecoService.buscaEnderecoDaPessoaComId(idPessoa,
				idEndereco);
		log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
		return enderecosDaPessoa;
	}

	@Override
	public void deletaPessoaPorId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - deletaPessoaPorId");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		enderecoService.deletaEnderecoDaPessoaComId(idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - deletaPessoaPorId");
	}

	@Override
	public void patchEndereco(UUID idPessoa, UUID idEndereco,
			@Valid EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoController - patchEndereco");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		enderecoService.alteraEnderecoDaPessoaComId(idPessoa, idEndereco, enderecoAlteracaoRequest);
		log.info("[finaliza] EnderecoController - patchEndereco");
	}
	
	@Override
	public String definirEnderecoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - definirEnderecoPrincipal");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		enderecoService.definirEnderecoPrincipal(idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - definirEnderecoPrincipal");
		return "Endereço principal definido com sucesso.";
	}

	@Override
	public EnderecoPessoaDetalhadoResponse obterEnderecoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - definirEnderecoPrincipal");
		log.info("[finaliza] EnderecoController - definirEnderecoPrincipal");
		return null;
	}
}
