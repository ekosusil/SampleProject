package com.eko.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class OutputUtil {
	public static <T> void writeToFile(String useCase, T t) {
		String path = System.getProperty(useCase + ".outputFilePath");
		Optional.ofNullable(path).map(Paths::get).ifPresent(curPath -> {
			try {
				BufferedWriter writer = Files.newBufferedWriter(curPath, StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
				writer.write(t.toString());
				writer.flush();
				writer.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public static <T> void sendToMail(String useCase, T t) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	public static <T> void enqueueToKafka(T t) {
		throw new UnsupportedOperationException("Not implemented yet");

	}

	public static <T> void writeToConsole(String useCase, T t) {
		System.out.println(useCase + t);
	}
}
