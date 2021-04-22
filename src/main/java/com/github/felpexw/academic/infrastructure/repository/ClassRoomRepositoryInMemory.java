package com.github.felpexw.academic.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Singleton
@Slf4j
public class ClassRoomRepositoryInMemory implements ClassRoomRepository {

	private Map<String, Student> students = new HashMap<>();

	@Override
	public void registerStudent(Student student) {
		log.info("Registering");
		students.put(student.getCpf().getNumber(), student);
	}

}
