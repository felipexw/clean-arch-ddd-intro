package com.github.felpexw.email.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

public class SendEmailToStudentListener extends DomainEventListener {

	@Override
	public void reactTo(DomainEvent evt) {
		System.out.println("\n===\n SendEmailToStudentListener:: Enviando email ....");

		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("E-mail enviado com sucesso");
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT;
	}

}
