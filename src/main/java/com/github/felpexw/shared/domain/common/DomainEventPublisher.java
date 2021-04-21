package com.github.felpexw.shared.domain.common;

import java.util.HashSet;
import java.util.Set;

public class DomainEventPublisher {

	private final Set<DomainEventListener> events = new HashSet<>();

	public void addEventListener(DomainEventListener listener) {
		this.events.add(listener);
	}

	public void publish(DomainEvent evt) {
		this.events.stream().forEach(listener -> listener.run(evt));
	}
}
