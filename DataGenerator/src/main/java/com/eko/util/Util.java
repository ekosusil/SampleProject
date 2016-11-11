package com.eko.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.lang.math.NumberUtils;

public class Util {

	private static Date performParseDate(String date, String pattern, String zone) {
		return Date.from(ZonedDateTime.parse(date, DateTimeFormatter.ofPattern(pattern))
				.withZoneSameInstant(ZoneId.of(zone)).toInstant());
	}

	public static Date parseDateFromString(String date, String pattern, String zone) {
		return Optional.ofNullable(date)
				.map(strDate -> performParseDate(strDate,pattern,zone))
				.orElse(new Date());
		
	}

	public static Date parseDateFromString(String date) {
		return parseDateFromString(date, "dd.MM.yyyy HH:mm:ss", "GMT");
	}

	public static <T extends Number> T parseStringAsNumber(String str, Function<String, T> parsingFunction,
			T defaultVal) {
		return Optional.ofNullable(str).filter(NumberUtils::isNumber).map(parsingFunction).orElse(defaultVal);
	}

	public static <T extends Number> T parseStringAsNumber(String str, Function<String, T> parsingFunction,
			Supplier<T> supplier) {
		return Optional.ofNullable(str).filter(NumberUtils::isNumber).map(parsingFunction).orElseGet(supplier);
	}

}
