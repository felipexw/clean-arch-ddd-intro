package com.github.felpexw.gamification.domain.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateStudentBadgeCommand {

	public void generate() {
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		log.info("Badge generated");
	}

}
