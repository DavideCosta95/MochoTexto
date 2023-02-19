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
@JsonPropertyOrder({"_id","_name","_country","_sector","_absolute_growth_rate_pct","_compound_annual_growth_rate_cagr_pct","_revenue_2020_euro","_revenue_2017_euro","_number_of_employees_2020","_number_of_employees_2017","_founding_year"})
public class DddFtSchema implements CsvDatasetMapper {
	private String _id;
	private String _name;
	private String _country;
	private String _sector;
	private String _absolute_growth_rate_pct;
	private String _compound_annual_growth_rate_cagr_pct;
	private String _revenue_2020_euro;
	private String _revenue_2017_euro;
	private String _number_of_employees_2020;
	private String _number_of_employees_2017;
	private String _founding_year;


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
		return ParsingUtils.makeSanitizedStringList(_sector);
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
		return _founding_year;
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
	public List<String> getCeo() {
		return Collections.emptyList();
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
	// TODO: handle revenues and employees

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
