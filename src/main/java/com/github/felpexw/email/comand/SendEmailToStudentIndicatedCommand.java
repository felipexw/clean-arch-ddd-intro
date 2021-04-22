package com.github.felpexw.email.comand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendEmailToStudentIndicatedCommand {

	public void sendEmail(String cpf) {
		log.info("Enviando email para o aluno indicado realizar a matrícula");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		log.info("Email enviado com sucesso!");
	}

}
