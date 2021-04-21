package com.github.felpexw.academic.infrastructure.repository;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.shared.BaseTest;

@DisplayName("[ACADEMIC] Student indication repository in memory")
class StudentIndicationRepositoryInMemoryTest extends BaseTest {

	@Mock
	private Map<String, Student> mockIndications;

	@InjectMocks
	private StudentIndicationRepositoryInMemory repository;

	@Test
	@DisplayName("[ACADEMIC] Student has been indicated")
	void indicateTest() {
		final Student student = new Student(new CPF("123.123.123-12"), "Sebastian");

		repository.indicate(student);

		verify(mockIndications, atMostOnce()).put("123.123.123-12", student);
	}

	@Test
	@DisplayName("Student has been indicated")
	void itWasIndicatedTest() {
		when(mockIndications.containsKey("cpf")).thenReturn(true);

		repository.itWasIndicated("cpf");

		verify(mockIndications, atMostOnce()).containsKey("cpf");
	}

}
