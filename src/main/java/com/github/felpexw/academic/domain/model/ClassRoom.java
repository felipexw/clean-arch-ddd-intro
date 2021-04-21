package com.github.felpexw.academic.domain.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.github.felpexw.academic.domain.exception.StudentException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * One class can have at most 30 students.
 * 
 * @author Felipe
 *
 */
@RequiredArgsConstructor
@Getter
public class ClassRoom {
	private LocalDateTime startsAt;
	private LocalDateTime finishesAt;
	private Set<Student> students;

	public void addStudent(Student student) {
		if (!canAddStudent()) {
			throw new StudentException("One class room can't have more than 30 students.");
		}
		this.students.add(student);
	}

	private Boolean canAddStudent() {
		return students.size() < 30;
	}
}
