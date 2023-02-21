package mochotexto.parsing.util;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class DataMergingUtils {
	private DataMergingUtils() {}

	public static String sanitizeCompanyName(String s) {
		if (s == null) {
			return null;
		}

		s = s.toUpperCase();
		if (s.startsWith("THE ")) {
			s = s.substring(4);
		}
		while (s.contains("(") && s.contains(")")) {
			int start = s.indexOf("(");
			int end = s.indexOf(")");
			String toBeRemoved = s.substring(start, end + 1);
			s = s.replace(toBeRemoved, "");
		}
		return s.replace("INCORPORATED", "")
				.replace("INTERNATIONAL", "")
				.replace("LABORATORIES", "")
				.replace("LABORATORY", "")
				.replace("SERVICES", "")
				.replace("INC", "")
				.replace("LTD", "")
				.replace("GROUP", "")
				.replace("PLC", "")
				.replace("CORPORATION", "")
				.replace("LIMITED", "")
				.replace("HOLDINGS", "")
				.replace("HOLDING", "")
				.replace("COMPANY", "")
				.replace("TECHNOLOGIES", "")
				.replace("TECHNOLOGY", "")
				.replace("CORP", "")
				.replace("CO", "")
				.replace(" AND ", " ")
				.replace("&", " ")
				.replace(".", "")
				.replace(",", "")
				.replace("  ", " ")
				.replace("\t", "")
				.replace("\n", "")
				.replace("\r", "")
				.trim();
	}

	public static <T> T mergeSingleValue(List<T> values) {
		if (values == null) {
			return null;
		}

		Set<T> uniqueValues = values.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());

		if (uniqueValues.size() != 1) {
			return null;
		}
		return uniqueValues.stream().findFirst().orElse(null);
	}

	public static List<String> listsInnerJoin(List<List<String>> lists) {
		lists = lists.stream().filter(Predicate.not(List::isEmpty)).collect(Collectors.toList());
		if (lists.isEmpty()) {
			return Collections.emptyList();
		}

		// TODO: trasformare stringhe in formato standard, associarle alle stringhe vere in mappa, fare il retain e in base a quello che rimane, sostituire con stringa originale in mappa, ordinata per lunghezza
		List<String> result = new ArrayList<>(lists.get(0));
		for (List<String> l : lists) {
			if (l == null) {
				continue;
			}
			l = l.stream().filter(Objects::nonNull).collect(Collectors.toList());
			result.retainAll(l);
		}
		return result;
	}
}
