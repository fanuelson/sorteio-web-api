package com.foundation.emailModel;

import com.foundation.dto.ParSorteadoDTO;

import br.com.any.annotation.VelocityParameter;
import br.com.any.annotation.VelocityTemplate;
import br.com.any.template.AbstractVelocityTemplate;

@VelocityTemplate(templateFileName = "emailNotificacaoSorteio.vm")
public class EmailNotificacaoModel extends AbstractVelocityTemplate {

	@VelocityParameter
	private String participante;

	@VelocityParameter
	private String participantes;

	@VelocityParameter
	private String sorteado;
	
	public EmailNotificacaoModel() {
		super();
	}
	
	public EmailNotificacaoModel(String participantesFormatados, ParSorteadoDTO par) {
		this.participante = par.getPessoa1().getNome();
		this.sorteado = par.getPessoa2().getNome();
		this.participantes = participantesFormatados;
	}

	public EmailNotificacaoModel(String participante, String participantes, String sorteado) {
		super();
		this.participante = participante;
		this.participantes = participantes;
		this.sorteado = sorteado;
	}

	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public String getParticipantes() {
		return participantes;
	}

	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}

	public String getSorteado() {
		return sorteado;
	}

	public void setSorteado(String sorteado) {
		this.sorteado = sorteado;
	}

	@Override
	public String getTemplateDirectory() {
		return "/src/main/resources/emailTemplate/";
	}

}
