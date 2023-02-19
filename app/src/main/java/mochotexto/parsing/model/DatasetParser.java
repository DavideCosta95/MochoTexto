package mochotexto.parsing.model;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import mochotexto.dataset.mapper.CsvDatasetMapper;
import mochotexto.dataset.mapper.JsonDatasetMapper;
import mochotexto.parsing.exception.ParsingException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public class DatasetParser<T> {
	@NonNull
	private final String filePath;

	@NonNull
	private final Class<T> parsedClass;

	public List<T> readDataset() throws ParsingException {
		if (CsvDatasetMapper.class.isAssignableFrom(parsedClass)) {
			try {
				return readCsv();
			} catch (IOException e) {
				throw new ParsingException(e);
			}
		}
		if (JsonDatasetMapper.class.isAssignableFrom(parsedClass)) {
			try {
				return readJson();
			} catch (IOException e) {
				throw new ParsingException(e);
			}
		}
		throw new ParsingException("No mapper found for " + parsedClass.getSimpleName() + " class");
	}

	private List<T> readJson() throws IOException {
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

	private List<T> readCsv() throws IOException {
		File input = Paths.get(filePath).toFile();

		CsvMapper csvMapper = new CsvMapper();

		CsvSchema csvSchema = csvMapper
				.typedSchemaFor(parsedClass)
				.withHeader()
				.withColumnSeparator(',')
				.withComments();

		try (MappingIterator<T> it = csvMapper
				.readerWithTypedSchemaFor(parsedClass)
				.with(csvSchema)
				.readValues(input)) {
			return it.readAll();
		}
	}
}