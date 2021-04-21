package com.github.felpexw.academic.infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;

public class ClassRoomRepositoryInMemory implements ClassRoomRepository {

	final Map<String, Student> students = new HashMap<>();

	@Override
	public void registerStudent(Student student) {
		students.put(student.getCpf().getNumber(), student);
	}

}
