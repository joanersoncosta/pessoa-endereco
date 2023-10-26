package br.com.attornatus.pessoa.application.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.attornatus.DataHelpher;
import br.com.attornatus.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoa.domain.Pessoa;

@ExtendWith(MockitoExtension.class)
@SpringBootTest

class PessoaApplicationTests {

	@InjectMocks
	private PessoaApplicationService PessoaApplicationService;
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@InjectMocks
	DataHelpher  dataHelpher;
	
	@Test
	 void deveRetornarPessoaPorId() {
        Pessoa pessoa = DataHelpher.createUsuario();
        UUID idPessoa = pessoa.getIdPessoa();
        when(pessoaRepository.buscaPessoaPorId(any(UUID.class))).thenReturn(pessoa);
    }

}
