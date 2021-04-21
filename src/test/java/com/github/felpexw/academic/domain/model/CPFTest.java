package com.github.felpexw.academic.domain.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.github.felpexw.academic.domain.exception.InvalidCpfException;

@DisplayName("[ACADEMIC] Cadastro de Pessoa Física VO")
class CPFTest {

	@Test
	@DisplayName("It should throw an exception because the CPF it's not valid!")
	@ParameterizedTest
	@ValueSource(strings = { "123456789", "123.123.123-3x",  "123.123.12x-32", "123.123-123.32"})
	void initCpfException() {
		try {
			new CPF(null);
		} catch (InvalidCpfException e) {
			assertThat(e.getMessage()).isEqualTo("CPF document it's not valid!");
		}
	}

	@Test
	@DisplayName("It should NOT throw an exception because the CPF it's valid!")
	void initCpfSuccess() {
		final CPF cpf = new CPF("123.456.789-12");
		assertThat(cpf.getNumber()).isEqualTo("123.456.789-12");
	}

}
