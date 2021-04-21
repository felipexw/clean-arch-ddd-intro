package com.github.felpexw.shared.domain.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

public class StudentIndicatedToClassRoomListener extends DomainEventListener {

	@Override
	public void reactTo(DomainEvent evt) {
		System.out.println(String.format(
				"\n===\n [StudentIndicatedToClassRoomListener-%s]:: Enviando email para o estudante...", evt.when()));

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT;
	}

}
