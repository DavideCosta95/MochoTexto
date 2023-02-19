package mochotexto.dataset.schema.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.JsonDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class IgmmValuetodaySchema implements JsonDatasetMapper {
	@JsonProperty("name")
	private String _name;

	@JsonProperty("ceo")
	private String _ceo;

	@JsonProperty("market value (Jan-07-2022)")
	private String _marketValue2022;

	@JsonProperty("world rank (Jan-07-2022)")
	private String _worldRank2022;

	@JsonProperty("market value (Jan 1st 2020)")
	private String _marketValue2020;

	@JsonProperty("world rank (Jan-2020)")
	private String _worldRank2020;

	@JsonProperty("headquarters country")
	private String _headquartersCountry;

	@JsonProperty("number of employees")
	private String _numberOfEmployees;

	@JsonProperty("company business")
	private List<String> _companyBusiness;

	@JsonProperty("annual revenue in USD")
	private String _annualRevenueInUSD;

	@JsonProperty("annual net income in USD")
	private String _annualNetIncomeInUSD;

	@JsonProperty("company website")
	private String _companyWebsite;


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getStocksName() {
		return null;
	}

	@Override
	public List<String> getSectors() {
		return _companyBusiness!= null ? _companyBusiness : Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _headquartersCountry;
	}

	@Override
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	public String getFoundedOn() {
		return null;
	}

	@Override
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	public Integer getEmployeesCount() {
		return ParsingUtils.sanitizeInteger(_numberOfEmployees);
	}

	@Override
	public List<String> getCeo() {
		return _ceo != null ? List.of(_ceo) : Collections.emptyList();
	}

	@Override
	public String getHeadquartersLocation() {
		return null;
	}

	@Override
	public String getTopCompetitor() {
		return null;
	}

	@Override
	public String getTelephoneNumber() {
		return null;
	}

	@Override
	public Map<String, Integer> getFollowersBySocial() {
		return Collections.emptyMap();
	}

	@Override
	public List<String> getUrls() {
		return _companyWebsite != null ? List.of(_companyWebsite) : Collections.emptyList();
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	public Long getRevenue2022USD() {
		// TODO
		return null;
	}
}
