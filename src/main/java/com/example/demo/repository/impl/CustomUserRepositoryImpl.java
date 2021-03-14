package com.example.demo.repository.impl;

import com.example.demo.repository.CustomUserRepository;

public class CustomUserRepositoryImpl implements CustomUserRepository {

	@Override
	public int getNumberOfUsersThatHasTheSamePassword() {

		return 4;
	}

}
