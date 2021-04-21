package com.github.felpexw.shared.domain.event;

import java.util.Map;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentIndicatedToClassRoomEvent implements DomainEvent {

	private final String cpf;

	@Override
	public Map<String, String> getInfo() {
		return Map.of("cpf", cpf);
	}

	@Override
	public DomainEventType eventType() {
		return DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT;
	}

}
