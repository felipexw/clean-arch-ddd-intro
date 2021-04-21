package com.github.felpexw.shared.domain.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;
import com.github.felpexw.shared.domain.listener.StudentIndicatedToClassRoomListener;

@DisplayName("[ACADEMIC] Publish events and add event listeners handler")
class DomainEventPublisherTest extends BaseTest {

	private final DomainEventPublisher publisher = new DomainEventPublisher();

	@Test
	@DisplayName("Add event listener to the publisher")
	void addEventListenerTest() {
		final DomainEventListener evt = mock(DomainEventListener.class);
		publisher.addEventListener(evt);

		assertThat(publisher.listeners()).hasSize(1);
		assertThat(publisher.listeners().get(0)).isEqualTo(evt);
	}

	@Test
	@DisplayName("Publis event to listeners")
	void publishTest() {
		final DomainEvent evt = spy(new StudentIndicatedToClassRoomEvent("123.456.789-12"));

		final StudentIndicatedToClassRoomListener evtListener = spy(StudentIndicatedToClassRoomListener.class);
		publisher.addEventListener(evtListener);
		publisher.publish(evt);

		verify(evtListener).run(evt);
	}

}
