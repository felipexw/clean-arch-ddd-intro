package com.github.felpexw.academic.domain.listener;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "identification", callSuper = false)
public class StudentRegisteredToClassRoomEventListener extends DomainEventListener {

	private final StudentIndicationRepository repository;
	private final DomainEventPublisher publisher;
	private String identification;

	public StudentRegisteredToClassRoomEventListener(StudentIndicationRepository repository,
			DomainEventPublisher publisher) {
		this.identification = this.identification();
		this.repository = repository;
		this.publisher = publisher;
	}

	@Override
	public void reactTo(DomainEvent evt) {
		log.info(String.format("\n===\n [StudentRegisteredToClassRoomEventListener:%s]:: %s", evt.when(),
				evt.compileInfo()));

		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}

		final String ID = evt.info().get("cpf");
		if (repository.itWasIndicated(ID)) {
			publisher.publish(new StudentRegisteredToClassRoomByIndicationEvent(ID));
		}

	}

	@Override
	public String identification() {
		return this.getClass().getName();
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM;
	}

}
