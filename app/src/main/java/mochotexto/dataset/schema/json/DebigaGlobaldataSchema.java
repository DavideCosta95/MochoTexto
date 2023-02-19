package mochotexto.dataset.schema.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.JsonDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class DebigaGlobaldataSchema implements JsonDatasetMapper {

	@JsonProperty("name")
	private String _name;

	@JsonProperty("headquarters")
	private String _headquarters;

	@JsonProperty("number_of_employees")
	private String _numberOfEmployees;

	@JsonProperty("address")
	private String _address;

	@JsonProperty("industry")
	private String _industry;

	@JsonProperty("website")
	private String _website;

	@JsonProperty("market_cap")
	private String _marketCap;

	@JsonProperty("telephone")
	private String _telephone;

	@JsonProperty("revenue")
	private String _revenue;

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
		return _industry != null ? List.of(_industry) : Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _headquarters;
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
		return Collections.emptyList();
	}

	@Override
	public String getHeadquartersLocation() {
		return _address;
	}

	@Override
	public String getTopCompetitor() {
		return null;
	}

	@Override
	public String getTelephoneNumber() {
		return _telephone;
	}

	@Override
	public Map<String, Integer> getFollowersBySocial() {
		return Collections.emptyMap();
	}

	@Override
	public List<String> getUrls() {
		return _website != null ? List.of(_website) : Collections.emptyList();
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
