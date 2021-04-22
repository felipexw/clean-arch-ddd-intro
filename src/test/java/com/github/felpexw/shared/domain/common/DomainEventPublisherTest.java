package com.github.felpexw.shared.domain.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.academic.shared.BaseTest;

@DisplayName("[ACADEMIC] Publish events and add event listeners handler")
class DomainEventPublisherTest extends BaseTest {

	private final DomainEventPublisher publisher = new DomainEventPublisher();

	@Test
	@DisplayName("Add event listener to the publisher")
	void addEventListenerTest() {
		final DomainEventListener evt = mock(DomainEventListener.class);
		publisher.addEventListener(evt);

		assertThat(publisher.listeners()).hasSize(1);
	}

}
