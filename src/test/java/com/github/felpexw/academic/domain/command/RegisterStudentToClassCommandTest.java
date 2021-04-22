package com.github.felpexw.academic.domain.command;

import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomEvent;
import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;
import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;

@DisplayName("[ACADEMIC] Register student to class room use case")
class RegisterStudentToClassCommandTest extends BaseTest {

	@Mock
	private ClassRoomRepository mockRepository;

	@Mock
	private DomainEventPublisher mockPublisher;

	@InjectMocks
	private RegisterStudentToClassCommand registerStudent;

	@Test
	@DisplayName("Register student to the class room")
	void registerStudentTest() {
		try (MockedConstruction<StudentRegisteredToClassRoomEvent> mockConstruction2 = mockConstruction(
				StudentRegisteredToClassRoomEvent.class)) {
			final Student student = new Student(new CPF("123.456.789-12"), "Student stub");
			final StudentRegisteredToClassRoomEvent mockEvt = new StudentRegisteredToClassRoomEvent(student.getCpf());

			registerStudent.registerStudentToClassRoom(student);

			verify(mockRepository, atMostOnce()).registerStudent(student);
			verify(mockPublisher, atMostOnce()).publish(mockEvt);
		}

	}

}
