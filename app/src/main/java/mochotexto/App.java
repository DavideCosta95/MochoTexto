package mochotexto;

import lombok.extern.slf4j.Slf4j;
import mochotexto.parsing.exception.ParsingException;
import mochotexto.parsing.model.DatasetParser;
import mochotexto.dataset.schema.CompanyMediatedSchema;
import mochotexto.dataset.mapper.DatasetMapper;
import mochotexto.dataset.mapper.DatasetMetadata;
import mochotexto.parsing.util.DataMergingUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class App {
	public static void main(String[] args) {
		List<CompanyMediatedSchema> mediatedSchemaRecords = new ArrayList<>(120000);

		for (DatasetMetadata d : DatasetMetadata.values()) {
			DatasetParser<? extends DatasetMapper> parser = new DatasetParser<>("./dataset/" + d.getFilePath(), d.getMapper());

			try {
				List<CompanyMediatedSchema> companyMediatedSchemaList = parser.readDataset().stream()
						.map(CompanyMediatedSchema::of)
						.collect(Collectors.toList());
				log.debug("Read dataset size: {}", companyMediatedSchemaList.size());
				mediatedSchemaRecords.addAll(companyMediatedSchemaList);
			} catch (ParsingException e) {
				log.error("", e);
			}
		}
		log.info("Total parsed entries: {}", mediatedSchemaRecords.size());

		// TODO: map.compute()
		Map<String, List<CompanyMediatedSchema>> companiesByName = mediatedSchemaRecords.stream()
				.filter(Objects::nonNull)
				.filter(e -> e.getName() != null)
				.collect(Collectors.toMap(k -> DataMergingUtils.sanitizeCompanyName(k.getName()), v -> {
							List<CompanyMediatedSchema> list = new ArrayList<>();
							list.add(v);
							return list;
						},
						(existing, incoming) -> {
							existing.addAll(incoming);
							return existing;
						}));
		log.info("Companies grouped by name: {}", companiesByName.size());

		List<CompanyMediatedSchema> mergedList = mergeDatasetEntries(companiesByName);
		makeAnalytics(companiesByName, mergedList);
	}

	private static List<CompanyMediatedSchema> mergeDatasetEntries(Map<String, List<CompanyMediatedSchema>> companiesByName) {
		List<CompanyMediatedSchema> mergedList = new ArrayList<>(companiesByName.keySet().size());
		for (List<CompanyMediatedSchema> list : companiesByName.values()) {

			String name = "";
			for (CompanyMediatedSchema company : list) {
				if (company.getName().length() > name.length()) {
					name = company.getName();
				}
			}

			// TODO: check substrings
			String stocksName = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getStocksName)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String country = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getCountry)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			Float sharePriceUSD = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getSharePriceUSD)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String foundedOn = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getFoundedOn)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			Integer employeesCount = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getEmployeesCount)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String ceo = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getCeo)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String headquartersLocation = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getHeadquartersLocation)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String topCompetitor = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getTopCompetitor)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			String telephoneNumber = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getTelephoneNumber)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			Long marketCapitalization2022USD = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getMarketCapitalization2022USD)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);
			Long revenue2022USD = DataMergingUtils.mergeSingleValue(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getRevenue2022USD)
							.filter(Objects::nonNull)
							.collect(Collectors.toList())
			);


			// lists

			// TODO: improve grouping logic
			List<String> sectors = list.stream()
					.filter(Objects::nonNull)
					.map(CompanyMediatedSchema::getSectors)
					.flatMap(Collection::stream)
					.distinct()
					.collect(Collectors.toList());

			List<String> founders = DataMergingUtils.listsInnerJoin(
					list.stream()
							.filter(Objects::nonNull)
							.map(CompanyMediatedSchema::getFounders)
							.collect(Collectors.toList())
			);

			List<String> urls = list.stream()
					.filter(Objects::nonNull)
					.map(CompanyMediatedSchema::getUrls)
					.flatMap(Collection::stream)
					.distinct()
					.collect(Collectors.toList());

			Map<String, Integer> followersBySocial = new HashMap<>();
			for (CompanyMediatedSchema company : list) {
				for (Map.Entry<String, Integer> entry : company.getFollowersBySocial().entrySet()) {
					if (!followersBySocial.containsKey(entry.getKey())) {
						followersBySocial.put(entry.getKey(), entry.getValue());
					}
				}
			}

			mergedList.add(CompanyMediatedSchema.builder()
					.name(name)
					.stocksName(stocksName)
					.sectors(sectors)
					.country(country)
					.sharePriceUSD(sharePriceUSD)
					.foundedOn(foundedOn)
					.founders(founders)
					.employeesCount(employeesCount)
					.ceo(ceo)
					.headquartersLocation(headquartersLocation)
					.topCompetitor(topCompetitor)
					.telephoneNumber(telephoneNumber)
					.followersBySocial(followersBySocial)
					.urls(urls)
					.marketCapitalization2022USD(marketCapitalization2022USD)
					.revenue2022USD(revenue2022USD)
					.build());
		}
		return mergedList;
	}

	private static void makeAnalytics(Map<String, List<CompanyMediatedSchema>> companiesByName, List<CompanyMediatedSchema> mergedList) {
		List<CompanyMediatedSchema> singleGroupedCompaniesNames = companiesByName.values().stream()
				.filter(e -> e.size() == 1)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		log.info("Companies without name collisions: {}", singleGroupedCompaniesNames.size());

		log.info("Filled [stocks] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getStocksName).filter(Objects::nonNull).count());
		log.info("Filled [sectors] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getSectors).filter(Objects::nonNull).filter(Predicate.not(List::isEmpty)).count());
		log.info("Filled [country] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getCountry).filter(Objects::nonNull).count());
		log.info("Filled [share price] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getSharePriceUSD).filter(Objects::nonNull).count());
		log.info("Filled [founded on] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getFoundedOn).filter(Objects::nonNull).count());
		log.info("Filled [founders] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getFounders).filter(Objects::nonNull).filter(Predicate.not(List::isEmpty)).count());
		log.info("Filled [employees count] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getEmployeesCount).filter(Objects::nonNull).count());
		log.info("Filled [ceo] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getCeo).filter(Objects::nonNull).count());
		log.info("Filled [headquarters location] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getHeadquartersLocation).filter(Objects::nonNull).count());
		log.info("Filled [top competitor] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getTopCompetitor).filter(Objects::nonNull).count());
		log.info("Filled [telephone number] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getTelephoneNumber).filter(Objects::nonNull).count());
		log.info("Filled [followers by social] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getFollowersBySocial).filter(Objects::nonNull).filter(Predicate.not(Map::isEmpty)).count());
		log.info("Filled [urls] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getUrls).filter(Objects::nonNull).filter(Predicate.not(List::isEmpty)).count());
		log.info("Filled [market capitalization 2022] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getMarketCapitalization2022USD).filter(Objects::nonNull).count());
		log.info("Filled [revenue 2022] fields: {}", mergedList.stream().map(CompanyMediatedSchema::getRevenue2022USD).filter(Objects::nonNull).count());

		Map<Integer, Integer> filledFields = new HashMap<>();
		for (CompanyMediatedSchema company : mergedList) {
			int count = 0;

			if (company.getName() != null) count++;
			if (company.getStocksName() != null) count++;
			if (!company.getSectors().isEmpty()) count++;
			if (company.getCountry() != null) count++;
			if (company.getSharePriceUSD() != null) count++;
			if (company.getFoundedOn() != null) count++;
			if (!company.getFounders().isEmpty()) count++;
			if (company.getEmployeesCount() != null) count++;
			if (company.getCeo() != null) count++;
			if (company.getHeadquartersLocation() != null) count++;
			if (company.getTopCompetitor() != null) count++;
			if (company.getTelephoneNumber() != null) count++;
			if (!company.getFollowersBySocial().isEmpty()) count++;
			if (!company.getUrls().isEmpty()) count++;
			if (company.getMarketCapitalization2022USD() != null) count++;
			if (company.getRevenue2022USD() != null) count++;

			if (filledFields.containsKey(count)) {
				filledFields.put(count, filledFields.get(count) + 1);
			} else {
				filledFields.put(count, 1);
			}
		}
		log.info("#filled fields cardinality: {}", filledFields);
		log.info("Total filled fields: {}", filledFields.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum());
	}
}
