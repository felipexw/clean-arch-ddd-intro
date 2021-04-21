package com.github.felpexw.academic.domain.command;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockitoAnnotations;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.StudentIndicationRepository;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

@DisplayName("[ACADEMIC] Student indication to class room")
class IndicateStudentToClassRoomCommandTest {

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Mock
	private DomainEventPublisher mockPublisher;

	@Mock
	private StudentIndicationRepository mockRepository;

	@InjectMocks
	private IndicateStudentToClassRoomCommand indicateStudentToClassRoomCommand;

	@Test
	@DisplayName("When a new student has been indicated to a class, it should triggers an event to another subscriber, and should store this information in the repository")
	void indicateSuccessTest() {
		// setup

		try (MockedConstruction<StudentIndicatedToClassRoomEvent> mockConstruction2 = mockConstruction(
				StudentIndicatedToClassRoomEvent.class)) {

			final Student student = new Student(new CPF("060.116.331-21"), "Juvenal");

			final StudentIndicatedToClassRoomEvent studentIndicatedToClassRoomEvt = new StudentIndicatedToClassRoomEvent(
					student.getCpf().getNumber());

			// action
			indicateStudentToClassRoomCommand.indicateStudent(student);

			// verify
			verify(mockRepository, atMostOnce()).indicate(student);
			verify(mockPublisher, atMostOnce()).publish(studentIndicatedToClassRoomEvt);
		}
	}

}
