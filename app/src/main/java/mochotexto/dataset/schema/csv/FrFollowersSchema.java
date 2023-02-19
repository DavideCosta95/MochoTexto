package mochotexto.dataset.schema.csv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Collections;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mochotexto.dataset.mapper.CsvDatasetMapper;
import mochotexto.parsing.util.ParsingUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@ToString
@JsonPropertyOrder({"_company", "_facebook", "_twitter", "_instagram", "_pinterest"})
public class FrFollowersSchema implements CsvDatasetMapper {
	private String _company;
	private String _facebook;
	private String _twitter;
	private String _instagram;
	private String _pinterest;


	@Override
	@JsonIgnore
	public String getName() {
		return _company;
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
		return null;
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
		Map<String, Integer> followers = new HashMap<>();

		if (_facebook != null) {
			String rawFacebookFollowers = _facebook.split(" ")[0].replace(".", "");
			Integer facebookFollowers = ParsingUtils.sanitizeInteger(rawFacebookFollowers);
			if (facebookFollowers != null) {
				followers.put("facebook", facebookFollowers);
			}
		}

		if (_twitter != null) {
			String rawTwitterFollowers = _twitter.replace(",", "§").replace(".", ",").replace("§", ".");
			Long twitterFollowers = ParsingUtils.sanitizeCurrencyLong(rawTwitterFollowers);
			if (twitterFollowers != null) {
				followers.put("twitter", twitterFollowers.intValue());
			}
		}

		Long instagramFollowers = ParsingUtils.sanitizeCurrencyLong(_instagram);
		if (instagramFollowers != null) {
			followers.put("instagram", instagramFollowers.intValue());
		}

		if (_pinterest != null) {
			String rawPinterestFollowers = _pinterest.replace("mila", "K").replace(",", ".");
			Long pinterestFollowers = ParsingUtils.sanitizeCurrencyLong(rawPinterestFollowers);
			if (pinterestFollowers != null) {
				followers.put("pinterest", pinterestFollowers.intValue());
			}
		}
		return followers;
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
