package com.github.felpexw.academic.domain.event;

import java.util.Map;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentRegisteredToClassRoomByIndicationEvent implements DomainEvent{
	
	private final String cpf;
	
	@Override
	public Map<String, String> info() {
		return Map.of("cpf", cpf);
	}

	@Override
	public DomainEventType eventType() {
		return DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM_BY_INDICATION_EVENT;
	}

}
