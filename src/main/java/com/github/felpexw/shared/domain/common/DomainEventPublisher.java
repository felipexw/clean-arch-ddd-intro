package com.github.felpexw.shared.domain.common;

import java.util.ArrayList;
import java.util.List;

import io.micronaut.core.util.CollectionUtils;

public class DomainEventPublisher {

	private final List<DomainEventListener> events = new ArrayList<>();

	public void addEventListener(DomainEventListener listener) {
		this.events.add(listener);
	}

	public List<DomainEventListener> listeners() {
		return CollectionUtils.unmodifiableList(events);
	}

	public void publish(DomainEvent evt) {
		this.events.stream().forEach(listener -> listener.run(evt));
	}
}
