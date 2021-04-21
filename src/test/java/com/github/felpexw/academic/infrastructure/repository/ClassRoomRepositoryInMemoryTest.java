package com.github.felpexw.academic.infrastructure.repository;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.shared.BaseTest;

@DisplayName("[ACADEMIC] Class room repository")
class ClassRoomRepositoryInMemoryTest extends BaseTest {

	@Mock
	private Map<String, Student> mockStudents;

	@InjectMocks
	private ClassRoomRepositoryInMemory repository;

	@Test
	@DisplayName("Register student to repo")
	void registerStudentTest() {
		final Student student = new Student(new CPF("123.123.123-12"), null);

		repository.registerStudent(student);

		verify(mockStudents, atMostOnce()).put(student.getCpf().getNumber(), student);
	}

}
