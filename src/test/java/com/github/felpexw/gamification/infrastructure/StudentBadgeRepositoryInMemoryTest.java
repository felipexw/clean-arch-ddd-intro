package com.github.felpexw.gamification.infrastructure;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.github.felpexw.academic.shared.BaseTest;

@DisplayName("[GAMEFICIATION] Student badge repository in memory")
class StudentBadgeRepositoryInMemoryTest extends BaseTest {

	@Mock
	private Map<String, Integer> mockStudentPoints;

	@InjectMocks
	private StudentBadgeRepositoryInMemory repository;

	@Test
	@DisplayName("[GAMEFICIATION] Increment badge points")
	void incrementBadgePointsTest() {
		when(mockStudentPoints.containsKey("key"))//
		.thenReturn(true)//
		.thenReturn(false);
		
		when(mockStudentPoints.get("key")).thenReturn(10);

		repository.incrementBadgePoints("key", 10);
		repository.incrementBadgePoints("key", 15);

		verify(mockStudentPoints, times(1)).put("key", 20);
		verify(mockStudentPoints, times(1)).put("key", 15);
	}

}
