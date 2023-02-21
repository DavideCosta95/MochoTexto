package mochotexto.dataset.schema.csv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Collections;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.CsvDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@JsonPropertyOrder({"_id","_index","_url","_name","_trade_name","_address_name","_postal_code","_city","_state,_country","_location_type"})
public class WisselAziendeinfoclipperSchema implements CsvDatasetMapper {
	private String _id;
	private String _index;
	private String _url;
	private String _name;
	private String _trade_name;
	private String _address_name;
	private String _postal_code;
	private String _city;
	private String _state;
	private String _country;
	private String _location_type;


	@Override
	@JsonIgnore
	public String getName() {
		return _name;
	}

	@Override
	@JsonIgnore
	public String getStocksName() {
		return null;
	}

	@Override
	@JsonIgnore
	public List<String> getSectors() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public String getCountry() {
		return _country;
	}

	@Override
	@JsonIgnore
	public Float getSharePriceUSD() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getFoundedOn() {
		return null;
	}

	@Override
	@JsonIgnore
	public List<String> getFounders() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public Integer getEmployeesCount() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getCeo() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getHeadquartersLocation() {
		if (_location_type == null || !_location_type.equalsIgnoreCase("headquarter")) {
			return null;
		}
		return ParsingUtils.joinStringList(
				ParsingUtils.makeSanitizedStringList(_address_name, _postal_code.trim(), _city, _state),
				", ");
	}

	@Override
	@JsonIgnore
	public String getTopCompetitor() {
		return null;
	}

	@Override
	@JsonIgnore
	public String getTelephoneNumber() {
		return null;
	}

	@Override
	@JsonIgnore
	public Map<String, Integer> getFollowersBySocial() {
		return Collections.emptyMap();
	}

	@Override
	@JsonIgnore
	public List<String> getUrls() {
		return Collections.emptyList();
	}

	@Override
	@JsonIgnore
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	@JsonIgnore
	public Long getRevenue2022USD() {
		return null;
	}
}
