package com.github.felpexw.email.comand;

public class SendEmailToStudentIndicated {

	public void sendEmail(String cpf) {
		System.out.println("Enviando email para o aluno indicado realizar a matrícula");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Email enviado com sucesso!");
	}

}
