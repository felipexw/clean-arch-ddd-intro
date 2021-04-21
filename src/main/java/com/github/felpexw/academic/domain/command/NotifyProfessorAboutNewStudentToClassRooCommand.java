package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ProfessorNotifyerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotifyProfessorAboutNewStudentToClassRooCommand {

	private ProfessorNotifyerRepository service;

	public void notify(Student student) {
		System.out.println(String.format("\n professor has been just notified about the new student. CPF: %s",
				student.getCpf().getNumber()));

		service.notifyProfessor(student);
	}
}
