package mochotexto.json;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class JsonParser<T> {
	@NonNull
	private final String filePath;

	@NonNull
	private final Class<T> parsedClass;

	public List<T> readDataset() throws IOException {
		final JsonMapper mapper = new JsonMapper();
		final File input = Paths.get(filePath).toFile();
		List<T> data = new ArrayList<>();

		try (MappingIterator<T> it = mapper.readerFor(parsedClass).readValues(input)) {
			while (it.hasNextValue()) {
				data.add(it.nextValue());
			}
			return data;
		}
	}
}