package com.github.felpexw.gamification.domain.repository;

public interface StudentBadgeRepository {
	
	void incrementBadgePoints(String cpf, Integer badgePoint);
}
