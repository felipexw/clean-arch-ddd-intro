package com.github.felpexw.email.comand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.email.domain.command.SendEmailToStudentIndicatedCommand;

@DisplayName("[EMAIL] Sending email to someone use case")
class SendEmailToStudentIndicatedCommandTest {

	private SendEmailToStudentIndicatedCommand sendEmailUseCase = new SendEmailToStudentIndicatedCommand();

	@Test
	@DisplayName("[DUMMY TEST] sending email to sommeone test")
	void sendEmailTest() {
		sendEmailUseCase.sendEmail("123123");
	}

}
