package com.github.felpexw.gamification.domain.listener;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomByIndicationEvent;
import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomEvent;
import com.github.felpexw.academic.domain.model.CPF;

@DisplayName("[GAMEFICIATION DOMAIN] Student indicated to class room listener")
class GamificationStudentIndicatedToClassRoomListenerTest {
	private GamificationStudentIndicatedToClassRoomListener listener = new GamificationStudentIndicatedToClassRoomListener();

	@Test
	@DisplayName("[DUMMY TEST] react to")
	void reactToTest() {
		listener.reactTo(new StudentRegisteredToClassRoomEvent(new CPF("123.456.789-12")));
	}

	@Test
	@DisplayName("Can run")
	void canRunTestd() {
		assertThat(listener.canRun(new StudentRegisteredToClassRoomByIndicationEvent(null))).isTrue();
		assertThat(listener.canRun(new StudentRegisteredToClassRoomEvent(null))).isFalse();
	}

}
