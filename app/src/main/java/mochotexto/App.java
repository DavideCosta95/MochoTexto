package mochotexto;

import lombok.extern.slf4j.Slf4j;
import mochotexto.parsing.exception.ParsingException;
import mochotexto.parsing.model.DatasetParser;
import mochotexto.dataset.schema.CompanyMediatedSchema;
import mochotexto.dataset.mapper.DatasetMapper;
import mochotexto.dataset.mapper.DatasetMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class App {
	public static void main(String[] args) {
		List<DatasetMetadata> datasets = Arrays.asList(DatasetMetadata.values());
		// TODO: improve initial capacity
		List<CompanyMediatedSchema> mediatedSchemaRecords = new ArrayList<>();
		datasets.forEach(
				d -> {
					// TODO: improve
					DatasetParser<? extends DatasetMapper> parser = new DatasetParser<>("./dataset/" + d.getFilePath(), d.getMapper());
					try {
						List<CompanyMediatedSchema> companyMediatedSchemaList = parser.readDataset().stream()
								.map(CompanyMediatedSchema::of)
								.collect(Collectors.toList());
						log.info("{}", companyMediatedSchemaList.subList(0, 10));
						log.info("{}", companyMediatedSchemaList.size());
						mediatedSchemaRecords.addAll(companyMediatedSchemaList);
					} catch (ParsingException e) {
						log.error("", e);
					}
					log.info("Total: {}", mediatedSchemaRecords.size());
				}
		);
	}
}
