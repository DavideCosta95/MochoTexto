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
public class GioponspizCompaniesmarketcapSchema implements JsonDatasetMapper {

	@JsonProperty("name")
	private String _name;

	@JsonProperty("codice")
	private String _codice;

	@JsonProperty("pricecap")
	private String _pricecap;

	@JsonProperty("price")
	private String _price;

	@JsonProperty("country")
	private String _country;


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getStocksName() {
		return _codice;
	}

	@Override
	public List<String> getSectors() {
		return Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public Float getSharePriceUSD() {
		return ParsingUtils.sanitizeCurrencyFloat(_price);
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
		return null;
	}

	@Override
	public String getCeo() {
		return null;
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
