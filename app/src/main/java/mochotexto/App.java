package mochotexto;

import lombok.extern.slf4j.Slf4j;
import mochotexto.dataset.schemamapper.AvengersValuetodaySchema;
import mochotexto.json.JsonParser;
import mochotexto.dataset.CompanyMediatedSchema;
import mochotexto.dataset.DatasetMapper;
import mochotexto.dataset.DatasetMetadata;

import java.io.IOException;
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
					JsonParser<? extends DatasetMapper> parser = new JsonParser<>("./dataset/" + d.getFilePath(), d.getMapper());
					try {
						List<CompanyMediatedSchema> companyMediatedSchemaList = parser.readDataset().stream()
								.map(CompanyMediatedSchema::of)
								.collect(Collectors.toList());
						log.info("{}", companyMediatedSchemaList.subList(0, 50));
						log.info("{}", companyMediatedSchemaList.size());
						mediatedSchemaRecords.addAll(companyMediatedSchemaList);
					} catch (IOException e) {
						log.error("", e);
					}
					log.info("Total: {}", mediatedSchemaRecords.size());
				}
		);
	}
}
