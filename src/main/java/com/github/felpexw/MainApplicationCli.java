package com.github.felpexw;

import java.util.Scanner;

import com.github.felpexw.academic.domain.command.IndicateStudentToClassRoomCommand;
import com.github.felpexw.academic.domain.command.RegisterStudentToClassCommand;
import com.github.felpexw.academic.domain.listener.StudentRegisteredToClassRoomEventListener;
import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;
import com.github.felpexw.academic.infrastructure.ClassRoomRepositoryInMemory;
import com.github.felpexw.gamification.domain.listener.GamificationStudentIndicatedToClassRoomListener;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.listener.StudentIndicatedToClassRoomListener;

public class MainApplicationCli {

	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);

		final DomainEventPublisher publisher = new DomainEventPublisher();
		publisher.addEventListener(new StudentRegisteredToClassRoomEventListener());
		publisher.addEventListener(new StudentIndicatedToClassRoomListener());
		publisher.addEventListener(new GamificationStudentIndicatedToClassRoomListener());

		final ClassRoomRepository classRoomRepository = new ClassRoomRepositoryInMemory();
		final RegisterStudentToClassCommand registerStudent = new RegisterStudentToClassCommand(publisher,
				classRoomRepository);
		registerStudent.registerStudentToClassRoom(new Student(new CPF("060.116.339-77"), "Juvenal Antena"));

		final IndicateStudentToClassRoomCommand indicateStudent = new IndicateStudentToClassRoomCommand(publisher,
				new CPF("060.116.339-77"));
		indicateStudent.indicateStudent();

		in.close();
	}

}
