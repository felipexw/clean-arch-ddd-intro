package com.github.felpexw.academic.domain.event;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.shared.domain.common.DomainEventType;

@DisplayName("[ACADEMIC] Student registered to class room event indication")
class StudentRegisteredToClassRoomByIndicationEventTest {

	private StudentRegisteredToClassRoomByIndicationEvent evt = new StudentRegisteredToClassRoomByIndicationEvent(
			"123.456.789-12");

	@Test
	@DisplayName("Event type")
	void eventTypeTest() {
		Assertions.assertThat(evt.eventType())
				.isEqualTo(DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM_BY_INDICATION_EVENT);
	}

	@Test
	@DisplayName("Event type")
	void infoTest() {
		Assertions.assertThat(evt.info()).hasSize(1);
		Assertions.assertThat(evt.info().containsKey("cpf")).isTrue();
		Assertions.assertThat(evt.info().containsKey("cpf")).isTrue();
		Assertions.assertThat(evt.info().get("cpf")).isEqualTo("123.456.789-12");
	}

}
