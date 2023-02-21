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
public class IgmmDisfoldSchema implements JsonDatasetMapper {
	@JsonProperty("name")
	private String _name;

	@JsonProperty("code")
	private String _code;

	@JsonProperty("rank")
	private String _rank;

	@JsonProperty("ceo")
	private String _ceo;

	@JsonProperty("country")
	private String _country;

	@JsonProperty("sector")
	private String _sector;

	@JsonProperty("industry")
	private String _industry;

	@JsonProperty("headquarters")
	private String _headquarters;

	@JsonProperty("employees")
	private String _employees;

	@JsonProperty("founded")
	private String _founded;

	@JsonProperty("marketcap")
	private String _marketcap;

	@JsonProperty("revenue")
	private String _revenue;

	@JsonProperty("net income")
	private String _netIncome;

	@JsonProperty("link")
	private List<String> _link;


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getStocksName() {
		return _code;
	}

	@Override
	public List<String> getSectors() {
		return ParsingUtils.makeSanitizedStringList(_sector, _industry);
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	public String getFoundedOn() {
		return _founded;
	}

	@Override
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	public Integer getEmployeesCount() {
		return ParsingUtils.sanitizeInteger(_employees);
	}

	@Override
	public String getCeo() {
		return _ceo;
	}

	@Override
	public String getHeadquartersLocation() {
		return _headquarters;
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
		return _link != null ? _link : Collections.emptyList();
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
