package mochotexto.parsing.util;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public final class ParsingUtils {
	private ParsingUtils() {
	}

	// TODO: call methods below
	public static Integer sanitizeInteger(String s) {
		if (s == null) {
			return null;
		}
		try {
			String ss = s
					.replace(",", "")
					.replace(".", "")
					.replace(" ", "")
					.replace("EUR", "")
					.replace("USD", "")
					.replace("$", "")
					.replace("€", "");
			return Integer.parseInt(ss);
		} catch (Exception e) {
			log.warn("Error while parsing {} as integer", s);
			return null;
		}
	}

	public static String joinStringList(List<String> list, String delimiter) {
		if (list == null) {
			return null;
		}
		return list.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.joining(delimiter));
	}

	public static Double sanitizeCurrencyDouble(String s) {
		if (s == null) {
			return null;
		}
		s = s.toUpperCase(Locale.ROOT)
				.replace("$", "")
				.replace("€", "")
				.replace("USD", "")
				.replace("US", "")
				.replace(" ", "")
				.replace(",", "");
		int exponent = 0;
		if (s.contains("T")) {
			exponent = 12;
			s = s.substring(0, s.indexOf("T"));
		}
		if (s.contains("B")) {
			exponent = 9;
			s = s.substring(0, s.indexOf("B"));
		}
		if (s.contains("M")) {
			exponent = 6;
			s = s.substring(0, s.indexOf("M"));
		}
		if (s.contains("K")) {
			exponent = 3;
			s = s.substring(0, s.indexOf("K"));
		}
		try {
			double value = Double.parseDouble(s);
			return value * Math.pow(10, exponent);
		} catch (Exception e) {
			return null;
		}
	}

	public static Float sanitizeCurrencyFloat(String s) {
		if (s == null) {
			return null;
		}
		Double value = sanitizeCurrencyDouble(s);
		if (value == null) {
			return null;
		}
		return value.floatValue();
	}

	public static Long sanitizeCurrencyLong(String s) {
		if (s == null) {
			return null;
		}
		Double value = sanitizeCurrencyDouble(s);
		if (value == null) {
			return null;
		}
		return value.longValue();
	}

	public static List<String> parseStringList(Object obj) {
		if (obj instanceof List<?>) {
			return ((List<?>) obj).stream()
					.filter(Objects::nonNull)
					.map(Object::toString)
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
		}
		if (obj == null || obj.toString() == null) {
			return Collections.emptyList();
		}
		return List.of(obj.toString());
	}

	public static List<String> makeSanitizedStringList(String... strings) {
		if (strings == null) {
			return Collections.emptyList();
		}
		return Arrays.stream(strings)
				.filter(Objects::nonNull)
				.filter(Predicate.not(String::isBlank))
				.collect(Collectors.toList());
	}
}
