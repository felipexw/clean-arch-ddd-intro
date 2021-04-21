package com.github.felpexw.academic.infrastructure.repository;

import java.util.Map;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClassRoomRepositoryInMemory implements ClassRoomRepository {

	private final Map<String, Student> students;

	@Override
	public void registerStudent(Student student) {
		students.put(student.getCpf().getNumber(), student);
	}

}
