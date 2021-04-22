package com.github.felpexw.email.listener;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.email.domain.listener.SendEmailToStudentListener;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

@DisplayName("[EMAIL] Send email to someone event listener")
class SendEmailToStudentListenerTest extends BaseTest {

	private SendEmailToStudentListener evtListener = new SendEmailToStudentListener();

	@Test
	@DisplayName("Can run")
	void canRunTest() {
		assertThat(evtListener.canRun(new StudentIndicatedToClassRoomEvent(null))).isTrue();
		assertThat(evtListener.canRun(new StudentRegisteredToClassRoomByIndicationEvent(null))).isFalse();
	}

	@Test
	@DisplayName("[DUMMY TEST] Can run")
	void reactToTest() {
		evtListener.reactTo(new StudentIndicatedToClassRoomEvent(null));
	}

}
