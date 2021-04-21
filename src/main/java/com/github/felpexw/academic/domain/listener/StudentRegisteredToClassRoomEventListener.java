package com.github.felpexw.academic.domain.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

public class StudentRegisteredToClassRoomEventListener extends DomainEventListener {

	@Override
	public void reactTo(DomainEvent evt) {
		System.out.println(evt.compileInfo());
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM;
	}

}
