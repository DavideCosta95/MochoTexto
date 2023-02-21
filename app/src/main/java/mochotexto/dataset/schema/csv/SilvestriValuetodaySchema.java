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
@JsonPropertyOrder({"_ceo","_country","_market_value_jan_2020","_market_value_jan_2021","_market_value_jan_2022","_name","_employees_2022","_revenue_2022","_sector"})
public class SilvestriValuetodaySchema implements CsvDatasetMapper {
	private String _ceo;
	private String _country;
	private String _market_value_jan_2020;
	private String _market_value_jan_2021;
	private String _market_value_jan_2022;
	private String _name;
	private String _employees_2022;
	private String _revenue_2022;
	private String _sector;


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
		return ParsingUtils.parseStringList(_sector);
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
		return ParsingUtils.sanitizeInteger(_employees_2022);
	}

	@Override
	@JsonIgnore
	public String getCeo() {
		if (_ceo != null && !_ceo.equalsIgnoreCase("null")) {
			return _ceo;
		}
		return null;
	}

	@Override
	@JsonIgnore
	public String getHeadquartersLocation() {
		return null;
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

	// TODO: handle other years

	@Override
	@JsonIgnore
	public Long getMarketCapitalization2022USD() {
		return ParsingUtils.sanitizeCurrencyLong(_market_value_jan_2022);
	}

	@Override
	@JsonIgnore
	public Long getRevenue2022USD() {
		return ParsingUtils.sanitizeCurrencyLong(_revenue_2022);
	}
}
