package mochotexto.dataset.schemamapper;

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
public class SlytherinDisfoldSchema implements DatasetMapper {
	@JsonProperty("link")
	private String _link;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("headquarters")
	private String _headquarters;

	@JsonProperty("employees")
	private String _employees;

	@JsonProperty("ceo")
	private String _ceo;

	@JsonProperty("market_cap")
	private String _marketCap;


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
		return Collections.emptyList();
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
		return null;
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
		if (_ceo == null || _ceo.trim().equalsIgnoreCase("not found")) {
			return Collections.emptyList();
		}
		return List.of(_ceo);
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
		return Collections.emptyList();
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
