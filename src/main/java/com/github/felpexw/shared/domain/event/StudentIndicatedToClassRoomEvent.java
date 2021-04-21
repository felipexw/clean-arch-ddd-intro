package com.github.felpexw.shared.domain.event;

import java.util.Map;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(of = "cpf", callSuper = false)
public class StudentIndicatedToClassRoomEvent implements DomainEvent {

	private final String cpf;

	@Override
	public Map<String, String> info() {
		return Map.of("cpf", cpf);
	}

	@Override
	public DomainEventType eventType() {
		return DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT;
	}

}
