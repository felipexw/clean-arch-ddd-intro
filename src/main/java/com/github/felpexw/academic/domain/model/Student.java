package com.github.felpexw.academic.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(of = "cpf")
@Generated
@Builder
public class Student {

	private final CPF cpf;
	private final String name;

}
