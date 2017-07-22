package com.hanbit.springstagram.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class IdGenerationService {
	
	private static final String CHARS
		= "0123456789"
		+ "abcdefghijklmnopqrstuvwxyz"
		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private Random random = new Random();

	public String generateId(int length) {
		char[] chars = new char[length];
		
		for (int i=0; i<length; i++) {
			chars[i] = CHARS.charAt(random.nextInt(CHARS.length()));
		}
		
		return new String(chars);
	}
	
}
