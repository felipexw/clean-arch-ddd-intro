package com.github.felpexw.academic.domain.model;

import com.github.felpexw.academic.domain.exception.InvalidCpfException;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = "number")
@Getter
public class CPF {

	private final String number;

	public CPF(String number) {
		if (number == null || !number.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new InvalidCpfException("CPF document it's not valid!");
		}
		this.number = number;
	}

}
