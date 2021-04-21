package com.github.felpexw.gamification.infrastructure;

import java.util.Map;

import com.github.felpexw.gamification.domain.repository.StudentBadgeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentBadgeRepositoryInMemory implements StudentBadgeRepository {

	private final Map<String, Integer> studentPoints;

	@Override
	public void incrementBadgePoints(String cpf, Integer badgePoint) {
		Integer points = badgePoint;

		if (studentPoints.containsKey(cpf)) {
			final Integer oldPoints = studentPoints.get(cpf);
			points += oldPoints;
		}

		studentPoints.put(cpf, points);
	}

}
