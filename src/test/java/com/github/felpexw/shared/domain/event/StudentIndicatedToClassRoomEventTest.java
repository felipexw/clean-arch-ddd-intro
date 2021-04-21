package com.github.felpexw.shared.domain.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.shared.domain.common.DomainEventType;

@DisplayName("[SHARED] Student indicated to class room event")
class StudentIndicatedToClassRoomEventTest extends BaseTest {

	private final StudentIndicatedToClassRoomEvent evt = new StudentIndicatedToClassRoomEvent("123.456.789-12");

	@Test
	@DisplayName("Test if the indicated to class room event information it's returning as expected")
	void infoTest() {
		assertThat(evt.info()).hasSize(1);
		assertThat(evt.info()).containsKey("cpf");
		assertThat(evt.info().get("cpf")).isEqualTo("123.456.789-12");
	}

	@Test
	@DisplayName("Test if it's returning the right event type")
	void eventTypeTest() {
		assertThat(evt.eventType()).isEqualTo(DomainEventType.STUDENT_INDICATED_TO_CLASS_ROOM_EVENT);
	}

	@Test
	@DisplayName("Test if compile name it's corret")
	public void compileInfoTest() {
		assertThat(evt.compileInfo()).isEqualTo("key: cpf, value: 123.456.789-12");
	}
}
