package com.github.felpexw.academic.application.controller;

import javax.inject.Inject;

import com.github.felpexw.academic.application.dto.StudentInputDto;
import com.github.felpexw.academic.domain.command.IndicateStudentToClassRoomCommand;
import com.github.felpexw.academic.domain.command.RegisterStudentToClassCommand;
import com.github.felpexw.academic.domain.listener.StudentRegisteredToClassRoomEventListener;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.gamification.domain.listener.GamificationStudentIndicatedToClassRoomListener;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.listener.StudentIndicatedToClassRoomListener;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller("/students")
	public class StudentController {

	@Inject
	private StudentIndicationRepository studentIndicationRepository;

	@Inject
	private IndicateStudentToClassRoomCommand indicateSudentPort;

	@Inject
	private DomainEventPublisher publisher;

	@Inject
	private RegisterStudentToClassCommand registerStudentPort;

	@Post(uri = "/indications", consumes = MediaType.APPLICATION_JSON, processes = MediaType.TEXT_PLAIN)
	public HttpResponse<String> indicateStudent(@Body StudentInputDto studentInputDto) {
		initListeners();
		indicateSudentPort.indicateStudent(studentInputDto.student());
		return HttpResponse.ok("Student indicated Sucessfully");
	}

	private void initListeners() {
		publisher.addEventListener(
				new StudentRegisteredToClassRoomEventListener(studentIndicationRepository, publisher));
		publisher.addEventListener(new StudentIndicatedToClassRoomListener());
		publisher.addEventListener(new GamificationStudentIndicatedToClassRoomListener());
	}

	@Post(uri = "/registrations", consumes = MediaType.APPLICATION_JSON, processes = MediaType.TEXT_PLAIN)
	public HttpResponse<String> registerStudent(@Body StudentInputDto studentInputDto) {
		initListeners();
		registerStudentPort.registerStudentToClassRoom(studentInputDto.student());

		return HttpResponse.ok("Student registered sucessfully");
	}
}
