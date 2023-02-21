package mochotexto.dataset.schema;

import lombok.Builder;
import lombok.Data;
import mochotexto.dataset.mapper.DatasetMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@Builder
public class CompanyMediatedSchema implements DatasetMapper {
	private String name;
	private String stocksName;
	private List<String> sectors;
	private String country;
	private Float sharePriceUSD;
	private String foundedOn;
	private List<String> founders;
	private Integer employeesCount;
	private String ceo;
	private String headquartersLocation;
	private String topCompetitor;
	private String telephoneNumber;
	private Map<String, Integer> followersBySocial;
	private List<String> urls;
	private Long marketCapitalization2022USD;
	private Long revenue2022USD;

	public static CompanyMediatedSchema of(DatasetMapper mapper) {
		return CompanyMediatedSchema.builder()
				.name(sanitizeField(mapper.getName()))
				.stocksName(sanitizeField(mapper.getStocksName()))
				.sectors(sanitizeField(mapper.getSectors()))
				.country(sanitizeField(mapper.getCountry()))
				.sharePriceUSD(mapper.getSharePriceUSD())
				.foundedOn(sanitizeField(mapper.getFoundedOn()))
				.founders(sanitizeField(mapper.getFounders()))
				.employeesCount(mapper.getEmployeesCount())
				.ceo(sanitizeField(mapper.getCeo()))
				.headquartersLocation(sanitizeField(mapper.getHeadquartersLocation()))
				.topCompetitor(sanitizeField(mapper.getTopCompetitor()))
				.telephoneNumber(sanitizeField(mapper.getTelephoneNumber()))
				.followersBySocial(mapper.getFollowersBySocial())
				.urls(sanitizeField(mapper.getUrls()))
				.marketCapitalization2022USD(mapper.getMarketCapitalization2022USD())
				.revenue2022USD(mapper.getRevenue2022USD())
				.build();
	}

	private static String sanitizeField(String s) {
		return s == null || s.isBlank() ?
				null
				:
				s.trim();
	}

	private static List<String> sanitizeField(List<String> list) {
		return list == null ?
				Collections.emptyList()
				:
				list.stream()
						.filter(Objects::nonNull)
						.filter(Predicate.not(String::isBlank))
						.map(String::trim)
						.collect(Collectors.toList());
	}
}
