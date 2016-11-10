package com.foundation.dto;

public class ParSorteadoDTO {

	private ParticipanteDTO pessoa1;
	private ParticipanteDTO pessoa2;
	
	public ParSorteadoDTO() {
		super();
	}

	public ParSorteadoDTO(ParticipanteDTO pessoa1, ParticipanteDTO pessoa2) {
		super();
		this.pessoa1 = pessoa1;
		this.pessoa2 = pessoa2;
	}

	public ParticipanteDTO getPessoa1() {
		return pessoa1;
	}

	public void setPessoa1(ParticipanteDTO pessoa1) {
		this.pessoa1 = pessoa1;
	}

	public ParticipanteDTO getPessoa2() {
		return pessoa2;
	}

	public void setPessoa2(ParticipanteDTO pessoa2) {
		this.pessoa2 = pessoa2;
	}
	
}
