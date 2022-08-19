package com.iac.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	private static BufferedReader getReader() {
		return new BufferedReader(
			new InputStreamReader(System.in));
	}
	
	public static String getString(String message) {
		String input = null;
		
		try {
			System.out.print("Enter a preferred subject " + message + ": ");
			input = getReader().readLine();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return input;
	}
}
