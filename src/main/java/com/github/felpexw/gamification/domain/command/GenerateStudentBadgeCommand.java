package com.github.felpexw.gamification.domain.command;

public class GenerateStudentBadgeCommand {

	public void generate() {
		try {
			Thread.sleep(1250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Badge generated");
	}

}
