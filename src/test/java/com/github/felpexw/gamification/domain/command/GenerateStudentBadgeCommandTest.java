package com.github.felpexw.gamification.domain.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[GAMIFICATION] Generate student badge command")
class GenerateStudentBadgeCommandTest {

	@Test
	@DisplayName("[DUMMY TEST] generate")
	void generateDummyTest() {
		new GenerateStudentBadgeCommand().generate();
	}

}
