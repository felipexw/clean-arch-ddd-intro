package com.github.felpexw.shared.domain.listener;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.shared.BaseTest;
import com.github.felpexw.shared.domain.event.StudentIndicatedToClassRoomEvent;

@DisplayName("[SHARED] Student has been indicated to a class room listener")
class StudentIndicatedToClassRoomListenerTest extends BaseTest {

	@InjectMocks
	private StudentIndicatedToClassRoomListener listener;

	@Test
	@DisplayName("When a new student has been registered, it sould only listen to this event.")
	void canRunTest() {
		assertTrue(listener.canRun(new StudentIndicatedToClassRoomEvent("123.456.789-12")), () -> "assert true ok");
		assertFalse(listener.canRun(new StudentRegisteredToClassRoomByIndicationEvent("123.456.789-12")),
				() -> "assert false ok");
	}

	@Test
	@DisplayName("Dummy test")
	public void dummyTest() {
		listener.reactTo(new StudentIndicatedToClassRoomEvent("123.123.123-12"));
	}

}
