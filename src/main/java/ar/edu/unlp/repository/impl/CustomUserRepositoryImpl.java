package ar.edu.unlp.repository.impl;

import ar.edu.unlp.repository.CustomUserRepository;

public class CustomUserRepositoryImpl implements CustomUserRepository {

	@Override
	public int getNumberOfUsersThatHasTheSamePassword() {
		return 4;
	}

}
