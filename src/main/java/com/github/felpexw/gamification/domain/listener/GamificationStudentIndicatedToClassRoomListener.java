package com.github.felpexw.gamification.domain.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

public class GamificationStudentIndicatedToClassRoomListener extends DomainEventListener {

	@Override
	public void reactTo(DomainEvent evt) {
		System.out.println(String.format(
				"\n===\n [GamificationStudentIndicatedToClassRoomListener-%s]:: Atualizando os game points na base... CPF: %s",
				evt.when(), evt.info().get("cpf")));
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM_BY_INDICATION_EVENT;
	}

}
