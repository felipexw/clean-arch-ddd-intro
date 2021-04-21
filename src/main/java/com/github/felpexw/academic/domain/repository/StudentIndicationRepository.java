package com.github.felpexw.academic.domain.repository;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;

public interface StudentIndicationRepository {

	void indicate(Student student);

	Boolean itWasIndicated(String cpf);

}
