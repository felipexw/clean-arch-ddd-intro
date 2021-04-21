package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IndicateStudentToClassRoomCommand {

	private final DomainEventPublisher publisher;
	private final CPF cpf;

	public void indicateStudent() {
		System.out.println("Indicando aluno...");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		publisher.publish(new StudentIndicatedToClassRoomEvent(cpf.getNumber()));
	}
}
