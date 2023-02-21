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
public class AvengersHithorizonsSchema implements JsonDatasetMapper {

	@JsonProperty("id")
	private String _id;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("address")
	private String _address;

	@JsonProperty("nation")
	private String _nation;

	@JsonProperty("hhid")
	private String _hhid;

	@JsonProperty("industry")
	private String _industry;

	@JsonProperty("sic_code")
	private String _sicCode;

	@JsonProperty("type")
	private String _type;

	@JsonProperty("est_of_ownership")
	private String _estOfOwnership;

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
		return ParsingUtils.makeSanitizedStringList(_industry);
	}

	@Override
	public String getCountry() {
		return "Italy";
	}

	@Override
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	public String getFoundedOn() {
		return _estOfOwnership;
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
		return _address;
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
