package mochotexto.dataset.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public final class ParsingUtils {
	private ParsingUtils() {
	}

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
}
