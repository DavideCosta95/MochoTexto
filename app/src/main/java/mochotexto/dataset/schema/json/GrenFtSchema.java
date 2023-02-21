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
public class GrenFtSchema implements JsonDatasetMapper {
	@JsonProperty("name")
	private String _name;

	@JsonProperty("country")
	private String _country;

	@JsonProperty("sector")
	private String _sector;

	@JsonProperty("revenue_2020_EU")
	private String _revenue2020EU;

	@JsonProperty("revenue_2017_EU")
	private String _revenue2017EU;

	@JsonProperty("employees_number_2020")
	private String _employeesNumber2020;

	@JsonProperty("employees_number_2017")
	private String _employeesNumber2017;

	@JsonProperty("founding_year")
	private String _foundingYear;


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
		return ParsingUtils.makeSanitizedStringList(_sector);
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
		Integer parsed = ParsingUtils.sanitizeInteger(_foundingYear);
		return parsed != null ? parsed.toString() : null;
	}

	@Override
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	// TODO: handle employees count 2020
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
