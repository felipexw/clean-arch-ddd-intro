package com.github.felpexw.academic.application.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;

@DisplayName("[ACADEMIC.application] Student input dto")
class StudentInputDtoTest {

	@Test
	@DisplayName("Parse test")
	void test() {
		final StudentInputDto input = StudentInputDto.builder()//
				.name("Nome")//
				.cpf("111.111.111-11")//
				.build();
		final Student expectedStudent = new Student(new CPF("111.111.111-11"), "Nome");
		final Student actualStudent = input.student();

		Assertions.assertThat(actualStudent).isEqualTo(expectedStudent);
	}

}
