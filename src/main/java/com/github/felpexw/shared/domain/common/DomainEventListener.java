package com.github.felpexw.shared.domain.common;

public abstract class DomainEventListener {

	public abstract void reactTo(DomainEvent evt);

	public abstract Boolean canRun(DomainEvent evt);

	public void run(DomainEvent evt) {
		if (canRun(evt))
			reactTo(evt);
	}
}
