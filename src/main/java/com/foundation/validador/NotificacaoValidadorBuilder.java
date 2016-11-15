package com.foundation.validador;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.collections4.CollectionUtils;

import com.foundation.dto.ParSorteadoDTO;

public class NotificacaoValidadorBuilder extends AbstractValidadorBuilder{

	public static NotificacaoValidadorBuilder newInstance() {
		return new NotificacaoValidadorBuilder();
	}
	
	public NotificacaoValidadorBuilder validarParesSorteadosVazio(List<ParSorteadoDTO> paresSorteados) {
		if(CollectionUtils.isEmpty(paresSorteados)) {
			getValidacoes().adicionarValidacaoRegraNegocio("Nenhum par Sorteado para notificação.");
		}
		return this;
	}
	
	public NotificacaoValidadorBuilder validarEmails(List<ParSorteadoDTO> paresSorteados) {
		for (ParSorteadoDTO parSorteadoDTO : paresSorteados) {
			String email = parSorteadoDTO.getPessoa1().getEmail();
			try {
				InternetAddress ia = new InternetAddress(email);
				ia.validate();
			} catch (AddressException e) {
				getValidacoes().adicionarValidacaoRegraNegocio("Email: '"+email+"' inválido.");
			}
			
		}
		return this;
	}
	
}
