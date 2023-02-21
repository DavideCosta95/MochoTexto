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
import java.util.stream.Collectors;

@NoArgsConstructor
@Setter
@ToString
public class SlytherinValuetodaySchema implements JsonDatasetMapper {
	@JsonProperty("link")
	private String _link;

	@JsonProperty("rank")
	private String _rank;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("ceo")
	private String _ceo;

	@JsonProperty("founded")
	private String _founded;

	@JsonProperty("revenue")
	private String _revenue;

	@JsonProperty("country")
	private String _country;

	@JsonProperty("industry")
	// because people do not know how to properly work
	private Object _industry;


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
		return ParsingUtils.parseStringList(_industry).stream()
				.filter(s -> !s.trim().equalsIgnoreCase("not found"))
				.collect(Collectors.toList());
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
		return null;
	}

	@Override
	public String getCeo() {
		return _ceo != null && !_ceo.trim().equalsIgnoreCase("not found")
				?
				_ceo
				:
				null;
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
