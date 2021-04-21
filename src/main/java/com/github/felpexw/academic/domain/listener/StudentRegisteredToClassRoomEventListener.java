package com.github.felpexw.academic.domain.listener;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentRegisteredToClassRoomEventListener extends DomainEventListener {

	private final StudentIndicationRepository repository;
	private final DomainEventPublisher publisher;

	@Override
	public void reactTo(DomainEvent evt) {
		System.out.println(String.format("\n===\n [StudentRegisteredToClassRoomEventListener:%s]:: %s", evt.when(),
				evt.compileInfo()));

		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final String ID = evt.info().get("cpf");
		if (repository.itWasIndicated(ID)) {
			publisher.publish(new StudentRegisteredToClassRoomByIndicationEvent(ID));
		}

	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM;
	}

}
