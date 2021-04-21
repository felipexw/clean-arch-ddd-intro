package com.github.felpexw.shared.domain.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public interface DomainEvent {

	Map<String, String> info();

	default String compileInfo() {
		final Map<String, String> info = info();

		return String.join(": ", info.keySet()//
				.stream()//
				.map(key -> {
					return String.format("key: %s, value: %s", key, info.get(key));
				})//
				.collect(Collectors.toList()));
	}

	DomainEventType eventType();

	default String when() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
	}
}
