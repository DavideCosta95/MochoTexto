package mochotexto.dataset.schema.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import mochotexto.dataset.mapper.JsonDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@Slf4j
public class DebigaWikipediaSchema implements JsonDatasetMapper {

	@JsonProperty("name")
	private String _name;

	@JsonProperty("type")
	private List<String> _type;

	@JsonProperty("industry")
	private List<String> _industry;

	@JsonProperty("founded")
	private List<String> _founded;

	@JsonProperty("founders")
	private List<String> _founders;

	@JsonProperty("headquarters")
	private List<String> _headquarters;

	@JsonProperty("key_people")
	private List<String> _keyPeople;

	@JsonProperty("services")
	private List<String> _services;

	@JsonProperty("revenue")
	private List<String> _revenue;

	@JsonProperty("operating_income")
	private List<String> _operatingIncome;

	@JsonProperty("total_assets")
	private List<String> _totalAssets;

	@JsonProperty("number_of_employees")
	private List<String> _numberOfEmployees;

	@JsonProperty("website")
	private List<String> _website;


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
		List<String> sectors = new ArrayList<>();
		if (_industry != null) {
			sectors.addAll(_industry);
		}
		if (_services != null) {
			sectors.addAll(_services);
		}
		return sectors;
	}

	@Override
	public String getCountry() {
		return null;
	}

	@Override
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	public String getFoundedOn() {
		return ParsingUtils.joinStringList(_founded, ", ");
	}

	@Override
	public List<String> getFounders() {
		return _founders != null ? _founders : Collections.emptyList();
	}

	@Override
	public Integer getEmployeesCount() {
		if (_numberOfEmployees == null || _numberOfEmployees.isEmpty()) {
			return null;
		}
		String rawCount = _numberOfEmployees.get(0)
				.trim()
				.split(" ")[0]
				.replace(",", "");
		try {
			return Integer.parseInt(rawCount);
		} catch (Exception e) {
			log.debug("Cannot parse {} as integer", rawCount);
			return null;
		}
	}

	@Override
	public String getCeo() {
		return null;
	}

	@Override
	public String getHeadquartersLocation() {
		return ParsingUtils.joinStringList(_headquarters, ", ");
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
		if (_website == null || _website.isEmpty()) {
			return Collections.emptyList();
		}
		return ParsingUtils.makeSanitizedStringList(ParsingUtils.joinStringList(_website, ""));
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
