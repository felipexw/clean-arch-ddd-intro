package com.github.felpexw.academic.domain.command;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Singleton
@Slf4j
public class IndicateStudentToClassRoomCommand {

	@Inject
	private final StudentIndicationRepository repository;;

	public void indicateStudent(Student student) {
		log.info("Indicating student " + student.getCpf().getNumber());

		repository.indicate(student);

		log.info("Student " + student.getCpf().getNumber() + " indicated.");
	}
}
