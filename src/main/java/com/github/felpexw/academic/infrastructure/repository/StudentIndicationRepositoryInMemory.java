package com.github.felpexw.academic.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;

public class StudentIndicationRepositoryInMemory implements StudentIndicationRepository {

	private final Map<String, Student> indications = new HashMap<>();

	@Override
	public void indicate(Student student) {
		indications.put(student.getCpf().getNumber(), student);
	}

	@Override
	public Boolean itWasIndicated(String cpf) {
		return indications.containsKey(cpf);
	}

}
