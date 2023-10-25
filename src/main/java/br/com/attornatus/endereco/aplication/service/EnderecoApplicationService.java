package br.com.attornatus.endereco.aplication.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaListResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.aplication.repository.EnderecoRepository;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.pessoa.application.service.PessoaService;
import br.com.attornatus.pessoa.domain.Pessoa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaService PessoaService;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		PessoaService.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return EnderecoIdResponse.builder()
				.idEndereco(endereco.getIdEndereco())
				.build();
	}

	@Override
	public List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		PessoaService.buscaPessoaPorId(idPessoa);
		List<Endereco> enderecosDaPessoa = enderecoRepository.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return EnderecoPessoaListResponse.converte(enderecosDaPessoa);
	}

	@Override
	public EnderecoPessoaDetalhadoResponse buscaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		PessoaService.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		return new EnderecoPessoaDetalhadoResponse(endereco);
	}

	@Override
	public void deletaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - deletaEnderecoDaPessoaComId");
		PessoaService.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		enderecoRepository.deletaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - deletaEnderecoDaPessoaComId");
	}

	@Override
	public void alteraEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco,
			EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
		PessoaService.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		endereco.altera(enderecoAlteracaoRequest);
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
	}

	@Override
	public void definirEnderecoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - definirEnderecoPrincipal");
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		endereco.desativaEnderecoPrincipal();
		endereco.definirEnderecoPrincipal();
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - definirEnderecoPrincipal");
	}
}

