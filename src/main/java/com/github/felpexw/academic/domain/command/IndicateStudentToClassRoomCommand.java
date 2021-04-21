package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IndicateStudentToClassRoomCommand {

	private final DomainEventPublisher publisher;
	private final StudentIndicationRepository repository;;

	public void indicateStudent(Student student) {
		System.out.println(String.format("\n===\n [IndicateStudentToClassRoomCommand]::Indicando aluno..."));

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repository.indicate(student);
		publisher.publish(new StudentIndicatedToClassRoomEvent(student.getCpf().getNumber()));
	}
}
