package com.github.felpexw.academic.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Student {

	private final CPF cpf;
	private final String name;

}
