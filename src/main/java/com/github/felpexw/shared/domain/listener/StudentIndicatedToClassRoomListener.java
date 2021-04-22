package com.github.felpexw.shared.domain.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "identification", callSuper = false)
public class StudentIndicatedToClassRoomListener extends DomainEventListener {

	private String identification;

	public StudentIndicatedToClassRoomListener() {
		this.identification = this.identification();
	}

	@Override
	public void reactTo(DomainEvent evt) {
		log.info(String.format("\n===\n [StudentIndicatedToClassRoomListener-%s]:: Enviando email para o estudante...",
				evt.when()));

		try {
			// simulating business logic.
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
