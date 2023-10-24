package br.com.attornatus.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoa.application.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {

	private final PessoaService pessoaService;
	
	@Override
	public PessoaIdResponse postPessoa(@Valid PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaIdResponse pessoaCriada = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaCriada;
	}

	@Override
	public List<PessoaListResponse> getTodasPessoas() {
		log.info("[inicia] PessoaController - getTodasPessoas");
		List<PessoaListResponse> pessoas = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - getTodasPessoas");
		return pessoas;
	}

	@Override
	public PessoaDetalhadoResponse getBuscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaController - getBuscaPessoaPorId");
		log.info("[idPessoa] {}", idPessoa);
		PessoaDetalhadoResponse pessoaDetalhado = pessoaService.buscaPessoaPorId(idPessoa);
		log.info("[finaliza] PessoaController - getBuscaPessoaPorId");
		return pessoaDetalhado;
	}

	@Override
	public void deletaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaController - deletaPessoaPorId");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.deletaPessoaPorId(idPessoa);
		log.info("[finaliza] PessoaController - deletaPessoaPorId");
	}

	@Override
	public void patchAlteraPessoa(UUID idPessoa, @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaController - patchAlteraPessoa");
		log.info("[idPessoa] {}", idPessoa);
		pessoaService.patchAlteraPessoa(idPessoa, pessoaAlteracaoRequest);
		log.info("[finaliza] PessoaController - patchAlteraPessoa");
	}
}
