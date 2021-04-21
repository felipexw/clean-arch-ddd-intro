package com.github.felpexw;

import java.util.HashMap;
import java.util.Scanner;

import com.github.felpexw.academic.domain.command.IndicateStudentToClassRoomCommand;
import com.github.felpexw.academic.domain.command.RegisterStudentToClassCommand;
import com.github.felpexw.academic.domain.listener.StudentRegisteredToClassRoomEventListener;
import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.academic.infrastructure.repository.ClassRoomRepositoryInMemory;
import com.github.felpexw.academic.infrastructure.repository.StudentIndicationRepositoryInMemory;
import com.github.felpexw.gamification.domain.listener.GamificationStudentIndicatedToClassRoomListener;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.listener.StudentIndicatedToClassRoomListener;

import lombok.Generated;

@Generated
public class MainApplicationCli {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

		final StudentIndicationRepository indicationRepository = new StudentIndicationRepositoryInMemory(
				new HashMap<>());
		final DomainEventPublisher publisher = new DomainEventPublisher();
		publisher.addEventListener(new StudentRegisteredToClassRoomEventListener(indicationRepository, publisher));
		publisher.addEventListener(new StudentIndicatedToClassRoomListener());
		publisher.addEventListener(new GamificationStudentIndicatedToClassRoomListener());

		// student indication
		final Student student = new Student(new CPF("060.116.339-21"), "Juvenal Antena");
		final IndicateStudentToClassRoomCommand indicateStudent = new IndicateStudentToClassRoomCommand(publisher,
				indicationRepository);
		indicateStudent.indicateStudent(student);
		indicateStudent.indicateStudent(new Student(new CPF("111.222.333-21"), null));

		// student registration to class room
		final ClassRoomRepository classRoomRepository = new ClassRoomRepositoryInMemory(new HashMap<>());
		final RegisterStudentToClassCommand registerStudent = new RegisterStudentToClassCommand(publisher,
				classRoomRepository);
		registerStudent.registerStudentToClassRoom(student);

		in.close();
	}

}
