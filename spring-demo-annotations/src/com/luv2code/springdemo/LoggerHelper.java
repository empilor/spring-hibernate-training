package com.luv2code.springdemo;

public class LoggerHelper {

	public static String buildLog(Object obj, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append(obj.getClass().getSimpleName());
		builder.append(": ");
		builder.append(message);
		return builder.toString();
	}
}
