package mochotexto.dataset;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class CompanyMediatedSchema implements DatasetMapper {
	private String name;
	private String stocksName;
	private List<String> sectors;
	private String country;
	private Float sharePriceUSD;
	// TODO: valuate to use LocalDate
	private String foundedOn;
	private List<String> founders;
	private Integer employeesCount;
	private List<String> ceo;
	private String headquartersLocation;
	private String topCompetitor;
	private String telephoneNumber;
	private Map<String, Integer> followersBySocial;
	private List<String> urls;
	private Long marketCapitalization2022USD;
	private Long revenue2022USD;

	public static CompanyMediatedSchema of(DatasetMapper mapper) {
		// TODO: apply null-check and sanitize numbers
		return CompanyMediatedSchema.builder()
				.name(mapper.getName())
				.stocksName(mapper.getStocksName())
				.sectors(mapper.getSectors())
				.country(mapper.getCountry())
				.sharePriceUSD(mapper.getSharePriceUSD())
				.foundedOn(mapper.getFoundedOn())
				.founders(mapper.getFounders())
				.employeesCount(mapper.getEmployeesCount())
				.ceo(mapper.getCeo())
				.headquartersLocation(mapper.getHeadquartersLocation())
				.topCompetitor(mapper.getTopCompetitor())
				.telephoneNumber(mapper.getTelephoneNumber())
				.followersBySocial(mapper.getFollowersBySocial())
				.urls(mapper.getUrls())
				.marketCapitalization2022USD(mapper.getMarketCapitalization2022USD())
				.revenue2022USD(mapper.getRevenue2022USD())
				.build();
	}
}
