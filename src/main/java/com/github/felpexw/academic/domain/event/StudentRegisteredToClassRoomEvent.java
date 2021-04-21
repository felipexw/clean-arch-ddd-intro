package com.github.felpexw.academic.domain.event;

import java.util.Map;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentRegisteredToClassRoomEvent implements DomainEvent {

	private final CPF cpf;

	@Override
	public Map<String, String> getInfo() {
		return Map.of("cpf", cpf.getNumber());
	}

	@Override
	public DomainEventType eventType() {
		return DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM;
	}

}
