package br.com.attornatus.endereco.aplication.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EnderecoIdResponse {
	private UUID idEndereco;
}
