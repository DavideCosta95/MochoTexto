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
public class AvengersCompaniesmarketcapSchema implements DatasetMapper {
	@JsonProperty("id")
	private String _id;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("rank")
	private String _rank;

	@JsonProperty("market_cap")
	private String _marketCap;

	@JsonProperty("country")
	private String _country;

	@JsonProperty("share_price")
	private String _sharePrice;

	@JsonProperty("change_1_day")
	private String _change1Day;

	@JsonProperty("change_1_year")
	private String _change1Year;

	@JsonProperty("categories")
	private List<String> _categories;


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
		return _categories != null ? _categories : Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public Float getSharePriceUSD() {
		return ParsingUtils.sanitizeCurrencyFloat(_sharePrice);
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
	public List<String> getCeo() {
		return Collections.emptyList();
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
		return ParsingUtils.sanitizeCurrencyLong(_marketCap);
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
