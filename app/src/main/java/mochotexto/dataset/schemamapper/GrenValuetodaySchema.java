package mochotexto.dataset.schemamapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.DatasetMapper;
import mochotexto.dataset.util.ParsingUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
public class GrenValuetodaySchema implements DatasetMapper {
	@JsonProperty("name")
	private String _name;

	@JsonProperty("annual_revenue_USD")
	private String _annualRevenueUSD;

	@JsonProperty("annual_net_income_USD")
	private String _annualNetIncomeUSD;

	@JsonProperty("market_capitalization_2022")
	private String _marketCapitalization2022;

	@JsonProperty("employees_number")
	private String _employeesNumber;

	@JsonProperty("CEO")
	private String _ceo;

	@JsonProperty("headquarters_country")
	private String _headquartersCountry;

	@JsonProperty("wikipedia_page_url")
	private String _wikipediaPageUrl;

	@JsonProperty("twitter_page_url")
	private String _twitterPageUrl;

	@JsonProperty("facebook_page_url")
	private String _facebookPageUrl;



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
		return Collections.emptyList();
	}

	@Override
	public String getCountry() {
		return _headquartersCountry;
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
		return Collections.emptyList();
	}

	@Override
	public Integer getEmployeesCount() {
		return ParsingUtils.sanitizeInteger(_employeesNumber);
	}

	@Override
	public List<String> getCeo() {
		return _ceo != null ? List.of(_ceo) : Collections.emptyList();
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
		List<String> urls = new ArrayList<>();
		if (_wikipediaPageUrl != null) {
			urls.add(_wikipediaPageUrl);
		}
		if (_twitterPageUrl != null) {
			urls.add(_twitterPageUrl);
		}
		if (_facebookPageUrl != null) {
			urls.add(_facebookPageUrl);
		}
		return urls;
	}

	@Override
	public Long getMarketCapitalization2022USD() {
		return ParsingUtils.sanitizeCurrencyLong(_marketCapitalization2022);
	}

	@Override
	public Long getRevenue2022USD() {
		return null;
	}
}
