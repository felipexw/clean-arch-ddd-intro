package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.model.Student;

public class NotifyProfessorAboutNewStudentToClassRooCommand {

	public void notify(Student student) {
		System.out.println(String.format("\n professor has been just notified about the new student. CPF: %s",
				student.getCpf().getNumber()));
	}
}
