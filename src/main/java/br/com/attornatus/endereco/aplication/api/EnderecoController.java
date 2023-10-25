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
		List<EnderecoPessoaListResponse>enderecosDaPessoa = enderecoService.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
		return enderecosDaPessoa;
	}

	@Override
	public EnderecoDetalhadoResponse getBuscaEnderecoPorId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController - getEnderecoDaPessoaComId");
		log.info("[idPessoa] {} - [idEndereco] {}", idPessoa, idEndereco);
		log.info("[finaliza] EnderecoController - getEnderecoDaPessoaComId");
		return null;
	}

}
