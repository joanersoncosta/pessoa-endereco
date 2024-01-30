package br.com.attornatus.endereco.aplication.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.attornatus.endereco.aplication.api.EnderecoAlteracaoRequest;
import br.com.attornatus.endereco.aplication.api.EnderecoIdResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaDetalhadoResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoPessoaListResponse;
import br.com.attornatus.endereco.aplication.api.EnderecoRequest;
import br.com.attornatus.endereco.aplication.repository.EnderecoRepository;
import br.com.attornatus.endereco.domain.Endereco;
import br.com.attornatus.handler.APIException;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;

	@Override
	public EnderecoIdResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return EnderecoIdResponse.builder()
				.idEndereco(endereco.getIdEndereco())
				.build();
	}

	@Override
	public List<EnderecoPessoaListResponse> buscaEnderecosDaPessoaComId(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		List<Endereco> enderecosDaPessoa = enderecoRepository.buscaEnderecosDaPessoaComId(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return EnderecoPessoaListResponse.converte(enderecosDaPessoa);
	}

	@Override
	public EnderecoPessoaDetalhadoResponse buscaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		log.info("[finaliza] EnderecoApplicationService - buscaEnderecoDaPessoaComId");
		return new EnderecoPessoaDetalhadoResponse(endereco);
	}

	@Override
	public void deletaEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - deletaEnderecoDaPessoaComId");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		enderecoRepository.deletaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - deletaEnderecoDaPessoaComId");
	}

	@Override
	public void alteraEnderecoDaPessoaComId(UUID idPessoa, UUID idEndereco,
			EnderecoAlteracaoRequest enderecoAlteracaoRequest) {
		log.info("[inicia] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		endereco.altera(enderecoAlteracaoRequest);
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - alteraEnderecoDaPessoaComId");
	}

	@Override
	public void definirEnderecoPrincipal(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoApplicationService - definirEnderecoPrincipal");
		Pessoa pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.buscaEnderecoPeloId(idEndereco);
		endereco.pertencePessoa(pessoa);
		enderecoRepository.desativaEndereco(idPessoa);
		endereco.definirEnderecoPrincipal();
		enderecoRepository.salvaEndereco(endereco);
		log.info("[finaliza] EnderecoApplicationService - definirEnderecoPrincipal");
	}

	@Override
	public EnderecoPessoaDetalhadoResponse obterEnderecoPrincipal(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - obterEnderecoPrincipal");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = obterEndereco(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - obterEnderecoPrincipal");
		return new EnderecoPessoaDetalhadoResponse(endereco);
	}
	
	private Endereco obterEndereco(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - obterEndereco");
		List<Endereco> enderecosDaPessoa = enderecoRepository.buscaEnderecosDaPessoaComId(idPessoa);
		Optional<Endereco> getEndereco = enderecosDaPessoa.stream()
				.filter(n -> n.isPrincipal() == true)
				.map(n -> {
						return n;
				}).findFirst();
		
		Endereco endereco = getEndereco.orElseThrow(
				() -> APIException.build(HttpStatus.NOT_FOUND, "Endereço principal não encontrado"));
		log.info("[finaliza] EnderecoApplicationService - obterEndereco");
		return endereco;
	}
}

