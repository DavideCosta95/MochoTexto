package mochotexto.dataset.schemamapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.DatasetMapper;
import mochotexto.dataset.util.ParsingUtils;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AvengersDisfoldSchema implements DatasetMapper {

	@JsonProperty("id")
	private String _id;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("official_name")
	private String _officialName;

	@JsonProperty("headquarters_country")
	private String _headquartersCountry;

	@JsonProperty("headquarters_continent")
	private String _headquartersContinent;

	@JsonProperty("founded")
	private String _founded;

	@JsonProperty("employees")
	private String _employees;

	@JsonProperty("ceo")
	private String _ceo;

	@JsonProperty("market_cap")
	private String _marketCap;

	@JsonProperty("categories")
	private List<String> _categories;


	@Override
	public String getName() {
		return _officialName;
	}

	@Override
	public String getStocksName() {
		return null;
	}

	@Override
	public List<String> getSectors() {
		return _categories != null ? _categories : Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _headquartersContinent;
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
	public List<String> getCeo() {
		return _ceo != null ? List.of(_ceo) : Collections.emptyList();
	}

	@Override
	public String getHeadquartersLocation() {
		return _headquartersCountry;
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
		return Collections.emptyList();
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return ParsingUtils.sanitizeCurrencyLong(_marketCap);
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
