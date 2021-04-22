package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ProfessorNotifyerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class NotifyProfessorAboutNewStudentToClassRooCommand {

	private ProfessorNotifyerRepository service;

	public void notify(Student student) {
		log.info(String.format("\n professor has been just notified about the new student. CPF: %s",
				student.getCpf().getNumber()));

		service.notifyProfessor(student);
	}
}
