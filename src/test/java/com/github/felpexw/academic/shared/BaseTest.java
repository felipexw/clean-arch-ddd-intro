package com.github.felpexw.academic.shared;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {

	@BeforeEach
	final void init() {
		MockitoAnnotations.openMocks(this);
	}

}
