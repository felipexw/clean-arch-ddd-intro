package com.github.felpexw.shared.domain.common;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

public interface DomainEvent {

	Map<String, String> getInfo();

	default String compileInfo() {
		final Map<String, String> info = getInfo();

		return String.join(": ", info.keySet()//
				.stream()//
				.map(key -> {
					return String.format("key: %s, value: %s", key, info.get(key));
				})//
				.collect(Collectors.toList()));
	}

	DomainEventType eventType();

	default LocalDateTime when() {
		return LocalDateTime.now();
	}
}
