package com.github.felpexw.academic.domain.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import com.github.felpexw.academic.domain.model.CPF;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ProfessorNotifyerRepository;
import com.github.felpexw.academic.shared.BaseTest;

@DisplayName("[ACADEMIC] Professor notifiyer")
class NotifyProfessorAboutNewStudentToClassRooCommandTest extends BaseTest {

	@Mock
	private ProfessorNotifyerRepository mockService;

	@InjectMocks
	private NotifyProfessorAboutNewStudentToClassRooCommand notifyProfessorCommand;

	@Test
	@DisplayName("When a new student enters the class, the professor should be notified")
	void notifyProfessor() {
		final Student student = new Student(new CPF("060.116.331-12"), "John Doe");
		notifyProfessorCommand.notify(student);

		verify(mockService).notifyProfessor(student);
	}

}
