package com.foundation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foundation.dto.ParSorteadoDTO;
import com.foundation.dto.ParticipanteDTO;
import com.foundation.emailModel.EmailNotificacaoModel;
import com.foundation.exception.EmailException;
import com.foundation.properties.EmailAuthProperties;

import br.com.any.builder.EmailBuilder;
import br.com.any.model.Email;
import br.com.any.service.VelocityGeneratorService;

@Service
public class NotificacaoEmailService extends AbstractService {

	@Autowired
	private EmailAuthProperties emailAuthPropertyUtils;
	
	@Autowired
	private CustomEmailService customEmailService;
	
	public void notificarParticipantes(List<ParSorteadoDTO> paresSorteados) {
		if(CollectionUtils.isEmpty(paresSorteados)) {
			throw new EmailException("Nenhum par Sorteado para notificação.");
		}
		String participantesFormatados = getParticipantesFormatadosByPares(paresSorteados);
		for (ParSorteadoDTO parSorteadoDTO : paresSorteados) {
			notificarParticipante(participantesFormatados, parSorteadoDTO);
		}
	}
	
	public void notificarParticipante(String participantesFormatados, ParSorteadoDTO parSorteado) {
		try{
			Email email = new EmailBuilder()
					.from(emailAuthPropertyUtils.getUsername())
					.to(parSorteado.getPessoa1().getEmail())
					.subject("NOTIFICAÇÃO DE SORTEIO")
					.htmlBody(getHtmlTextNotificacao(participantesFormatados, parSorteado))
					.build();
			
			customEmailService.enviar(email);
		} catch (Exception e) {
			throw new EmailException("Ocorreu um erro interno ao enviar email de notificação.");
		}
	}
	
	public String getHtmlTextNotificacao(String participantesFormatados, ParSorteadoDTO parSorteado) {
		VelocityGeneratorService vgs = new VelocityGeneratorService();
		EmailNotificacaoModel enm = new EmailNotificacaoModel(participantesFormatados, parSorteado);
		return vgs.generateString(enm);
	}
	
	public String getParticipantesFormatadosByPares(List<ParSorteadoDTO> parts) {
		List<ParticipanteDTO> participantesFormatados = new ArrayList<>();
		for (ParSorteadoDTO parSorteadoDTO : parts) {
			participantesFormatados.add(parSorteadoDTO.getPessoa1());
		}
		return getParticipantesFormatados(participantesFormatados);
	}
	
	public String getParticipantesFormatados(List<ParticipanteDTO> parts) {
		List<String> nomesParticipantes = new ArrayList<>();
		for (ParticipanteDTO p : parts) {
			nomesParticipantes.add(p.getNome());
		}
		
		return getNomesFormatados(nomesParticipantes);
	}
	
	public String getNomesFormatados(List<String> nomes) {
		return StringUtils.join(nomes, ", ");
	}
}
