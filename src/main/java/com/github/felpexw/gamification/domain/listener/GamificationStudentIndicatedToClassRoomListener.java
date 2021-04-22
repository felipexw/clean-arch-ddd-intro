package com.github.felpexw.gamification.domain.listener;

import com.github.felpexw.shared.domain.common.DomainEvent;
import com.github.felpexw.shared.domain.common.DomainEventListener;
import com.github.felpexw.shared.domain.common.DomainEventType;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode(of = "identification", callSuper = false)
public class GamificationStudentIndicatedToClassRoomListener extends DomainEventListener {
	
	private String identification;
	
	public GamificationStudentIndicatedToClassRoomListener() {
		this.identification = this.identification();
	}
	
	@Override
	public void reactTo(DomainEvent evt) {
		log.info(String.format(
				"\n===\n [GamificationStudentIndicatedToClassRoomListener-%s]:: Atualizando os game points na base... CPF: %s",
				evt.when(), evt.info().get("cpf")));
	}

	@Override
	public Boolean canRun(DomainEvent evt) {
		return evt.eventType() == DomainEventType.STUDENT_REGISTERED_TO_CLASS_ROOM_BY_INDICATION_EVENT;
	}

	@Override
	public String identification() {
		return this.getClass().getName();
	}



}
