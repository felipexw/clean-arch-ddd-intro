package com.github.felpexw.email.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "identification", callSuper = false)
public class SendEmailToStudentListener extends DomainEventListener {

	private String identification;

	public SendEmailToStudentListener() {
		this.identification = identification();
	}

	@Override
	public void reactTo(DomainEvent evt) {
		log.info("\n===\n SendEmailToStudentListener:: Enviando email ....");

		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("E-mail enviado com sucesso");
	}

	@Override
	public String identification() {
		return this.getClass().getName();
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT;
	}

}
