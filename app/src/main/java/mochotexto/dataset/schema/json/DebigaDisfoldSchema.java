package mochotexto.dataset.schema.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.JsonDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class DebigaDisfoldSchema implements JsonDatasetMapper {

	@JsonProperty("name")
	private String _name;

	@JsonProperty("market_cap")
	private String _marketCap;

	@JsonProperty("stock")
	private String _stock;

	@JsonProperty("country")
	private String _country;

	@JsonProperty("sector")
	private String _sector;

	@JsonProperty("industry")
	private String _industry;

	@JsonProperty("headquarters")
	private String _headquarters;

	@JsonProperty("founded")
	private String _founded;

	@JsonProperty("employees")
	private String _employees;

	@JsonProperty("ceo")
	private String _ceo;


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getStocksName() {
		return _stock;
	}

	@Override
	public List<String> getSectors() {
		List<String> sectors = new ArrayList<>();
		if (_sector != null) {
			sectors.add(_sector);
		}
		if (_industry != null) {
			sectors.add(_industry);
		}
		return sectors;
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
	public List<String> getCeo() {
		return _ceo != null ? List.of(_ceo) : Collections.emptyList();
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
		return ParsingUtils.sanitizeCurrencyLong(_marketCap);
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
