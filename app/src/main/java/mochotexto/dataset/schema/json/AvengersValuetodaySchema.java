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
public class AvengersValuetodaySchema implements JsonDatasetMapper {
	@JsonProperty("id")
	private String _id;

	@JsonProperty("name")
	private String _name;

	@JsonProperty("world_rank")
	private String _worldRank;

	@JsonProperty("annual_revenue_in_usd")
	private String _annualRevenueInUsd;

	@JsonProperty("annual_net_income_in_usd")
	private String _annualNetIncomeInUsd;

	@JsonProperty("annual_results_for_year_ending")
	private String _annualResultsForYearEnding;

	@JsonProperty("total_assets_in_usd")
	private String _totalAssetsInUsd;

	@JsonProperty("total_liabilities_in_usd")
	private String _totalLiabilitiesInUsd;

	@JsonProperty("total_equity_in_usd")
	private String _totalEquityInUsd;

	@JsonProperty("headquarters_region_city")
	private String _headquartersRegionCity;

	@JsonProperty("headquarters_country")
	// because people does not know how to properly work
	private Object _headquartersCountry;

	@JsonProperty("headquarters_sub_region")
	private String _headquartersSubRegion;

	@JsonProperty("headquarters_continent")
	private String _headquartersContinent;

	@JsonProperty("company_business")
	// because people does not know how to properly work
	private Object _companyBusiness;

	@JsonProperty("number_of_employees")
	private String _numberOfEmployees;

	@JsonProperty("ceo")
	// because people does not know how to properly work
	private Object _ceo;

	@JsonProperty("founders")
	// because people does not know how to properly work
	private Object _founders;

	@JsonProperty("company_website")
	private String _companyWebsite;


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
		return ParsingUtils.parseStringList(_companyBusiness);
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
		return ParsingUtils.parseStringList(_founders);
	}

	@Override
	public Integer getEmployeesCount() {
		return ParsingUtils.sanitizeInteger(_numberOfEmployees);
	}

	@Override
	public List<String> getCeo() {
		return ParsingUtils.parseStringList(_ceo);
	}

	@Override
	public String getHeadquartersLocation() {
		return _headquartersRegionCity;
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
		return _companyWebsite != null ? List.of(_companyWebsite) : Collections.emptyList();
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return null;
	}

	@Override
	public Long getRevenue2022USD() {
		return ParsingUtils.sanitizeCurrencyLong(_annualRevenueInUsd);
	}
}
