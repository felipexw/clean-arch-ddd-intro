package com.github.felpexw.shared.domain.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Singleton;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
@Singleton
public class DomainEventPublisher {

	private final Set<DomainEventListener> events = new HashSet<>();

	public void addEventListener(DomainEventListener listener) {
		this.events.add(listener);
	}

	public Set<DomainEventListener> listeners() {
		return Set.copyOf(new ArrayList<>(events));
	}

	public void publish(DomainEvent evt) {
		this.events.stream().forEach(listener -> listener.run(evt));
	}
}
