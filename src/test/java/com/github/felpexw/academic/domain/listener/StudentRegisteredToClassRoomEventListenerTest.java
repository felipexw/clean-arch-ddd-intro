package com.github.felpexw.academic.domain.listener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomEvent;
import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

@DisplayName("[ACADEMIC] Student registered to a class room event listener")
class StudentRegisteredToClassRoomEventListenerTest extends BaseTest {

	@Mock
	private StudentIndicationRepository mockRepository;

	@Mock
	private DomainEventPublisher mockPublisher;

	@InjectMocks
	StudentRegisteredToClassRoomEventListener eventListener;

	@Test
	@DisplayName("React to")
	void reactToTest() {
		try (MockedConstruction<StudentRegisteredToClassRoomByIndicationEvent> mockConstruction = Mockito
				.mockConstruction(StudentRegisteredToClassRoomByIndicationEvent.class)) {
			final CPF cpf = new CPF("123.456.789-12");
			final StudentRegisteredToClassRoomEvent evt = new StudentRegisteredToClassRoomEvent(cpf);

			when(mockRepository.itWasIndicated(cpf.getNumber())).thenReturn(true);

			final StudentRegisteredToClassRoomByIndicationEvent studentRegisteredToClassRoomByIndicationEvt = new StudentRegisteredToClassRoomByIndicationEvent(
					"123.123.123-12");

			eventListener.reactTo(evt);

			verify(mockRepository, atMostOnce()).itWasIndicated(cpf.getNumber());
			verify(mockPublisher, atMostOnce()).publish(studentRegisteredToClassRoomByIndicationEvt);

		}

	}

	@Test
	@DisplayName("Can run")
	void canRun() {
		assertThat(eventListener.canRun(new StudentRegisteredToClassRoomEvent(null))).isTrue();
		assertThat(eventListener.canRun(new StudentIndicatedToClassRoomEvent(null))).isFalse();
	}

}
